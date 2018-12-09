import java.util.Random;
//Student Name: Ian tsai
//Student Number: 260741766
public class Sheep {
  public static void main(String[] args) { //creating a main method for testing
  }

  private String name;
  private int age;
  private boolean hasWool;////the private attributes
  private static Random numberGenerator = new Random(123);
  
  //set up two strings that tkae the input name and age
  public Sheep(String name, int age) {
    this.name = name;
    this.age = age;
    this.hasWool = true;
  }
  
  //the method that returns the sheep name
  public String getName() {
    return name; 
  }
  
  //getter method that returns the sheep's age
  public int getAge() {
    return age;  //then return age
  }
  
  //method returning a random amount of wool sheared from 6-10
  public double shear() {
    double woolSheared = 0;
    if (hasWool) {
      //calling .nextDouble() and multiplying by 4 to get a range of 4 random numbers
      woolSheared = (numberGenerator.nextDouble() * 4 + 6);
      hasWool = false;
    }
    return woolSheared;
  }
  
  //toString method for printing instances
  public String toString() {
    //contetenates and returns a string
    String s = "";
    s += "name: " + this.name + " age: " + this.age;
    s += " sheared: " + this.shear();
    return s;
  }
  
  
}