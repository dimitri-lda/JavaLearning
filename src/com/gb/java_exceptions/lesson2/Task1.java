package com.gb.java_exceptions.lesson2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float), и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к падению приложения, вместо этого,
 * необходимо повторно запросить у пользователя ввод данных.
 */
public class Task1 {
    public static void main(String[] args) {
        float floatNum = getFloat();
        System.out.println("Введено число: " + floatNum);
    }

    private static float getFloat() {
        float result = 0;
        boolean isCorrect = false;
        System.out.println("Введите дробное число (дробь через зяпятую):");
        while (!isCorrect) {
            Scanner reader = new Scanner(System.in);
            try {
                result = reader.nextFloat();
                isCorrect = true;
            } catch (InputMismatchException e) {
                System.out.println("Введено не число. Повторите ввод:");
            }
        }
        return result;
    }
}
