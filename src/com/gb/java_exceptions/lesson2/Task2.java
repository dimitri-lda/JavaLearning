package com.gb.java_exceptions.lesson2;

/**
 * Если необходимо, исправьте данный код.
 */
public class Task2 {
    public static void main(String[] args) {
        fixedCode();
    }

//    private static void givenCode() {
//        try {
//            int d = 0;
//            double catchedRes1 = intArray[8] / d;
//            System.out.println("catchedRes1 = " + catchedRes1);
//        } catch (ArithmeticException e) {
//            System.out.println("Catching exception: " + e);
//        }
//    }

    private static void fixedCode() {
        int[] intArray = new int[8];
        try {
            int d = 0;
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArrayIndexOutOfBoundsException | ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }
    }
}
