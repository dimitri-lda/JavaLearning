package com.gb.javalearn.lesson9final;

import java.util.Scanner;

/*
 Задача 66: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N.
 Task 66: Set the values of M and N. Write a program that will find the sum of positive integers between M and N.
 */
public class Lesson9task64 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число N: ");
        int N = scanner.nextInt();
        printNumbers(N);
    }

    public static void printNumbers(int n) {
        if (n != 0) {
            System.out.print(n + ", ");
            printNumbers(n - 1);
        }
    }
}


