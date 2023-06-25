package com.gb.java_api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/*
 Реализуйте структуру телефонной книги с помощью HashMap.
 Программа также должна учитывать, что во входной структуре будут повторяющиеся имена с разными телефонами,
 их необходимо считать, как одного человека с разными телефонами. Вывод должен быть отсортирован по убыванию числа телефонов.
 */
public class Lesson5 {
    public static void main(String[] args) {
        String message = "Введите Имя и номер телефона контакта через пробел. " +
                "Для выхода введите 0: ";
        Scanner scanner = new Scanner(System.in);
        HashMap<String, ArrayList<Integer>> phonebook = new HashMap<>();
        System.out.println(message);
        while (!scanner.hasNextInt() || scanner.nextInt() != 0) {
            String[] contact = scanner.nextLine().split(" ");
            String name = contact[0];
            Integer phone = Integer.parseInt(contact[1]);

            if (phonebook.containsKey(name)) {
                phonebook.get(name).add(phone);
            } else {
                ArrayList<Integer> phones = new ArrayList<>();
                phones.add(phone);
                phonebook.put(name, phones);
            }
            System.out.println(message);
        }
        System.out.println(phonebook);

        ArrayList<String> names = new ArrayList<>(phonebook.keySet());
        names.sort((o1, o2) -> phonebook.get(o2).size() - phonebook.get(o1).size());

        System.out.println("\nСписок контактов отсортированных по количеству телефонов:");
        for (String nameIndex : names) {
            System.out.println(nameIndex + ": " + phonebook.get(nameIndex));
        }
    }
}