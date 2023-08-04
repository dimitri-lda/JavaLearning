package com.gb.java_exceptions.lesson2;

import java.util.Scanner;

/**
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение, что пустые строки вводить нельзя.
 */
public class Task4 {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        try {
            String str = getString();
            System.out.println("Введена строка: " + str);
        } catch (EmptyLineException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getString() throws EmptyLineException {
        System.out.println("Введите строку:");
        Scanner reader = new Scanner(System.in);
        String result = reader.nextLine();
        if (result.isEmpty()) {
            throw new EmptyLineException();
        }
        return result;
    }
}
