import java.util.Scanner;
import java.util.Random;
//Student Name: Ian Tsai
//Student Number: 260741766
public class WoolFactory{
  //The provided code generates random ages for sheep, and picks random names from the below array
  //You can modify this list of names as you wish (add/remove/replace elements).
  private static String[] namesForSheep = {"Cerdic","Cynric","Ceawlin","Ceol","Ceolwulf","Cynegils",
    "Cenwalh","Seaxburh","Aescwine","Centwine","Ceadwalla","Ine","Aethelheard","Cuthred","Cynewulf",
    "Berhtric","Egbert","Aethelwulf","Aethelbald","Aethelberht","Aethelred","Hengest","Aesc","Octa",
    "Eormenric","Aethelbert I","Eadbald","Earconbert","Egbert I","Hlothere","Oswine","Wihtred",
    "Aethelbert II","Sigered","Egbert II","Eadberht II","Cuthred","Baldred","Aethelfrith","Edwin","St. Oswald",
    "Oswiu","Ecgfrith","Aldfrith","Osred I","Cenred","Osric","Ceolwulf","Eadberht",
    "Aethelwald","Alhred","Aethelred I","Aelfwald I","Eardwulf","Eanred","George V","Edward VIII",
    "George VI","Elizabeth II"};
  private static Random r = new Random(123);
  
  //returns a random String from the above array. 
  private static String getRandomName(){
    int index = r.nextInt(namesForSheep.length);
    return namesForSheep[index];
  }
  //returns a random age for a sheep from 1 to 10
  private static int getRandomAge(){
    return r.nextInt(10)+1;
  }
  //End of provided name/age generation code. 
  
  public static void main(String[] args){
    //Student Name: Ian Tsai
    //Student Number: 260741766
    //Your code goes here.
    
    Scanner scan = new Scanner(System.in);//creat the scanner
    System.out.println("What's the name of your farm?");
    String farmName = scan.nextLine();
    System.out.println("What's the name of your dog?");
    String dogName = scan.nextLine();
    System.out.println("What kind of dog is it?");
    String dogBreed = scan.nextLine();
    System.out.println("And how many sheep do you have?");
    int numSheep = scan.nextInt();
    
    //creating new objects for Dog and Sheeo
    Dog theDog = new Dog(dogName, dogBreed);
    Sheep[] sheepArr = new Sheep[numSheep];
    //creating a new sheeo array
    for (int i = 0; i < sheepArr.length; i++) {
      sheepArr[i] = new Sheep(getRandomName(), getRandomAge()); //calling the provided methods to get random ages and names
    }
    Farm theFarm = new Farm(farmName, theDog, sheepArr);
    
    System.out.println("The farm has " + numSheep + " sheep.");
    theFarm.printFarm(); //printing all info
    double woolSheared = theFarm.getWool(); 
    double woolMoney = woolSheared * 1.45; // use this variable to calaculate the wool per pound
    System.out.println("We just sheard " + woolSheared + " of wool for a total value of $" + woolMoney +".");
  }
  
}
