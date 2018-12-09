//Student Name: Ian Tsai
//Student Number: 260741766

public class Farm {
    //main method for testing
  public static void main(String[] args) {
    
  }

  private Sheep[] sheeps;
  private Dog herder;
  private String name;
  //the three private attributes
  //constructor that takes two strings(name and herder) and an array sheeps
  public Farm(String name, Dog herder, Sheep[] sheeps) {
    this.name = name;
    this.herder = herder;
    if (sheeps.length > herder.herd()) {
      throw new IllegalArgumentException("The dog can only herd " + herder.herd() +" sheep, while there are " + sheeps.length + " sheep!"); 
    }
    this.sheeps = new Sheep[sheeps.length];
    //for loop iterating through each sheep and copying over
    for (int i = 0; i < sheeps.length; i++) {
      this.sheeps[i] = sheeps[i];
    }
  }
  
  ////the method that returns the farm name
  public String getName() {
    return this.name; 
  }
  
  //the method that returns farm's number of sheep
  public int getNumSheep() {
    return this.sheeps.length; 
  }
  
  public void printFarm() { //we use this method to print the attributes from getter methods
    System.out.println("Farm name: " + this.name + " Dog name: " + herder.getName());
    //we use a for loop for each sheep and its corrresponf attributes
    for (int i = 0; i < sheeps.length; i++) {
      System.out.println("Sheep #" + (i + 1) + " - Name: " + sheeps[i].getName() + " age: " + sheeps[i].getAge() + " ");
    }
  }
  
  public double getWool() {
    double woolSheared = 0;
    for (int i = 0; i < sheeps.length; i++) {
      woolSheared += sheeps[i].shear(); //total wool sheared
    }
    return woolSheared;
  }
  
}