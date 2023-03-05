package com.gb.javalearn;

import java.util.Random;
import java.util.Scanner;

/*
 Задача 47: Задайте двумерный массив размером m×n, заполненный случайными вещественными числами.
 Задача 50: Напишите программу, которая на вход принимает позиции элемента в двумерном массиве, и возвращает значение этого элемента или же указание, что такого элемента нет.
 Задача 52: Задайте двумерный массив из целых чисел. Найдите среднее арифметическое элементов в каждом столбце.

 Task 47: Define a two-dimensional array of size m×n, found by a random revealed number.
 Task 50: Write a program that takes the position of an element in a two-dimensional array and returns the value of that element, or indicates that there is no such element.
 Task 52: Define a two-dimensional array of plurals. The arithmetic mean of the elements in each column appears.
 */
public class LessonCs7 {
    public static void main(String[] args) {
        task47();
        task50();
        task52();
    }

    private static void task47() {
        int col = 4;
        int raw = 3;
        double[][] array = generate2DemArrayOfDoubles(col, raw);
        print2DemArrayOfDoubles(array);
    }

    private static double[][] generate2DemArrayOfDoubles(int col, int raw) {
        double[][] array = new double[raw][col];
        Random rand = new Random();
        for (int rawIndex = 0; rawIndex<array.length; rawIndex++) {
            for (int colIndex = 0; colIndex<array[rawIndex].length; colIndex++) {
                array[rawIndex][colIndex] = rand.nextInt(9) - 5 + (double) rand.nextInt(9) / 10;
            }
        }
        return array;
    }

    private static void print2DemArrayOfDoubles(double[][] array) {
        System.out.print("Двумерный массив:\r\n");
        for (double[] i : array) {
            for (double j : i) {
                System.out.printf("%.1f ", j);
            }
            System.out.print("\r\n");
        }
        System.out.print("\r\n");
    }

    private static void task50() {
        int col = 4;
        int raw = 3;
        int[][] array = generate2DemArrayOfInts(col, raw);
        print2DemArrayOfInts(array);

        Scanner scan = new Scanner(System.in);
        System.out.println("Введите номер столбца в массиве (от 1): ");
        int colEl = scan.nextInt() - 1;
        System.out.println("Введите номер строки в массиве (от 1): ");
        int rawEl = scan.nextInt() - 1;

        if (colEl >= 0 && colEl < col && rawEl >= 0 && rawEl < raw) {
            System.out.printf("Число в массиве: %d \r\n\r\n", array[colEl][rawEl]);
        } else {
            System.out.println("Такого числа в массиве нет.\r\n");
        }
    }

    private static void task52() {
        int col = 4;
        int raw = 3;
        int[][] array = generate2DemArrayOfInts(col, raw);
        print2DemArrayOfInts(array);
        printColumnsAvg(findColumnsAvg(array));
    }

    private static int[][] generate2DemArrayOfInts(int col, int raw) {
        int[][] array = new int[raw][col];
        Random rand = new Random();
        for (int rawIndex = 0; rawIndex<array.length; rawIndex++) {
            for (int colIndex = 0; colIndex<array[rawIndex].length; colIndex++) {
                array[rawIndex][colIndex] = rand.nextInt(9);
            }
        }
        return array;
    }

    private static void print2DemArrayOfInts(int[][] array) {
        System.out.print("Двумерный массив:\r\n");
        for (int[] i : array) {
            for (int j : i) {
                System.out.printf("%d ", j);
            }
            System.out.print("\r\n");
        }
        System.out.print("\r\n");
    }

    private static double[] findColumnsAvg(int[][] array) {
        int numberOfColumns = array[0].length;
        int numberOfRows = array.length;
        double[] colAvg = new double[numberOfColumns];
        int colSum = 0;

        for (int colIndex = 0; colIndex<numberOfColumns; colIndex++) {
            for (int[] ints : array) {
                colSum += ints[colIndex];
            }
            colAvg[colIndex] = (double) colSum / numberOfRows;
            colSum = 0;
        }

        return colAvg;
    }

    private static void printColumnsAvg(double[] array) {
        System.out.print("Среднее арифметическое каждого столбца:\r\n");
        for (double i : array) {
            System.out.printf("%.1f ", i);
        }
        System.out.print("\r\n");
    }
}