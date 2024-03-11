package diamondexe;

import java.util.Scanner;

public class App {
    public static Scanner SCN = new Scanner(System.in);

    public static int number = 0;
    public static int passing = 0;
    public static String output =  "";


    public static void main(String[] args) {
      while(number%2 != 1){
        System.out.println("What width do you want?");
        number = SCN.nextInt();        
        number --;
        sequentialOutput(output, " ", "#");
      }
    }

    public static void sequentialOutput(String input, String firstChar,  String secondChar){
        int loopControl = 0;

        sequentialOutputIncrease(input, firstChar, secondChar);

        for(int i=0; i<number; i++){
            for(int j=0; j<i; j++){
              System.out.print(firstChar);
                passing++;
                loopControl = i;
            }
            for(int j=number; loopControl<j; j--){
                System.out.print(secondChar);
            }
            for(int j=number; loopControl<j-1; j--){
//                input+= secondChar;
                System.out.print(secondChar);
            }

//            input += "\n";
            System.out.println();
        }
        passing = 0;
//        return input;
    }

    public static String sequentialOutputIncrease(String input, String firstChar,  String secondChar){
        int loopControl = 0;

        for(int i=number; i>0; i--){
            for(int j=0; j<i; j++){
//                input += firstChar;
                System.out.print(firstChar);
                passing++;
                loopControl = i;
            }
            for(int j=number; loopControl<j-1; j--){
//                input+= secondChar;
                System.out.print(secondChar);
            }
            for(int j=number; loopControl<j; j--){
//                input+= secondChar;
                System.out.print(secondChar);
            }

//            input += "\n";
            System.out.println();
        }
        passing = 0;
        return input;
    }


}
