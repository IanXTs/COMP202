//Student Name: Ian Tsai
//Student Number: 260741766

//importing classes
import java.io.*; 
import java.util.ArrayList; 

public class FileIO {
  
  //method that creates a Character after rading a file
  public static Character readCharacter(String filename) {
    //private attributes
    String name = "";
    double atk = 0;
    double maxHp = 0;
    int numWins = 0;
    Character c;
    
    //we use this try block to see the errors
    try {
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);
      
      //setting the inputs in order: name, atk value, max health value, number of wins
      name = br.readLine();
      atk = Double.parseDouble(br.readLine());
      maxHp = Double.parseDouble(br.readLine());
      numWins = Integer.parseInt(br.readLine());
      
      //the 4 character variables that need to be returned
      c = new Character(name, atk, maxHp, numWins);
      
      fr.close();
      br.close();
    } 
    catch (FileNotFoundException e) { 
      throw new IllegalArgumentException("Could not find the file: " + filename);
    }
    catch (IOException e) {
      throw new IllegalArgumentException("Problem with the file: " + filename);
    }
    
    return c;
  }
  
  
  //this method will create an ArrayList of Spells after reading the text file
  public static ArrayList<Spell> readSpells(String filename) {
    ArrayList<Spell> spells = new ArrayList<Spell>();
    //we first give an empty list
    //handling errors when file reading in a try block
    try {
      //creating new objects for reading file
      FileReader fr = new FileReader(filename);
      BufferedReader br = new BufferedReader(fr);
      
      //reads the first line to be split in the first iteration
      String currentLine = br.readLine();
      
      //looping until an empty line
      while (currentLine != null) {
        //splitting the line and setting variables to each split string
        String[] spellLine = currentLine.split(" ");
        String name = spellLine[0];
        double minDamage = Double.parseDouble(spellLine[1]); //using Double.parseDouble to convert Strings to double
        double maxDamage = Double.parseDouble(spellLine [2]);
        double spellChance = Double.parseDouble(spellLine[3]);
        
        //creating a new Spell from values in file and adding to the ArrayList
        Spell sp = new Spell(name, minDamage, maxDamage, spellChance);
        spells.add(sp);
        
        //reads the next line for the next iteration, will be null when on the last line
        currentLine = br.readLine(); 
      }
      
      //closing the file and buffered readers
      fr.close();
      br.close();
    }
    //catching and throwing exceptions with messages
    catch (FileNotFoundException e) {
      throw new IllegalArgumentException("Could not find the file: " + filename);
    }
    catch (IOException e) {
      throw new IllegalArgumentException("Problem with the file: " + filename);
    }
    
    return spells;
  }
  
 
  //this method can rewrite the file as character attributes
  public static void writeCharacter(Character character, String filename) { 
    //trying errors in this try block
    try {
      FileWriter fw = new FileWriter(filename);
      BufferedWriter bw = new BufferedWriter(fw);
      
      //calling variables with getters from Character
      String charName = character.getName();
      double charAtk = character.getAtk();
      double charMaxHp = character.getMaxHp();
      int charNumWins = character.getNumWins();
      
      //declaring the new attribute values in the file on new lines
      bw.write(charName + "\n");
      bw.write(charAtk + "\n");
      bw.write(charMaxHp + "\n");
      bw.write(charNumWins + "\n");
      
      //and now we can close the file writers and the buddered writers
      bw.close();
      fw.close();
    }
    //we catch and thow the exceptions with a new message
    catch (IOException e) {
      throw new IllegalArgumentException("Problem with the file: " + filename);
    }
  }
  
  //main method
  public static void main(String[] args) {
    Character guy = readCharacter("player.txt"); 
    System.out.println(guy);
    ArrayList<Spell> spells = readSpells("spells.txt");
    System.out.println(spells);
    writeCharacter(guy, "player.txt");
  }
  
}