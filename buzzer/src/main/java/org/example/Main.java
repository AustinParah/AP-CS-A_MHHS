package org.example;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);

        boolean buzzer = false;
        boolean key =  false;
        boolean shut = true;

        System.out.println("Is the key in the ignition?");
        System.out.println("Enter true or false");
        key = sc.nextBoolean();
        sc.nextLine();
        System.out.println("Is the door shut?");
        System.out.println("Enter true or false");
        shut = sc.nextBoolean();

        //Your code goes here
        if(key && !shut){
            buzzer = true;
        }

        System.out.println("buzzer is " + buzzer);
    }
}