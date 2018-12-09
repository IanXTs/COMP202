public class Gambling{
  public static void main(String[] args){
    double originalmoeny = Double.parseDouble(args[0]);
    double gamble = Double.parseDouble(args[1]);
    originalmoeny = passLineBet(originalmoeny, gamble);
    System.out.println("You now have: $"+originalmoeny); 
  }
  public static int diceRoll(){
    int firstDice = (int)Math.ceil(6*Math.random());// using Math.radom() to choose a number in between 1 to 6
    int secondDice = (int)Math.ceil(6*Math.random());// using Math.radom() to choose a number in between 1 to 6
    return firstDice + secondDice;
  }// as it is titled, this method roll the dice
  public static int secondStage(int a){
    int comeoutroll = diceRoll();
    while (comeoutroll != 7 && comeoutroll != a){
      System.out.print(comeoutroll+","+" ");
      comeoutroll = diceRoll();
    }// using a while statement to eliminate the
    System.out.println(comeoutroll);
    return comeoutroll;
  }
  // this boolean method is the third part of the assignment
  public static boolean canPlay(double originalmoeny, double gamble){
    if(originalmoeny > 0.0 && originalmoeny >= gamble){// return true if originalmoeny is greater than gamble
      return true;}
    else{
      return false;
    }
  }
  public static double passLineBet(double originalmoeny, double gamble){
    if(!canPlay(originalmoeny,gamble)){
      System.out.println("Insufficient funds. You cannot play!");
      return originalmoeny;}
    else{
      int firstRoll = diceRoll();
      if(firstRoll == 7 || firstRoll == 11){
        System.out.println("A "+firstRoll+" has been rolled. You win!");
        originalmoeny = originalmoeny + gamble;
        return originalmoeny;}
        //keep repeating the diceRoll() method for dice rolling
      else if(firstRoll == 2 || firstRoll == 3 || firstRoll == 12){
        System.out.println("A "+firstRoll+" has been rolled. You lose!");
        originalmoeny = originalmoeny - gamble;
        return originalmoeny;}
      else{
        System.out.println("A "+firstRoll+" has been rolled. Roll again!");
        int secondRoll = secondStage(firstRoll);
        if (secondRoll == 7){
          System.out.println("You lose!");
          originalmoeny = originalmoeny-gamble;
          return originalmoeny;}
        else{
          System.out.println("You win!");
          originalmoeny = originalmoeny+gamble;
          return originalmoeny;
}
    }
   }
  }   
}