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
 Task 62: Write a program that fills a 4 by 4 array in a helix.
 */
public class LessonCs8 {
    public static void main(String[] args) {
        task54();
        task56();
        task58();
        task60();
        task62();
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
        rand.nextInt(9);
        for (int i = 0; i<array.length; i++) {
            for (int j = 0; j<array[i].length; j++) {
                array[i][j] = rand.nextInt(9);
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
        System.out.println();
    }

    private static int findRawWithMinElemSum(int[][] array) {
        int sum = Arrays.stream(array[0]).sum();
        int resultIndex = 0;
        for (int i = 0; i<array.length; i++) {
            int currentSum = Arrays.stream(array[i]).sum();
            if (currentSum < sum) {
                sum = currentSum;
                resultIndex = i;
            }
        }
        return resultIndex;
    }

    private static int[][] generate2DemArrayOfInts(int col, int raw) {
        int[][] array = new int[raw][col];
        Random rand = new Random();
        for (int i = 0; i<array.length; i++) {
            for (int j = 0; j<array[i].length; j++) {
                array[i][j] = rand.nextInt(9);
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

    private static void task58() {
        int[][] matrix1 = generateMatrix();
        System.out.println("Матрица 1:");
        printMatrix(matrix1);

        int[][] matrix2 = generateMatrix();
        System.out.println("Матрица 2:");
        printMatrix(matrix2);

        System.out.println("Призведение матриц 1 и 2:");
        printMatrix(getMatrixMultiplication(matrix1, matrix2));
        System.out.println();
    }

    private static int[][] generateMatrix() {
        Random rand = new Random();
        return new int[][]{{rand.nextInt(9), rand.nextInt(9)}, {rand.nextInt(9), rand.nextInt(9)}};
    }

    private static int[][] getMatrixMultiplication(int[][] matrix1, int[][] matrix2) {
        int[][] resultMatrix = new int[matrix1.length][matrix2[0].length];
        for (int i = 0; i < matrix1.length; i++) {
            for (int j = 0; j < matrix2[0].length; j++) {
                int sum = 0;
                for (int k = 0; k < matrix1[0].length; k++) {
                    sum += matrix1[i][k] * matrix2[k][j];
                }
                resultMatrix[i][j] = sum;
            }
        }
        return resultMatrix;
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] rows : matrix) {
            for (int elem : rows) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
    }

    private static void task60() {
        int[][][] array = generate3DemArrayOfInts(2);
        print3DemArrayOfInts(array);
        System.out.println();
    }

    private static int[][][] generate3DemArrayOfInts(int arraySize) {
        Random rand = new Random();
        int[][][] array = new int[arraySize][arraySize][arraySize];
        ArrayList<Integer> tempArrayList = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                for (int k = 0; k < array[i][j].length; k++) {
                    int number = rand.nextInt(99);
                    while (tempArrayList.contains(number)) {
                        number = rand.nextInt(99);
                    }
                    array[i][j][k] = number;
                    tempArrayList.add(number);
                }
            }
        }

        return array;
    }

    private static void print3DemArrayOfInts(int[][][] arr) {
        System.out.println("Трехмерный массив: ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = 0; k < arr[i][j].length; k++) {
                    System.out.print(arr[i][j][k] + "(" + i + "." + j + "." + k + ") ");
                }
                System.out.println();
            }
        }
    }

    private static void task62() {
        int[][] array = fillHelixArray(4);
        System.out.println("Массив заполненый в виде спирали");
        print2DemArrayOfInts(array);
    }

    public static int[][] fillHelixArray(int arraySize) {
        int[][] array = new int[arraySize][arraySize];
        int number = 1;
        int row = 0;
        int column = 0;

        while (number <= arraySize * arraySize) {
            for (int i = column; i < arraySize - column; i++) {
                array[row][i] = number;
                number++;
            }
            for (int i = row + 1; i < arraySize - row; i++) {
                array[i][arraySize - column - 1] = number;
                number++;
            }
            for (int i = arraySize - column - 2; i >= column; i--) {
                array[arraySize - row - 1][i] = number;
                number++;
            }
            for (int i = arraySize - row - 2; i > row; i--) {
                array[i][column] = number;
                number++;
            }
            row++;
            column++;
        }

        return array;
    }
}