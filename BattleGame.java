//Student Name: Ian Tsai
//Student Number: 260741766

//importing classes so we can use them
import java.util.Scanner;
import java.util.ArrayList;

public class BattleGame {
  
  //method to start a battle
  public void playGame() {
    //use characters "textfiles" from FileIO
    Character player = FileIO.readCharacter("player.txt");
    Character monster = FileIO.readCharacter("monster.txt");
    
    //declaringFileIO with a spell ArryList from the given text file
    ArrayList<Spell> playerSpells = FileIO.readSpells("spells.txt");
    player.setSpells(playerSpells); //sets the players spells
    
    //
    System.out.print("You are ");
    player.printStats();
    System.out.print("You have encountered ");
    monster.printStats();
    System.out.println();
    //the above codes will print the name of the palyers and the monsters
    System.out.println("Available spells:");
    //for loop each spell for printing
    for (int i = 0; i < playerSpells.size(); i++) {
      System.out.println(playerSpells.get(i));
    }
    System.out.println();
  
    Scanner scan = new Scanner(System.in);
    
    //a while loop for an encounter and we initialize it with a boolean
    boolean keepLooping = true;
    while (keepLooping) {
      System.out.println("Your command was not recognized. Try 'attack' or 'quit'.");
      String command = scan.nextLine().toLowerCase(); //using the toLowerCase method to get the lower case command
      
      //player attacks monster if the command is attack
      if (command.equals("attack")) {
        doAttack(player, monster);
      }
      //or you will quit the battle and the comand will show and print "You've left the battle. See You Again!"
      else if (command.equals("quit")) {
        System.out.println("You've left the battle. See You Again!");
        break;
      }
      //and the leftover command are the spells 
      else {
        double spellDamage = player.castSpell(command);
        monster.takeDamage(spellDamage);
        System.out.println(monster);
        System.out.println();
      }
      
      //if the monster gets killed
      if (monster.getCurrentHp() <= 0) {
        keepLooping = false; //stop the loop
        //print the winning message and increase the number of wins by 1
        System.out.println("Congratulations! You've defeated " + monster.getName() + "!");
        player.increaseWins();
        System.out.println(player.getName() + " now has " + player.getNumWins() + " wins!");
        //writing updated stats to the player file with FileIO
        FileIO.writeCharacter(player, "player.txt");
      }
      //if the moster is still alive( so we use an else here so the monster can attack more
      else {
        doAttack(monster, player);
        
        //if the player is dead
        if (player.getCurrentHp() <= 0) {
          keepLooping = false; //stops the loop
          //print the loosing messages and increase number of wins of monster to the text data
          System.out.println("Sorry! You have lost against " + monster.getName() + "!");
          monster.increaseWins();
          System.out.println(monster.getName() + " now has " + monster.getNumWins() + " wins!");
          //update the status of the specific monster with FileIO after each fight 
          FileIO.writeCharacter(monster, "monster.txt");
        }
      }
    }
  }
  
  //the ultimate method if the two characters attack each other
  public void doAttack(Character attacker, Character defender) {
    double damage = attacker.calcAttack(); //applying alcAttack method
    String damageStr = String.format("%1$.2f", damage); //show two decimal places of the attack damage
    System.out.println(attacker.getName() + " deals " + damageStr + " points of damage!"); 
    defender.takeDamage(damage); //calls Character takeDamage() method
    
    //the condition if the defender is still alive
    if (defender.getCurrentHp() > 0) {
      System.out.println(defender); //using the Character toString method
      System.out.println();
    }
    //else shows a defeat message
    else {
      System.out.println("Oh no!"+defender + " --- " + defender.getName() + " has been killed!");
      System.out.println();
    } 
  }
  
  //the final main method to play the game
  public static void main(String[] args) {
    BattleGame game = new BattleGame();
    game.playGame(); 
  }
  
}