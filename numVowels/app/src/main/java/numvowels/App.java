/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package numvowels;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    int count =  0;

    Scanner SCN = null;
    File f= null;
    FileWriter fw = null;
    PrintWriter pw = null;
    try{
      f = new File("./src/main/java/numvowels/Test.txt");
      SCN = new Scanner(f);
      fw = new FileWriter(new File("./src/main/java/numvowels/exit.txt"));
      pw = new PrintWriter(fw);
    }
    catch(FileNotFoundException e){
      return;
    }
    catch(IOException e){
      return;
    }


    while( SCN.hasNextLine()){
      for(char a : SCN.nextLine().toCharArray()){
        count += checkVowel(Character.toUpperCase(a)) ? 1 : 0;
      }
      System.out.println(count);
      count = 0;
    }

    SCN.close();
    System.out.println(count);
    pw.print(count);
  }

  public static boolean checkVowel(char A) {
    if (A == 'A' || A == 'E' || A == 'I' || A == 'U'|| A == 'O' ) return true;
    return false;
  }


}
