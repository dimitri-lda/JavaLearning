package com.gb.java_api;

import java.util.Random;

/*
 Первый семинар:
 1. Выбросить случайное целое число в диапазоне от 0 до 2000 и сохранить в i
 2. Посчитать и сохранить в n номер старшего значащего бита выпавшего числа
 3. Найти все кратные n числа в диапазоне от i до Short.MAX_VALUE сохранить в массив m1
 4. Найти все некратные n числа в диапазоне от Short.MIN_VALUE до i и сохранить в массив m2

 Пункты реализовать в методе main
 *Пункты реализовать в разных методах
 */
public class Lesson1 {
    public static void main(String[] args) {
        int randTo = 2000;
        int i = task1GetRand(randTo);
        System.out.printf("Рандомное число от 0 до %d: %d \n", randTo, i);
        int n = task2GetHighBit(i);
        System.out.println("Номер старшего значащего бита: " + n);
        int[] m1 = task3GetDivedToN(n, i);
        printArrayOfInts(m1, 1);
        int[] m2 = task4GetNotDivedToN(n, i);
        printArrayOfInts(m2, 2);
    }

    private static int task1GetRand(int randTo) {
        Random rand = new Random();
        return rand.nextInt(randTo);
    }

    private static int task2GetHighBit(int i) {
        return Integer.SIZE - Integer.numberOfLeadingZeros(i) - 1;
    }

    private static int[] task3GetDivedToN(int n, int i) {
        int[] m1 = new int[]{};
        for (int j = i; j < Short.MAX_VALUE; j++) {
            if (j % n == 0) {
                m1 = addNewElementToArray(m1, j);
            }
        }
        return m1;
    }

    private static int[] task4GetNotDivedToN(int n, int i) {
        int[] m2 = new int[]{};
        for (int j = Short.MIN_VALUE; j < i; j++) {
            if (j % n != 0) {
                m2 = addNewElementToArray(m2, j);
            }
        }
        return m2;
    }

    private static int[] addNewElementToArray(int[] arr, int n) {
        int[] newArray = new int[arr.length + 1];
        for (int i=0; i < arr.length; i++) {
            newArray[i] = arr[i];
        }
        newArray[arr.length] = n;
        return newArray;
    }

    private static void printArrayOfInts(int[] array, int arrayIndex) {
        System.out.print("Массив m" + arrayIndex + ": [");
        for (int j : array) {
            System.out.printf("%d ", j);
        }
        System.out.print("]\r\n");
    }
}