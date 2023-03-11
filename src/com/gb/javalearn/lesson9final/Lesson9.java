package com.gb.javalearn.lesson9final;

import java.util.Scanner;

public class Lesson9 {
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

