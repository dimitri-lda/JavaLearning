package com.gb.javalearn;

import java.util.Arrays;

public class Lesson1Task3 {
    public static void main(String[] args) {
        float avg = findAvg();
        System.out.println("Среднее арифмитическое: " + avg);

        int factorial = 5;
        int resultFactorial = findFactorial(factorial);
        System.out.format("Факториал %d: %d", factorial, resultFactorial);
        boolean xxx = isPalindrome(1121);
    }

    public static boolean isPalindrome(int x) {
        char[] chars = String.valueOf(x).toCharArray();
        int len = (int) Math.ceil(chars.length / 2.0);
        char[] chars1 = getFirstElements(chars, len);
        char[] chars2 = getLastElements(chars, len);
        return Arrays.equals(chars1, chars2);
    }

    private static char[] getLastElements(char[] chars, int length) {
        char[] resultChars = new char[length];
        int z = 0;
        for (int i=chars.length-1; i>chars.length-1-length; i--) {
            resultChars[z] = chars[i];
            z++;
        }
        return resultChars;
    }

    private static char[] getFirstElements(char[] chars, int length) {
        char[] resultChars = new char[length];
        for (int i=0; i<length; i++) {
            resultChars[i] = chars[i];
        }
        return resultChars;
    }

    private static float findAvg() {
        int[] array = new int[]{1,2,3,4};
        int sum = array[0] + array[1] + array[2] + array[3];
        float elementsCount = array.length;
        return sum / elementsCount;
    }

    private static int findFactorial(int factorial) {
        int result = 1;
        for (int step=2; step<=factorial; step++) {
            result *= step;
        }

        return result;
    }
}