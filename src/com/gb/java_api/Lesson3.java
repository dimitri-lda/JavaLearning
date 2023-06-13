package com.gb.java_api;

import java.util.ArrayList;
import java.util.Collections;

/*
 Третий семинар:
 Пусть дан произвольный список целых чисел.

 1) Нужно удалить из него чётные числа
 2) Найти минимальное значение
 3) Найти максимальное значение
 4) Найти среднее значение
 */
public class Lesson3 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = generateArrayList();
        System.out.println("Список: " + list1);
        task1RemoveEven(list1);
        System.out.println("Список без четных чисел: " + list1);

        ArrayList<Integer> list2 = generateArrayList();
        System.out.println("\nСписок: " + list2);
        System.out.println("Минимальное значение в списке: " + task2FindMin(list2));
        System.out.println("Максимальное значение в списке: " + task3FindMax(list2));
        System.out.println("Среднее арифмитическое значение списка: " + task4AverageMax(list2));
        System.out.println("Ближайшее к среднему арифмитическому значение в списке: "
                + task4CloseToAverage(list2, task4AverageMax(list2)));
    }

    private static void task1RemoveEven(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);
            }
        }
    }

    private static int task2FindMin(ArrayList<Integer> list) {
        int min = list.get(0);
        for (int value : list) {
            if (value < min) {
                min = value;
            }
        }

//        min = Collections.min(list); // также можно через Collections
        return min;
    }

    private static int task3FindMax(ArrayList<Integer> list) {
        int max = list.get(0);
        for (int value : list) {
            if (value > max) {
                max = value;
            }
        }

//        max = Collections.max(list); // также можно через Collections
        return max;
    }

    private static double task4AverageMax(ArrayList<Integer> list) {
        int sum = 0;
        for (int value : list) {
            sum += value;
        }

        return (double) sum / list.size();
    }

    private static int task4CloseToAverage(ArrayList<Integer> list, double avg) {
        int closeToAvg = list.get(0);
        double minDiff = Math.abs(list.get(0) - avg);
        for (int i = 1; i < list.size(); i++) {
            double tempMinDiff = Math.abs(list.get(i) - avg);
            if (tempMinDiff < minDiff) {
                minDiff = tempMinDiff;
                closeToAvg = list.get(i);
            }
        }

        return closeToAvg;
    }

    private static ArrayList<Integer> generateArrayList() {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add((int) (Math.random() * 100));
        }
        return list;
    }
}