package com.gb.javalearn.lesson9final;

import java.util.Scanner;

/*
 Задача 64: Задайте значение N. Напишите программу, которая выведет все натуральные числа в промежутке от N до 1. Выполнить с помощью рекурсии.
 Task 64: Set the value to N. Write a program that prints all natural numbers between N and 1. Execute using recursion.
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


