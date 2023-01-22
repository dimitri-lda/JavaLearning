package com.gb.javalearn;

import java.util.Arrays;

public class Lesson2 {
    public static void main(String[] args) {
        findMinMaxInArray();
        reverseArray();
        findSumOfElementsBetweenMinMaxInArray();
        findAvgInArray();
    }

    private static void findMinMaxInArray() {
        int[] array = new int[]{1,17,6,5,-1,-9,0,-3,5};
        int min = array[0];
        int max = array[0];
        for (int i=1; i<array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }

        System.out.println("Наименьшее число в массиве: " + min);
        System.out.println("Наибольшее число в массиве: " + max);
    }

    private static void reverseArray() {
        int[] array = new int[]{1,6,5,17,-9,0,-3,5};
        int[] reversedArray = new int[array.length];
        for (int i=0, j=array.length-1; i<array.length; i++, j--) {
            reversedArray[i] = array[j];
        }

        System.out.println("Развернутый массив: " + Arrays.toString(reversedArray));
    }

    private static void findSumOfElementsBetweenMinMaxInArray() {
        int[] array = new int[]{1,17,6,5,-1,-9,0,-3,5};
        int min = array[0];
        int max = array[0];
        int minIndex = 0;
        int maxIndex = 0;
        for (int i=1; i<array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                minIndex = i;
            }
            if (array[i] > max) {
                max = array[i];
                maxIndex = i;
            }
        }

        int startIndex = maxIndex < minIndex ? maxIndex : minIndex; // Math.min(maxIndex, minIndex);
        int endIndex = maxIndex > minIndex ? maxIndex : minIndex; // Math.max(maxIndex, minIndex)
        int sum = 0;
        for (int i=startIndex+1; i<endIndex; i++) {
            sum += array[i];
        }

        System.out.println("Cуммa элементов массива, лежащих между максимальным и минимальным по значению элементами" +
                " равна: " + sum);
    }

    private static void findAvgInArray() {
        int[] array = new int[]{1,17,6,5,-1,-9,0,-3,5};
        int sum = 0;
        for (int j : array) {
            sum += j;
        }

        float elementsCount = array.length;
        float avg = sum / elementsCount;

        System.out.println("Среднее арифмитическое: " + avg);
    }
}