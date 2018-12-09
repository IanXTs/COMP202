import java.util.Arrays;
//Name: Yao An Tsai
//McGill ID : 260741766
public class ExamGrading
{
  //main method for testing
  public static void main(String[] main)
  {
    char[][] responses = {{'C','A','B','B','C','A'},{'A','A','B','B','B','B'},//responses from students
      {'C','B','A','B','C','A'},{'A','B','A','B','B','B'}};//right answers
    char[] solutions={'C','A','B','B','C','C'};
    double[] grades = gradeAllStudents(responses , solutions);
    System.out.println(Arrays.toString(grades)); 
    char[]studentsResponse1 =  {'A','B','C','D','C','A'};
    char[]studentsResponse2={'A','B','D','B','B','A'};
    char[] correctAnswer = {'C','B','C','D','A','A'};
    int numOfsame = numWrongSimilar(studentsResponse1 , studentsResponse2,correctAnswer);
    System.out.println("the number of responses that both do wrong is: " +numOfsame);    
    char[][] studentAnswers={{'A','B','C','D','B','A'},{'C','B','D','D','B','B'},{'C','B','D','D','C','B'}};
    char[] theAnswers = {'C','B','C','D','A','A'};
    int index = 1 ;
    int threshold = 2;
    int result = numMatches(studentAnswers , theAnswers , index , threshold);
    System.out.println("the number of student having at lease similarity threshold wrong answers is: " +result);
    int threshold2 = 1;
    int[][] questionC = findSimilarAnswers(responses,solutions,threshold2);
    System.out.println(Arrays.deepToString(questionC));   
  }
  
  public static double[] gradeAllStudents(char[][] arr , char[] solutions)
  {
    String s = "the index of student who causes problem is" ;
    int x = 6; //we set an int variable here as 6 because there are 6 questions in total
    double [] result = new double[4];
    for(int i= 0;i<arr.length ;i++)
    {
      char[]studentResponse = arr[i];
      x=6;
      for(int j= 0; j< solutions.length ;j++)
      {
        char r = studentResponse[j];
        char a = solutions[j];
        //if the student doesn't answer all the question leades to illegal and we use it as the value
        if(studentResponse.length !=solutions.length)
        {
         s= s+" " +i;
         throw new IllegalArgumentException (s);
        }
        if(r != a)
        {
          x=x-1;
          //if the student has one answer that does not match the correct solution, we minus x by 1, showing the # who got the quesiton right
        } 
      }
       double grades = x*100/6;
        result[i] = grades; // and now we can finally calculate the final grade and return the result
    }
    
    return result ;
  }
  
   public static int numWrongSimilar(char[] arr1 , char[] arr2 ,char[] correctAnswer)
   {
     int num = 0 ;
     for(int i = 0; i<arr1.length ; i++)
     {
       char a = arr1[i];
       char b = arr2[i];
       char c = correctAnswer[i];
       if (a==b && b != c)
       {
         num = num +1 ;
       } 
     }
     
     if(arr1.length != correctAnswer.length || arr2.length != correctAnswer.length)
     {
       throw new IllegalArgumentException("somoeone doesn't fully answer the exam");
     }
     return num;
   }
   
   
   
   public static int numMatches(char[][] arr1 , char[] arr2 ,int x ,int y)
   {
     int value = 0 ;
     for(int i = 0 ; i<arr1.length ; i++)
     {
      char [] arr3 = arr1[i];
      if(i != x)
      {
        int hh= numWrongSimilar(arr1[x], arr3 , arr2);
        if( hh >= y)
        {
          value = value +1 ;
          
        }
      }
        
       
     }
     
     return value ;
   }
   
   
   public static int [][] findSimilarAnswers(char[][] arr1 ,char[] arr2 ,int x )
   {
     int [][] result = new int[arr1.length][];
     for(int i = 0;i < arr1.length ; i++)
     {
       char[] arr3 = arr1[i];
       
       int length = numMatches(arr1 ,arr2 , i , x);
       int[] eachStudent = new int[length];
       int k = 0;
       for(int j= 0 ; j <arr1.length ;j ++)
       {
        char[] subAnswers = arr1[j];
         result[i] = eachStudent ;
        
         if (i != j)
         {
          int numWrong = numWrongSimilar(arr3 , subAnswers , arr2);
          if(numWrong >= x)
          {
            eachStudent[k] = j;
            k = k + 1 ;
          }
         }
       } 
     }
     return result ; 
   }
}