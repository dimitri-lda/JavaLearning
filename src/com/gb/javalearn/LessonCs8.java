package com.gb.javalearn;

import java.util.*;

/*
 Задача 54: Задайте двумерный массив. Напишите программу, которая упорядочит по убыванию элементы каждой строки двумерного массива.
 Задача 56: Задайте прямоугольный двумерный массив. Напишите программу, которая будет находить строку с наименьшей суммой элементов.
 Задача 58: Задайте две матрицы. Напишите программу, которая будет находить произведение двух матриц.
 Задача 60: Сформируйте трёхмерный массив из неповторяющихся двузначных чисел. Напишите программу, которая будет построчно выводить массив, добавляя индексы каждого элемента.
 Задача 62: Напишите программу, которая заполнит спирально массив 4 на 4.

 Task 54: Define a two-dimensional array. Write a program that sorts in descending order the elements of each row of a two-dimensional array.
 Task 56: Define a rectangular two-dimensional array. Write a program that will find the skin with the least number of elements.
 Task 58: Define two matrices. Write a program that will find two product matrices.
 Task 60: Form a three-dimensional array of non-repeating two-digit numbers. Write a program that will print an array line by line, adding the indexes of each element.
 Task 62: Write a program that fills a 4 by 4 array in a spiral.
 */
public class LessonCs8 {
    public static void main(String[] args) {
        task54();
        task56();
//        task58();
//        task60();
//        task62();
    }

    private static void task54() {
        int col = 4;
        int raw = 3;
        Integer[][] array = generate2DemArrayOfIntegerObjects(col, raw);
        print2DemArrayOfIntegerObjects(array);
        Integer[][] sortedArray = sort2DemArrayRows(array);
        print2DemArrayOfIntegerObjects(sortedArray);
    }

    private static Integer[][] generate2DemArrayOfIntegerObjects(int col, int raw) {
        Integer[][] array = new Integer[raw][col];
        Random rand = new Random();
        for (int rawIndex = 0; rawIndex<array.length; rawIndex++) {
            for (int colIndex = 0; colIndex<array[rawIndex].length; colIndex++) {
                array[rawIndex][colIndex] = rand.nextInt(9);
            }
        }
        return array;
    }

    private static void print2DemArrayOfIntegerObjects(Integer[][] array) {
        System.out.print("Двумерный массив:\r\n");
        for (Integer[] i : array) {
            for (Integer j : i) {
                System.out.printf("%d ", j);
            }
            System.out.print("\r\n");
        }
        System.out.print("\r\n");
    }

    private static Integer[][] sort2DemArrayRows(Integer[][] array) {
        for (Integer[] raw : array) {
            Arrays.sort(raw, Collections.reverseOrder());
        }
        return array;
    }

    private static void task56() {
        int col = 4;
        int raw = 4;
        int[][] array = generate2DemArrayOfInts(col, raw);
        print2DemArrayOfInts(array);
        int minSumRowIndex = findRawWithMinElemSum(array);
        System.out.println("Индекс строки с минимальной суммой элементов: " + minSumRowIndex);
        printArray(array[minSumRowIndex]);
    }

    private static int findRawWithMinElemSum(int[][] array) {
        int sum = Arrays.stream(array[0]).sum();
        int resultIndex = 0;
        for (int rawIndex = 0; rawIndex<array.length; rawIndex++) {
            int currentSum = Arrays.stream(array[rawIndex]).sum();
            if (currentSum < sum) {
                sum = currentSum;
                resultIndex = rawIndex;
            }
        }
        return resultIndex;
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

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.printf("%d ", i);
        }
        System.out.print("\r\n");
    }
}