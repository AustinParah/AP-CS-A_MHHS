package hollowbox;

import java.util.Scanner;

public class App {
  
  static int height;
  static int width;
  static boolean invalid;

    public static void main(String[] args) {

    //for Scanner
  //   Scanner SCN = new Scanner(System.in);
  // 
  //   do{
  //     try{
  //       System.out.println("Whats the hight of the box");
  //       width=Integer.parseInt(SCN.nextLine());
  //       System.out.println("Whats the width of the box");
  //       // height =  Integer.parseInt(SCN.nextLine());
  //       invalid = false;
  //     }
  //     catch(NumberFormatException e){
  //       invalid = true;
  //     }
  //   }
  //   while(invalid);

    
    // for CLI args
    width = Integer.parseInt(args[0]);
    height = Integer.parseInt(args[1]);
    
    horizontalBar(width);
      for(int i=0; i<height-2; i++){
        printRow(width);
      }
      horizontalBar(width);
    }

  public static void horizontalBar(int height){
    for(int i=0; i<height; i++){
      System.out.print("#");
    }
    System.out.println();
  }

  public static void printRow(int height){
    System.out.print("#");
    for(int i=0; i<height-2;i++){
      System.out.print(" ");
    }
    System.out.println("#");
  }

}
