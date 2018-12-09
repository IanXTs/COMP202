public class GradingProgram {
  public static void main (String[] args){
  double firstMark = Double.parseDouble(args[0]); 
  double secondMark = Double.parseDouble(args[1]);
  double thirdMark = Double.parseDouble(args[2]);  
  // set up and define the three variable (three marks)
  printInput(firstMark, secondMark, thirdMark); //callin the printInput method
  divide1(firstMark, secondMark); // calling the divide method
  divide2(firstMark, thirdMark); //calling the divde2 method
  finalGrade(firstMark, secondMark, thirdMark); //calling the last finalGrade method
  }
  public static void printInput(double firstMark, double secondMark, double thirdMark){
  System.out.println("You entered "+ firstMark + ", " + secondMark + ", and " + thirdMark);
  }
  public static double divide1(double firstMark, double secondMark){
  if (secondMark == 0) {
    System.out.println("Error");
    return 0;
   }
  else {
    double devide1= firstMark/secondMark;
    return devide1;
  }
  }
  // condition for 0 being the denominator
  // and so if 0 is not 0 we divide the two
  
  public static double divide2(double firstMark, double thirdMark){
    double divide2 = ((firstMark+thirdMark)/80)*100;
    return divide2;
    //calculate the grade by using second method when midterm grade is 0
  }
  
  public static double getMax (double firstMark, double secondMark, double thirdMark){
   if (divide1(firstMark+secondMark+thirdMark,1) >divide2(firstMark, thirdMark)) {
   return divide1(firstMark+secondMark+thirdMark,1);
   }
   else {
   return divide2(firstMark, thirdMark);
   }
   //use getMax method to find the greater grade
  }
  public static void finalGrade(double firstMark, double secondMark, double thirdMark) {
      System.out.println("the final grade is "+ getMax(firstMark, secondMark, thirdMark) + "%");
    // and finally print out the final grade
    }              
  }