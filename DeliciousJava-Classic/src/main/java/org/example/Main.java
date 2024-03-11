package org.example;

import java.util.Scanner;
import java.text.DecimalFormat;
//import java.util.hashmap;
/*
Author: Austin Parah

Created : 8/28/23 + part II 9/13/23 + part III 10/2/23 + partIV 11/27/23 + part V 11/27/23
Last Modified : 11/27/23
Why was it modified? : redid part IV from backup loss -- V modified control loop
to  handle invalid payment numbers
*/

class main {

    static double Prospector = 15;
    static double Highnoon   = 12;
    static double Sage       = 14;
    static double revolver   = 20;
    static double subtotal   = 0;
    static double tip        = 1;
    static double total      = 0;
    static boolean payed = false;
    static double personMultiplier = 1;

    static String currentOrder = "\n | Drink      - # - Price |";

    public static void main(String[] args) {

        Scanner SCN = new Scanner(System.in);
        DecimalFormat DF  = new DecimalFormat("0.00");

        //print each line using \n
        System.out.println(
                        "-------------------------------------------- \n"+
                        "|            Welcome  to the               |\n"+
                        "|       ✪ Highway robbery café ✪           |\n"+
                        "| the \"most expensive coffee in the west\"  |\n"+
                        "|------------------------------------------|\n"+
                        "|               ~ prices ~                 |\n"+
                        "| The Prospector  ==  $15  Americano       |\n"+
                        "| Highnoon laté   ==  $12  Iced Carm. Laté |\n"+
                        "| Sage Green Tea  ==  $14  Vanilla Matcha  |\n"+
                        "| The Revolver    ==  $20  Cappachino      |\n"+
                        "|                                          |\n"+
                        "--------------------------------------------");

        //ask for order(s)
        //keep asking if they want more drinks untill they say no
        do{
            handlePeople(SCN);
            System.out.println("what is your order?");
            processOrder(SCN.nextLine(), SCN, DF);
        } while(checkDrinks(SCN));
        System.out.println("What % tip would you like to add?");
        tip += Double.parseDouble(SCN.nextLine()) / 100;

        System.out.println(
                        " ---------------------"  +
                        "\n | sub-total : " + DF.format(subtotal) + "   |"+
                        "\n | tip %     : " + DF.format(RoundTo1s(((tip-1)*100)))  +  "   |"+
                        "\n | Total     : " + DF.format(subtotal*tip) + "   |\n" +
                        " ----------------------" +
                        currentOrder  + "\n"
        );
        do{
        System.out.println("Please enter amount being payed in cash");
        total = subtotal * tip;
        handleChange(Double.parseDouble(SCN.nextLine()));
        }while(!payed);
    }

    public static void processOrder(String input, Scanner SCN, DecimalFormat DF){
        int numberOfDrinks;

        if(input.equalsIgnoreCase("the prospector") ||
                input.equalsIgnoreCase("prospector") ||
                input.equalsIgnoreCase("americano")){
            numberOfDrinks = getNumberOfOrders(SCN);
            subtotal += Prospector * numberOfDrinks * personMultiplier;
            currentOrder += "\n | Prospector - "+numberOfDrinks+" - "+DF.format(Prospector*numberOfDrinks*personMultiplier) + " |";
        }
        if(input.equalsIgnoreCase("highnoon") ||
                input.equalsIgnoreCase("highnoon late") ||
                input.equalsIgnoreCase("highnoon laté") ||
                input.equalsIgnoreCase("late")) {
            numberOfDrinks = getNumberOfOrders(SCN);
            subtotal += Highnoon * numberOfDrinks * personMultiplier;
            currentOrder += "\n | Highnoon   - "+numberOfDrinks+" - "+DF.format(Highnoon*numberOfDrinks*personMultiplier) + " |";
        }

        if(input.equalsIgnoreCase("sage green tea") ||
                input.equalsIgnoreCase("sage green") ||
                input.equalsIgnoreCase("green tea") ||
                input.equalsIgnoreCase("tea")) {
            numberOfDrinks = getNumberOfOrders(SCN);
            subtotal += Sage * numberOfDrinks * personMultiplier;
            currentOrder += "\n | Sage       - "+numberOfDrinks+" - "+DF.format(Sage*numberOfDrinks*personMultiplier) + " |";
        }
        if(input.equalsIgnoreCase("revolver") ||
                input.equalsIgnoreCase("Cappachino")) {
            //subtotal += revolver * getNumberOfOrders(SCN);
            numberOfDrinks = getNumberOfOrders(SCN);
            subtotal += revolver * numberOfDrinks * personMultiplier;
            currentOrder += "\n | Revolver   - "+numberOfDrinks+" - "+DF.format(revolver*numberOfDrinks*personMultiplier) + " |";
        }
    }


    public static int getNumberOfOrders(Scanner SCN){
        System.out.println("How many would you like?");
        return Integer.parseInt(SCN.nextLine());
    }

    public static boolean checkDrinks(Scanner SCN){
        System.out.println("will that be all?");
        String input = SCN.nextLine();
        if(input.equalsIgnoreCase("yes")||
                input.equalsIgnoreCase("y"))
        {
            return false;
        }
        return true;
    }

    public static void handleChange(double input){
        //handle in cent values
        if(input - total < 0){ System.out.println("that is not enough"); return; }
        if(input - total > 20){System.out.println("your change is too much -- please try again"); return;}
        input     -= total;
        input     *= 100;

        if (input >= 100) {
            HandleGrammer(input, 100, "Dollar");
            System.out.println((int)input / 100);
            input   %= 100;
        }
        if (input >= 25) {
            HandleGrammer(input, 25, "Quarter");
            System.out.println((int)input / 25);
            input   %= 25;
        }
        if (input >= 10) {
            HandleGrammer(input, 10, "Dime");
            System.out.println(((int)input / 10));
            input   %= 10;
        }
        // there are no cases where you have more than 1 nickle
        if (input >= 5) {
            System.out.println("Nickle - " + ((int)input / 5));
            input   %= 5;
        }
        if (input >= 1) {
            HandleGrammerPennies(input);
            System.out.println((int)input / 1);
            input   %= 1;
        }
        payed = true;
    }

    public static void handlePeople(Scanner SCN){
        System.out.println("Is this drink for an adult, child or infant?");
        String input = SCN.nextLine();

        if(input.equalsIgnoreCase("adult")){personMultiplier = 1; return;}
        if(input.equalsIgnoreCase("child")){personMultiplier = 0.5; return;}
        if(input.equalsIgnoreCase("infant")){personMultiplier = 0; return;}

        personMultiplier = 1;
    }

    public static void HandleGrammer(double input, int coinVal, String coinName){
        System.out.print(coinName);
        if((int)input / coinVal > 1){
            System.out.print("s");
        }
        System.out.print(" - ");
    }

    //IK its lazy to add a special function JUST for pennies but I cant be bothered to add it to the main one
    public static void HandleGrammerPennies(double input){
        if((int)input / 1 > 1){
            System.out.print("Pennies - ");
            return;
        }
        System.out.print("Penny - ");
    }

    public static double RoundTo100ths(double input){
        input = (double)Math.round(input*100)/100;
        return input;
    }

    public static double RoundTo1s(double input){
        return (double)Math.round(input);
    }
}
