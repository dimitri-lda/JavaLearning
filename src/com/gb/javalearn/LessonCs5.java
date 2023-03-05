package com.gb.javalearn;

import java.util.Random;

/*
 Задача 34: Задайте массив заполненный случайными положительными трёхзначными числами. Напишите программу, которая покажет количество чётных чисел в массиве.
 Задача 36: Задайте одномерный массив, заполненный случайными числами. Найдите сумму элементов, стоящих на нечётных позициях.
 Задача 38: Задайте массив вещественных чисел. Найдите разницу между максимальным и минимальным элементов массива.

 Task 34: Define an array filled with random positive three-digit numbers. Write a program to show the number of even numbers in an array.
 Task 36: Define a one-dimensional array filled with random numbers. Find the sum of elements in odd positions.
 Task 38: Specify an array of real numbers. Find the difference between the maximum and minimum elements of the array.
 */
public class LessonCs5 {
    public static void main(String[] args) {
        task34();
        task36();
        task38();
    }

    private static void task34() {
        Random rand = new Random();
        int[] array = new int[]{
            rand.nextInt(999),
            rand.nextInt(999),
            rand.nextInt(999),
            rand.nextInt(999),
            rand.nextInt(999)
        };

        printArray(array);
        System.out.printf("Колличество четных чисел: %d", findEvenCount(array));
    }

    private static int findEvenCount(int[] array) {
        int countEven = 0;
        for (int i : array) {
            if (i % 2 == 0)
                countEven++;
        }

        return countEven;
    }

    private static void task36() {
        Random rand = new Random();
        int[] array = new int[]{
            rand.nextInt(199) - 100,
            rand.nextInt(199) - 100,
            rand.nextInt(199) - 100,
            rand.nextInt(199) - 100
        };

        printArray(array);
        System.out.printf("Сумма элементов на нечетных позициях: %d", findSumOfOddPositionElements(array));
    }

    private static int findSumOfOddPositionElements(int[] array) {
        int sumOddPos = 0;

        for (int i=0; i<array.length; i++) {
            if (i % 2 != 0)
                sumOddPos += array[i];
        }
        return sumOddPos;
    }

    private static void task38() {
        Random rand = new Random();
        int[] array = new int[]{
                rand.nextInt(199) - 100,
                rand.nextInt(199) - 100,
                rand.nextInt(199) - 100,
                rand.nextInt(199) - 100,
                rand.nextInt(199) - 100
        };
        printArray(array);
        System.out.printf("Разница между максимальным и минимальным элементами массива: %d", getMinMaxDiff(array));
    }

    private static int getMinMaxDiff(int[] array) {
        return getMax(array) - getMin(array);
    }

    private static int getMax(int[] array) {
        int max = array[0];
        for (int i : array) {
            if (i > max)
                max = i;
        }

        return max;
    }

    private static int getMin(int[] array) {
        int min = array[0];
        for (int i : array) {
            if (i < min)
                min = i;
        }

        return min;
    }

    private static void printArray(int[] array) {
        System.out.println("\r\n");
        System.out.print("Массив:");
        for (int i : array) {
            System.out.printf(" %d", i);
        }
        System.out.print("\r\n");
    }
}