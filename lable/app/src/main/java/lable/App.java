// Written by Austin Parah - April 3, 2024

package lable;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;
import java.io.IOException;

public class App {

  static File f = null;
  static FileWriter fw = null;
  static PrintWriter pw = null;
  static Scanner SCN = null;

  public static void main(String[] args) {
    try {
      fw = new FileWriter("./src/main/java/lables.txt");
      pw = new PrintWriter(fw, true);
      f = new File("./src/main/java/lable/addresses.txt");
      SCN = new Scanner(f);
    } catch (FileNotFoundException e) {
      System.out.println("File Not Found");
      return;
    } catch (IOException e) {
      System.out.println("Generic IO exeption");
    }

    while (SCN.hasNextLine()) { // print lables
      onLine(SCN.nextLine());
    }

  }

  public static void onLine(String line) {
    for (String content : line.split("  ")) {
      if (!content.equals("")) {
        if (content.startsWith(" ")) {
          content = content.substring(1);
        }
        System.out.println(content);
        pw.println(content);
      }
    }
    System.out.println();
    pw.println("\n");
  }

}
