package org.example;

import java.util.Random;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome!");

        Random rand = new Random();
        boolean tryAgain = false;
        Scanner SCN = new Scanner(System.in);
        int points = 0;

        do{
            //intro Screen
            System.out.println("Would you like to play Scratcher? (yes / no)");
            tryAgain = YNGetter(SCN);

            int a = rand.nextInt(15);
            int b = rand.nextInt(15);
            int c = rand.nextInt(15);

            System.out.println("A is " + a);
            System.out.println("B is " + b);
            System.out.println("C is " + c);

            points += evalPoints(a,b,c);
            System.out.println("you have "+points+" points");
        }
        while(tryAgain);
    }
    public static boolean YNGetter(Scanner SCN){
        String workline = SCN.nextLine();
        return workline.equalsIgnoreCase("yes") || workline.equalsIgnoreCase("y");
    }

    public static int evalPoints(int a, int b, int c){
        if(a + b + c == 0){
            return 5;
        }
        if(a == b && b==c){
            return 2;
        }
        if(a != b && b==c) {
            return 1;
        }
        return -1;
    }
}