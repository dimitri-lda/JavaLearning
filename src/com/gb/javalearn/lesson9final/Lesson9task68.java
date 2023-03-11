package com.gb.javalearn.lesson9final;

import java.util.Scanner;

/*
 Задача 68: Напишите программу вычисления функции Аккермана с помощью рекурсии. Даны два неотрицательных числа m и n.
 Task 68: Write a program to calculate the Ackermann function using recursion. Two non-negative numbers m and n are given.
 */
public class Lesson9task68 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число m: ");
        int m = scanner.nextInt();
        System.out.print("Введите число n: ");
        int n = scanner.nextInt();
        int result = ackermann(m, n);
        System.out.printf("A(%d,%d) = %d\n", m, n, result);
    }

    public static int ackermann(int m, int n) {
        if (m == 0) {
            return n + 1;
        } else if (n == 0) {
            return ackermann(m - 1, 1);
        } else {
            return ackermann(m - 1, ackermann(m, n - 1));
        }
    }
}
