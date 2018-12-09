//Student Name: Ian Tsai
//Student Number: 260741766

import java.util.Random; //importing Random class
import java.util.ArrayList;

public class Character {
  //private attributes
  private String name; //string
  private double atk; //and numbers variables
  private double maxHp;
  private double currentHp;
  private int numWins;
  private static Random randNumGen = new Random();//to give a random number 
  //declaring the Spell ArrayList
  private static ArrayList<Spell> spells = new ArrayList<Spell>();
  
  //construct parameters represent the name, attack value, maximum health, and number of wins
  public Character(String name, double atk, double maxHp, int numWins) {
    this.name = name;
    this.atk = atk;
    this.maxHp = maxHp;
    this.currentHp = maxHp;
    this.numWins = numWins;
  }
  
  //method returning a modified attack value
  public double calcAttack() {
    //times the attack value by a random value between 0.3 to 0.7
    double atkModifier = (randNumGen.nextDouble() * 0.4) + 0.3;
    double modifiedAtk = atk * atkModifier;
    return modifiedAtk;
  }
  
  //method calculating the currentHp and take the input as the damageTaken
  public void takeDamage(double damageTaken) {
    currentHp -= damageTaken;
  }
  
  //increase the number of wins by the character by one, and does not return anything.
  public void increaseWins() {
    numWins += 1;
  } //this method will only be called if the player wins a game
  
  //the following five methods will return character name,character's current health,character atk,character max health,and character number of wins
  public String getName() {
    return name; 
  }
  
  public double getCurrentHp() {
    return currentHp;
  }

  public double getAtk() {
    return atk; 
  }
  
  public double getMaxHp() {
    return maxHp; 
  }

  public int getNumWins() {
    return numWins; 
  }
  
  //we use this method to print the Character name and its health in BattleGame
  public String toString() {
    //give an empty string
    String s = "";
    String hpString = String.format("%1$.2f", this.currentHp); //String.format to display two decimal places
    s += (this.name + " has " + hpString + " hitpoints");
    return s;
  }
  
  //the method that actually prints out the name currentHp atk and num of wins in this game
  public void printStats() {
    //give an empty string
    String s = "";
    s += (this.name + ": " + this.currentHp + " hitpoints, " + this.atk + " attack, " + this.numWins + " wins");
    System.out.println(s);
  }
  
  //we call the text fill spelllist in this method
  public void setSpells(ArrayList<Spell> spellList) {
    this.spells = spellList;
  }
  
   
  public double castSpell(String spellName) {
    //declaring variable
    double spellDamage = 0;
    
    //for loop the entire spelllist from the array list
    for (int i = 0; i < spells.size(); i++) {
      Spell s = spells.get(i); 
      String sLowerCase = s.getName().toLowerCase();
      //casts a spell if the input spell is in the array list
      if (sLowerCase.equals(spellName.toLowerCase())) {
        spellDamage = s.getDamage();
        String spellDamageStr = String.format("%1$.2f", spellDamage); //format spellDamage to 2 decimal points
        
        //if the spell does dmg, the method will show or else you failed to cast
        if (spellDamage > 0) {
          System.out.println(this.name + " succesfully casts " + spellName + " for " + spellDamageStr + " damage!");
        } 
        else {
          System.out.println(this.name + " failed to cast " + spellName + "."); 
        }
        
        return spellDamage; 
      }
    }
    
    //this is the case where no spell is inputed we return to this statement
    System.out.println(this.name + " tried to cast " + spellName + ", an unknown spell! No damage is dealt.");
    return spellDamage;
  }
  
  //main method
  public static void main(String[] args) {
    Character k = new Character("IanAlubaMaster", 1, 70, 420);
    System.out.println(k);
    System.out.println(k.castSpell("fireball"));
    k.setSpells(FileIO.readSpells("spells.txt"));
    System.out.println(k.spells);
  }
}