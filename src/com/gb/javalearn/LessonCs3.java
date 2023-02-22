package com.gb.javalearn;

import java.util.Arrays;
import java.util.Scanner;

public class LessonCs3 {
    public static void main(String[] args) {
        task19();
        task21();
        task23();
    }

    private static void task19() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");

        int num = scan.nextInt();
        if (isArrayPalindrome(num)) {
            System.out.println("Число " + num + " полиндром");
        } else {
            System.out.println("Число " + num + " не является полиндромом");
        }
    }

    private static boolean isArrayPalindrome(int num) {
        char[] strNum = Integer.toString(num).toCharArray();
        char[] reversedArray = new char[strNum.length];
        for (int i = 0, j = strNum.length - 1; i < strNum.length; i++, j--) {
            reversedArray[i] = strNum[j];
        }

        return Arrays.equals(strNum, reversedArray);
    }

    private static void task21() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите координаты точки А (x): ");
        int ax = scan.nextInt();
        System.out.println("Введите координаты точки А (y): ");
        int ay = scan.nextInt();
        System.out.println("Введите координаты точки А (z): ");
        int az = scan.nextInt();
        System.out.println("Введите координаты точки B (x): ");
        int bx = scan.nextInt();
        System.out.println("Введите координаты точки B (y): ");
        int by = scan.nextInt();
        System.out.println("Введите координаты точки B (z): ");
        int bz = scan.nextInt();

        System.out.printf("Расстояние: %.2f", get3dDistance(ax, ay, az, bx, by, bz));
    }

    private static double get3dDistance(int ax, int ay, int az, int bx, int by, int bz) {
        return Math.sqrt(Math.pow(ax - bx, 2) + Math.pow(ay - by, 2) + Math.pow(az - bz, 2));
    }

    private static void task23() {
        Scanner scan = new Scanner(System.in);
        System.out.print("Введите число: ");
        int num = scan.nextInt();

        System.out.println("Список кубов для " + num + ": ");
        for (int i = 1; i <= num; i++) {
            System.out.print((int) Math.pow(i, 3));
            if (i != num)
                System.out.print(", ");
        }
    }
}