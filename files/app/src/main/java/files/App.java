package files;

import java.util.Scanner;
import java.io.*;

public class App {
  public static void main(String[] args) {
    Scanner SCN = null;
    File file = null;
    FileWriter fileWriter = null;
    PrintWriter printWriter = null;

    try {
      file = new File("./example.txt");
      SCN = new Scanner(file);
      fileWriter = new FileWriter("final.txt");
      printWriter = new PrintWriter(fileWriter);

    } catch (FileNotFoundException e) {
      System.out.println("404: file not found");
      return;
    } catch (IOException e) {
      System.out.println("404: Written File Not Found");
      return;
    }



    while (SCN.hasNext()) {
      System.out.println(SCN.nextLine());
    }

    SCN.close();
    printWriter.close();
  }
}
