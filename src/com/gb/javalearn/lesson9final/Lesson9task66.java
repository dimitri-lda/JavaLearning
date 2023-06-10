package com.gb.javalearn.lesson9final;

import java.util.Scanner;

/*
 Задача 66: Задайте значения M и N. Напишите программу, которая найдёт сумму натуральных элементов в промежутке от M до N.
 Task 66: Set the values of M and N. Write a program that will find the sum of positive integers between M and N.
 */
public class Lesson9task66 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число m: ");
        int m = scanner.nextInt();
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();
        int sum = sumNaturalNumbers(m, n);
        System.out.printf("Сумма натуральных чисел от %d до %d: %d\n", m, n, sum);
    }

    public static int sumNaturalNumbers(int m, int n) {
        if (m > n) {
            return 0;
        } else {
            return m + sumNaturalNumbers(m + 1, n);
        }
    }
}
