package org.example;

public class Main {
    public static void main(String[] args) {
        int[] candles = { 4, 4, 1, 3 };
        int maxNumber = getMaxRecursive(0, candles, candles[0]);
        System.out.println(getNumberOfValueRecursive(maxNumber, candles, 0, 0));
    }

    public static int getNumberOfValueRecursive(int value, int[] array, int i, int counter){
        if(i < array.length){
            counter = getNumberOfValueRecursive(value, array, i+1, counter);
            if(array[i] == value) counter ++;
        }
        return counter;
    }

    public static int getMaxRecursive(int i, int[] arr, int maxFound) {
        if(i < arr.length){
            int nextNumber = getMaxRecursive(i+1,arr,maxFound);
            if(maxFound < arr[i]){
                maxFound = arr[i];
            }
            if(maxFound < nextNumber)  maxFound = nextNumber;
            return maxFound;
        }
        return maxFound;
    }
}