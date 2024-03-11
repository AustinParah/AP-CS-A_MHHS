package org.example;

import java.util.Scanner;

public class Main {
    static String name;
    static int level;
    static int health;
    static int strength;
    static int luck;

    public static void main(String[] args) {
        Scanner SCN = new Scanner(System.in);

        System.out.println("welcome to the worlds best Table Top RPG");
        name = prompt("what is your name", SCN);
        level = Integer.parseInt(prompt("what level are you? ", SCN));
        do{
          assignAttributes(SCN);
        } while(!checkInvalid());
    }

    public static String prompt(String prmpt, Scanner SCN){
        System.out.println(prmpt);
        return SCN.nextLine();
    }

    public static int promptInt(String prompt, Scanner SCN){
        return Integer.parseInt(prompt(prompt, SCN));
    }

    public static void assignAttributes(Scanner SCN){
        health = promptInt("What is your health stat? (1-10)", SCN);
        strength = promptInt("What is your strength stat? (1-10)", SCN);
        luck = promptInt("What is your luck stat? (1-10)", SCN);
    }

    public static boolean checkInvalid(){
        if(level < 3 && (health + strength + luck) > 15){
            return false;
        }
        if(level < 6 && (health + strength + luck) > 20){
            return false;
        }
        if(level < 9 && (health + strength + luck) > 25){
            return false;
        }
        return true;
    }


}