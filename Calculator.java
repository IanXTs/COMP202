public class Calculator {
  public static void main(String[] args) {
  double a = Double.parseDouble(args[0]);
  // first double variable a
  double b = Double.parseDouble(args[1]);
  // second double variable b
  double c = Double.parseDouble(args[2]);
  // third double variable c
  double FirstResult = (a + b);
  int FirstResultInInt = (int)FirstResult;
  // casting for FirstResult
  System.out.println("Sum of a and b: " + FirstResultInInt);
  double SecondResult = (a*b);
  int SecondResultInInt = (int)SecondResult;
  // casting for SecondResult
  System.out.println("Product of a and b: " + SecondResultInInt);
  double ADevidedByB = a/b;
  int ADevidedByBInInt = (int)ADevidedByB;
  System.out.println("Dividing a by b: " + ADevidedByBInInt);
  // casting and calculation for ADevidedByB
  double ADevidedByC= a/c;
  System.out.println("Dividing a by c: " + ADevidedByC);
  boolean isalarger = a < b;
  // boolean true ot false
  System.out.println("Is a larger than b: " + isalarger);
  if (a%2 == 0) {     //if statement   
    System.out.println("Is a odd: false");} 
  else {       
    System.out.println("Is a odd: true"); }
  // a is even or odd
 }
}