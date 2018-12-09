//Student Name: Ian Tsai
//Student Number: 260741766

import java.util.Random; //importing the Random object so we can use it

public class Spell {
  
  //private attributes
  private String name;//string attribute
  private double minDamage; // and the 4 other attributes
  private double maxDamage;
  private double spellChance;
  private static Random randNumGen = new Random();
  
  ////construct parameters represent the name, attack value, maximum health, and the chance for spell to hit
  public Spell(String name, double minDamage, double maxDamage, double spellChance) {
    this.name = name;
    this.minDamage = minDamage;
    this.maxDamage = maxDamage;
    this.spellChance = spellChance;
    
    //if statement if the minimun damge is not btw 0 to max damamge
    if (minDamage < 0 || minDamage > maxDamage) {
      throw new IllegalArgumentException("The minimum damage of the spell, " + this.name + ", has to be between 0 and the maximum damage!");
    }
    //or else it executes the spell inputed
    else if (spellChance < 0 || spellChance > 1) { 
      throw new IllegalArgumentException("The success chance of the spell, " + this.name + ", has to be between 0 and 1!");
    }
  }
  
  //getter method that returns the Spell name
  public String getName() {
    return name; 
  }
  
  public double getDamage() {
    //choosing a damage tandom chance between 0 and 1
    double damage = 0;
    double randChance = randNumGen.nextDouble();
    
    //if spell goes through
    if (spellChance > randChance) { 
      //calculation to get the range and add it to the minimum damage
      damage = ((maxDamage - minDamage) * randNumGen.nextDouble()) + minDamage; 
    }
    
    return damage;
  }
  
  //toString method to print the Spell
  public String toString() {
    //giving an empty string 
    String s = "";
    s += this.name + " -- Damage: " + this.minDamage + "-" + this.maxDamage + " Accuracy: " + (spellChance*100) + "%"; 
    return s;
  }
  
  //main method
  public static void main(String[] args) {
    Spell leviosa = new Spell("Wingardium leviosa", 1, 4, 0.5);
    System.out.println(leviosa);
  }
  
}