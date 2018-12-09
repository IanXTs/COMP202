public class Cipher {
  public static void main(String[] args) { 
  System.out.println(vigenereEncode("elepahnts and hippos", "rats"));   
  }
  public static char charRightShift(char character, int n){
      if(n >25||n <0){//set the number n to be 0<n<25
      character = (char)(0);
      System.out.println("Error! n is larger than 25 or less than 0");
      return character;}
      else {
      if ((char)(character)>122||(char)(character)<97){
        char result = (char)(character);
        return result; //return the result after the character is the boundry
      }
      else if ((char)(character)+n>122){
       char result = (char)(character+n-26); 
       return result; // return to the first result after 
      }
       else{
    char result = (char)(character+n);
    return result;
    }//last else statement with do the rest which will be character+n
  }
}
  //inverse of the first method
  public static char charLeftShift(char character, int n){
      if(n >25||n <0){
      character = (char)(0);
      System.out.println("Error! n is larger than 25 or less than 0");
      return character;
    }      
      else {
      if ((char)(character)>122||(char)(character)<97){
        char result = (char)(character);
        return result;
      }//return the result after the character is the boundry
       else if ((char)(character)-n<97)
       {
       char result = (char)(character-n+26);
       return result;// return to the first result after 
      }
       else{
    char result = (char)(character-n);
    return result;//last else statement with do the rest which will be character-n(since this is left, we use - sign)
    }
  }
      } 
  public static String caesarEncode(String message, int key){
    //we first eliminate the exceptions using an if statement
    if(key>25 || key <0){
      System.out.println("The key is not from 0 to 25");
      String empty = " ";
      return empty;
    } 
    else { // and now we can set a string variable 
      String origin = "";
    for(int i = 0; i < message.length(); i++){
    char Letter = message.charAt(i);//split to single character
    if (Letter == 32){
      origin = origin + " ";//if the space which is character that is 32
    }else{
      char a = charRightShift(Letter, key);//shift certain ways
      String b = "" + a;
      origin = origin + b;
    }
    }
     return origin;
    }
  }  
  // since now we are doing the charleftshift we can simple us the above method but mirror it to make it reverse
  public static String caesarDecode(String message, int key){
    if(key>25 || key <0){
      System.out.println("The key is not from 0 to 25");
      String empty = " ";
      return empty;
    } 
    else {
      String origin = "";
    for(int i = 0; i < message.length(); i++){
    char Letter = message.charAt(i);
    if (Letter == 32){
      origin = origin + " ";
    }else{
      char a = charLeftShift(Letter, key);
      String b = "" + a;
      origin = origin + b;
    }
    }
     return origin;
    }
  }
  // the following methods take care of the rightshift characters
  public static int[] obtainKeys (String key) {
    int[] keyInteger = new int[key.length()];
    for(int j= 0; j < key.length();j++) {
      // in order to fit the keyinteger we mius key by 97
      keyInteger[j]=key.charAt(j)-97;
    }
    return keyInteger;
  }
public static String vigenereEncode( String message, String keyword) {
  String string = "";
  if(keyword.length()<message.length()){
    int round = message.length()/keyword.length();// the time of the round
    int remain = message.length() % keyword.length();// the remain after final round
    for (int j=0; j < round -1; j++){
      keyword = keyword + keyword; //fine keyword"s"
    }
    for( int i =0; i <remain; i++){// add in the remain
      keyword = keyword + keyword.charAt(i);
    }
    for( int h =0; h<message.length(); h++){
      int[] key = obtainKeys(keyword);
      int loop = key[h];
      char currentChar = charRightShift(message.charAt(h), loop);
      string = string + currentChar;
    }
  }
  else{
    for(int i = 0; i < message.length(); i++){ //single round exception
      int[] key = obtainKeys(keyword);
      int loop = key[i];
      char currentChar = charRightShift(message.charAt(i), loop);
      string = string + currentChar; 
    }
  }
  return string;
}
public static String vigenereDecode( String message, String keyword) {
  String string = "";
  //we first us an if statement so the keyword and message can fit
  if(keyword.length()<message.length()){
    int round = message.length()/keyword.length();
    int remain = message.length() % keyword.length();
    for (int j=0; j < round -1; j++){
      keyword = keyword + keyword;
    }
    for( int i =0; i <remain; i++){// solve remain and add up the keyword"s"
      keyword = keyword + keyword.charAt(i);
    }
    for( int h =0; h<message.length(); h++){
      int[] key = obtainKeys(keyword);
      int loop = key[h];
      char currentChar = charLeftShift(message.charAt(h), loop);
      string = string + currentChar;
    }
  }
  else{
    for(int i = 0; i < message.length(); i++){
      int[] key = obtainKeys(keyword);
      int loop = key[i]; 
      char currentChar = charLeftShift(message.charAt(i), loop);
      string = string + currentChar;
    }
  }
  return string;
// and finally find out the result
}
}
// sorry I kinda wrote too monay comments this time. Thanks for your time!
  
 
