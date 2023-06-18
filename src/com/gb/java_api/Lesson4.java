package com.gb.java_api;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/*
 1) Организовать ввод и хранение данных пользователей. ФИО возраст и пол
 2) вывод в формате Фамилия И.О. возраст пол
 3) добавить возможность выхода или вывода списка отсортированного по возрасту!)
 4) *реализовать сортировку по возрасту с использованием индексов
 5) *реализовать сортировку по возрасту и полу с использованием индексов
 */
public class Lesson4 {
    public static void main(String[] args) {
        ArrayList<String[]> users = getUsersFromConsole();
        printUsers(users, "");

        sortByAge(users);
        printUsers(users, "отсортированных по возрасту");
    }

    private static void sortByAge(ArrayList<String[]> users) {
        users.sort(new Comparator<>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.parseInt(o1[3]) - Integer.parseInt(o2[3]);
            }
        });
    }

    private static ArrayList<String[]> getUsersFromConsole() {
        String message = "Введите Фамилию, Иия, Отчество, Возраст и Пол (м,ж) пользователя через пробел. " +
                "Для выхода введите 0: ";
        Scanner scanner = new Scanner(System.in);
        ArrayList<String[]> users = new ArrayList<>();
        System.out.println(message);
        while (!scanner.hasNextInt() || scanner.nextInt() != 0) {
            users.add(scanner.nextLine().split(" "));
            System.out.println(message);
        }
        return users;
    }

    private static void printUsers(ArrayList<String[]> users, String sortType) {
        System.out.println("\nСписок пользователей " + sortType + ":");
        for (String[] user : users) {
            System.out.println(
                    user[0] + " " + user[1].charAt(0) + "." + user[2].charAt(0) + ". " + user[3] + " " + user[4]
            );
        }
    }
}