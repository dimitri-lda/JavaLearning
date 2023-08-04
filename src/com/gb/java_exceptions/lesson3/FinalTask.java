package com.gb.java_exceptions.lesson3;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FinalTask {
    private static final int USER_DATA_PARAMS_AMOUNT = 6;
    private static String[] inputData;
    public static void main(String[] args) {
        try {
            inputData = readUserData();
            parseUserData();
        } catch (RuntimeException|IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void parseUserData() throws RuntimeException, IOException {
        String birthDate = parseBirthDate();;
        long phoneNumber = parsePhoneNumber();
        char gender = parseGender();
        String lastName = parseName();
        String firstName = parseName();
        String middleName = parseName();

        String dataToWrite = lastName + ' ' + firstName + ' ' + middleName + ' ' + birthDate + ' ' +
                phoneNumber + ' ' + gender + "\n";

        FileWriter fileWriter = new FileWriter("data/" + lastName + ".txt", true);
        fileWriter.write(dataToWrite);
        fileWriter.close();

        System.out.println("Данные успешно записаны в файл");
    }

    private static String[] readUserData() throws InvalidUserDataInputAmountException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите Фамилия Имя Отчество ДатаРождения НомерТелефона Пол:");
        String input = scanner.nextLine();

        String[] inputData = input.split(" ");
        if (inputData.length != USER_DATA_PARAMS_AMOUNT) {
            throw new InvalidUserDataInputAmountException(USER_DATA_PARAMS_AMOUNT, inputData.length);
        }
        return inputData;
    }

    private static String parseBirthDate() throws RuntimeException {
        for (String data : inputData) {
            if (data.matches("\\d{2}.\\d{2}.\\d{4}")) {
                removeFromInputData(data);
                return data;
            }
        }
        throw new RuntimeException("Неверный формат даты рождения");
    }

    private static long parsePhoneNumber() throws RuntimeException {
        for (String data : inputData) {
            if (data.matches("\\d+")) {
                removeFromInputData(data);
                return Long.parseLong(data.trim());
            }
        }
        throw new RuntimeException("Неверный формат номера телефона");
    }

    private static char parseGender() throws RuntimeException {
        for (String data : inputData) {
            if (data.matches("[fmFM]")) {
                removeFromInputData(data);
                return data.charAt(0);
            }
        }
        throw new RuntimeException("Неверный формат пола");
    }

    private static String parseName() throws RuntimeException {
        for (String data : inputData) {
            if (data.matches("[a-zA-Zа-яА-Я]+")) {
                removeFromInputData(data);
                return data;
            }
        }
        throw new RuntimeException("Неверный формат имени");
    }

    private static void removeFromInputData(String element) {
        String[] newArray = new String[inputData.length - 1];
        int j = 0;
        for (String s : inputData) {
            if (!s.equals(element)) {
                newArray[j++] = s;
            }
        }
        inputData = newArray;
    }
}
