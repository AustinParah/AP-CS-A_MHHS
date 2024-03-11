package org.example;

import java.util.Scanner;

public class Main {

  public static Employee[] employeeList = {
    new Employee("Wile E. Cyote", "1904313318"),
    new Employee("Tweety", "429420453"),
    new Employee("Bugs G. Bunny", "1234567")};



  public static void main(String[] args) {
    Scanner SCN = new Scanner(System.in);

    int strikes = 0;
    while(strikes < 3){
      if(checkEmployee(SCN)){
        // this is where the buisness logic goes
        return;
      }
      System.out.println("You seem to have entered an invalid ID - try again");
      strikes++;
    }
    System.out.println("I dont think your an employee here");

  }

  public static Boolean checkEmployee(Scanner SCN){ 
    String ID = Prompt("Enter your ID", SCN);
    for(Employee e : employeeList){
      if(ID.equals((e.idNumber))){
        System.out.println("Welcome " + e.name);
        return true;
      }
    }
    return false;

  }

  public static String Prompt(String prompt, Scanner SCN){
    System.out.println(prompt); 
    return SCN.nextLine();
  }

  public static class Employee{
        String name;
        String idNumber;
        public Employee(String name, String idNumber){
            this.name = name;
            this.idNumber = idNumber;
        }
    }
}
