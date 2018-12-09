//Student Name: Ian Tsai
//Student Number: 260741766

public class Dog {
  
  public static void main(String[] args) { //calling a main method for testing
  }
  
  private String name;
  private String breed;//the two private attributes  
  public Dog(String name, String breed) { // construct two strings that take name and breed
    this.name = name;
    this.breed = breed;
  }
  
  public String getName() {
    return this.name;
    //the method that returns dog name
  }
  
  public int herd() {//method returning limit of sheep herded based on breed
    int herdNum = 0;
    //converting the breed to lower case
    String lowerCaseBreed = breed.toLowerCase();
    //to ensure that all cases are in lover case so we call lowercasebreed
    if (lowerCaseBreed.contains("collie")) {
      herdNum = 20; 
    } 
    else if (lowerCaseBreed.contains("shepherd")) {
      herdNum = 25;
    } 
    else if (lowerCaseBreed.contains("kelpie") || lowerCaseBreed.contains("teruven")) {
      herdNum = 30;
    } 
    else {
      herdNum = 10;   
    }
    return herdNum;
  }
  
  public String toString() { //this moethod is for printing instances
    String s = "";
    s += "Name: " + this.name + " breed: " + this.breed;
    s += " Herd: " + this.herd();
    return s;
  }
  
}