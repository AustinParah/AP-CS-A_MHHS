package fileio;

import java.util.Scanner;
import java.io.*;

public class App {
  public static void main(String[] args) {
    File example; // pull from data only after confirmed
    Scanner SCN;
    try{
      example = new File("./src/main/java/fileio/example.txt");
      SCN = new Scanner(example);
    }
    catch(FileNotFoundException e){
      System.out.println(e);
      System.out.println(System.getProperty("user.dir"));
      System.out.println("404: File Not Found");
      return;
    }

    while(SCN.hasNextLine()){
      System.out.println(SCN.nextLine());
    }

    SCN.close();

  }
}

