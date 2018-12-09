public class Circle { 
  public static void main(String[] args) { 
    drawCircle(1, 3, 3,"$");
} 
  public static boolean onCircle(int a, int b, int x, int y, int radius){
    if ((Math.pow((x-a),2)+Math.pow((y-b),2)<=(Math.pow(radius,2)+1)&&(Math.pow(radius,2))<=(Math.pow((x-a),2)+Math.pow((y-b),2)))&&radius>0){
      //simple math.pow calculation to set the boolean of radius and the other 4 inputs
      return true;}
    return false;
}
  // we eliminate the illegal arguments of the the circle using another boolean method before drawing the circle
  public static boolean verifyInput (int radius, int a, int b){
    if(a>=radius && b>=radius && radius>0){
      return true;}  
    else if(radius<=0) {
      throw new IllegalArgumentException("Circle must have a positive radius.");}
    else{
      throw new IllegalArgumentException("the circle needs to fit in the upper right qudrant.");}
  }
// the method that actually draws the circle
  public static void drawCircle(int radius, int a, int b, String sign){
    if(verifyInput(radius,a,b)){
      int x,y;
      if ((a+radius)<=9&&((b+radius)<=9&&a>=radius&&b>=radius)){
     for (y = 9; y >= 0; y--) {
            for (x = 0; x <= 9; x++) {
                // when 0 and 9, the coordinates have the priority than other coordinates           
                 if (onCircle(a,b,x,y,radius)){
                    System.out.print(sign);
                } else if (x == 0 && y == 0){ //we set the origin 0 and 0
                    System.out.print("+");
                } else if (y == 0 && x == 9) {
                  System.out.print(">");
                } else if (x == 0 && y == 9) {
                    System.out.print("^");
                }else if (x == 0){ 
                    System.out.print("|");// using a else if to set the y-axis
                } else if (y == 0) { 
                    System.out.print("-");// using a else if to set the x-axis
                } else { 
                    System.out.print(" ");// after eliminating the x and y axis now the other are the circle
                }// this last command is important because it actually prints out the cirle    
            }
             System.out.println();
}
  }
      else {
        int newX=a+radius;
        int newY=b+radius;
        for (y = newY; y >= 0; y--) {
            for (x = 0; x <= newX; x++) {
                 if (onCircle(a,b,x,y,radius)){
                    System.out.print(sign);
                } else if (x == 0 && y == 0){ //we set the origin 0 and 0
                    System.out.print("+");
                } else if (y == 0 && x == newX) {
                  System.out.print(">");
                } else if (x == 0 && y == newY) {
                    System.out.print("^");
                }else if (x == 0){ 
                    System.out.print("|");// using a else if to set the y-axis
                } else if (y == 0) { 
                    System.out.print("-");// using a else if to set the x-axis
                } else { 
                    System.out.print(" ");// after eliminating the x and y axis now the other are the circle
                }// this last command is important because it actually prints out the cirle          
            }
             System.out.println();
}
  }
          }
}
}