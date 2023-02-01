package com.gb.javalearn;

public class Lesson3Final {

    public static void main(String[] args) {
        int[] array = new int[]{2, 5, 13, 7, 6, 4};
        float avg = findAvg(array);
        System.out.println("Среднее арифмитическое: " + avg);
    }

    private static float findAvg(int [] array) {
        int sum = 0;
        for (int j : array) {
            sum += j;
        }
        return (float) sum / array.length;
    }
}