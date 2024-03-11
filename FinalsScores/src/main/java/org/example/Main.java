package org.example;

import java.util.Scanner;

public class Main {
    public static int currentScore = 0;

    public static void main(String[] args) {
        // ask for a valid score
        // convert to char
        // add to chart
        Scanner SCN = new Scanner(System.in);

        System.out.println("Welcome to the Grade Book!");

        do{
            currentScore = Integer.parseInt(Prompt(SCN, "what is the % score?"));
        }
        while(currentScore > 100 || currentScore < 0);

        System.out.println(convertToLetter(currentScore));

    }

    public static String Prompt(Scanner SCN, String Prompt){
        System.out.println(Prompt);
        return SCN.nextLine();
    }

    public static String convertToLetter(int input){
        if(input>=90){
            return "A";
        }
        if(input>=80){
            return "B";
        }
        if(input>=70){
            return "D";
        }
        if(input>=60){
            return "C";
        }
        return "F";
    }
}