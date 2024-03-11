package org.example;

public class Main {
    public static void main(String[] args) {
        int[] evens = { 1, 4, 5, 8, 2, 3, 5, 8, 4, 1  };
        int[] odds  = { 2, 5, 6, 7, 3, 6, 6, 9, 3, 10 };
        int invalids = 0;

        sortRecursive(evens, odds, 0, invalids);

        System.out.println();

        printArrayRecursive(0, evens);
        printArrayRecursive(0, odds);
    }

    public static void printArrayRecursive(int i, int[] array){
        if(i < array.length){
            System.out.print(array[i]);
            printArrayRecursive(i+1, array);
        }
        if(i == array.length) System.out.println();
    }

    public static void sortRecursive(int[] evens, int[] odds, int i, int invalid){
        if(i > evens.length){
            sortRecursive(evens, odds, i+1, invalid);
            if(evens[i]%2 != 0){
                invalid = evens[i];
                evens[i] = odds[i];
                odds[i] = invalid;
            }
            return;
        }
    }
}