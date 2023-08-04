package com.gb.java_exceptions.lesson1;

public class Answer {
    public static void arrayOutOfBoundsException() {
        throw new ArrayIndexOutOfBoundsException();
    }

    public static void divisionByZero() {
        int a = 5;
        int b = 0;
        int c = a / b;
    }

    public static void numberFormatException() {
        String s = "abc";
        int i = Integer.parseInt(s);
    }
}
