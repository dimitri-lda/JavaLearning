package com.gb.javalearn;

import java.util.Random;

/*
 Задача 47: Задайте двумерный массив размером m×n, заполненный случайными вещественными числами.
 Задача 50: Напишите программу, которая на вход принимает позиции элемента в двумерном массиве, и возвращает значение этого элемента или же указание, что такого элемента нет.
 Задача 52: Задайте двумерный массив из целых чисел. Найдите среднее арифметическое элементов в каждом столбце.
 */
public class LessonCs7 {
    public static void main(String[] args) {
        task47();
//        task50();
//        task52();
    }

    private static void task47() {
        int col = 3;
        int raw = 4;
        double[][] array = generate2DemArray(col, raw);

        print2DemArray(array);
    }

    private static double[][] generate2DemArray(int col, int raw) {
        double[][] array = new double[col][raw];
        Random rand = new Random();
        for (int colIndex = 0; colIndex<array.length; colIndex++) {
            for (int rawIndex = 0; rawIndex<array[colIndex].length; rawIndex++) {
                array[colIndex][rawIndex] = rand.nextInt(9) - 5 + (double) rand.nextInt(9) / 10;
            }
        }
        return array;
    }

    private static void task50() {

    }

    private static void task52() {

    }

    private static void print2DemArray(double[][] array) {
        System.out.print("Двумерный массив:\r\n");
        for (double[] i : array) {
            for (double j : i) {
                System.out.printf("%.1f ", j);
            }
            System.out.print("\r\n");
        }
        System.out.print("\r\n");
    }
}