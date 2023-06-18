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

        // Задание 4 и 5
        indexSorting();
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

    private static void indexSorting() {
        String message = "Введите Фамилию, Иия, Отчество, Возраст и Пол (м,ж) пользователя через пробел. " +
                "Для выхода введите 0: ";
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> indexes = new ArrayList<>();
        ArrayList<String> surnames = new ArrayList<>();
        ArrayList<String> names = new ArrayList<>();
        ArrayList<String> patronymicNames = new ArrayList<>();
        ArrayList<Integer> ages = new ArrayList<>();
        ArrayList<Boolean> gender = new ArrayList<>();
        System.out.println(message);
        while (!scanner.hasNextInt() || scanner.nextInt() != 0) {
            String[] users = scanner.nextLine().split(" ");
            indexes.add(indexes.size());
            surnames.add(users[0]);
            names.add(users[1]);
            patronymicNames.add(users[2]);
            ages.add(Integer.parseInt(users[3]));
            gender.add(users[4].toLowerCase().equals("м"));
            System.out.println(message);
        }

        indexes.sort(new Comparator<>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return ages.get(i1).compareTo(ages.get(i2));
            }
        });

        System.out.println("\nСписок пользователей отсортированных по возрасту с использованием индексов:");
        for (int index : indexes) {
            System.out.println(
                    surnames.get(index) + " " + names.get(index).charAt(0) + "." + patronymicNames.get(index).charAt(0)
                            + ". " + ages.get(index) + " " + (gender.get(index) ? "м" : "ж")
            );
        }

        indexes.sort(new Comparator<>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return ages.get(i1) != ages.get(i2)
                        ? ages.get(i1) - ages.get(i2)
                        : gender.get(i1).compareTo(gender.get(i2));
            }
        });

        System.out.println("\nСписок пользователей отсортированных по возрасту и полу с использованием индексов:");
        for (int index : indexes) {
            System.out.println(
                    surnames.get(index) + " " + names.get(index).charAt(0) + "." + patronymicNames.get(index).charAt(0)
                            + ". " + ages.get(index) + " " + (gender.get(index) ? "м" : "ж")
            );
        }
    }
}