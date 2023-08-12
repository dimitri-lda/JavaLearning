package com.gb.final_test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Random;

/**
 * 1) Напишите класс-конструктор у которого принимает минимум 3 строки,
 * содержащие три поля id игрушки, текстовое название и частоту выпадения
 * игрушки
 * 2) Из принятой строки id и частоты выпадения(веса) заполнить минимум три
 * массива.
 * 3) Используя API коллекцию: PriorityQueue добавить элементы в
 * коллекцию
 * 4) Организовать общую очередь
 * 5) Вызвать Get 10 раз и записать результат в файл
 */

public class Main {
    private static final PriorityQueue<Toy> toyQueue = new PriorityQueue<>(
        (t1, t2) -> Double.compare(t2.getDropFrequency(), t1.getDropFrequency())
    );
    private static final int getNumber = 10;
    private static final String fileName = "data/final-results.txt";

    public static void main(String[] args) {
        String[] testData = {
            "1 2 конструктор",
            "2 2 робот",
            "3 6 кукла"
        };

        // Добавляем игрушек в очередь
        putToysIntoQueue(testData);

        // Получаем игрушки из очереди и записываем в файл
        try {
            getToyAndWriteToFile();
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void putToysIntoQueue(String[] testData) {
        Toy[] toys = toysDataToToysArray(testData);
        ArrayList<Toy> toysList = prepareToysListAccordingToFrequency(toys);
        for (int i = 0; i < getNumber; i++) {
            toyQueue.add(getToyAccordingToDropFrequency(toysList));
        }
    }

    private static void getToyAndWriteToFile() throws RuntimeException {
        while (!toyQueue.isEmpty()) {
            Toy toy = toyQueue.poll();
            String lineText = "Toy ID: " + toy.getId() + " Name: " + toy.getName() + "\n";

            try (FileWriter writer = new FileWriter(fileName)) {
                writer.write(lineText);
            } catch (IOException e) {
                throw new RuntimeException("An error occurred. " + e.getMessage());
            }
            System.out.println(lineText);
        }
    }

    private static Toy[] toysDataToToysArray(String[] toysData) {
        Toy[] toys = new Toy[toysData.length];
        for (int i = 0; i < toysData.length; i++) {
            String[] params = toysData[i].split(" ");
            if (params.length < 3) {
                System.out.println("Invalid toy params, skipping.");
                continue;
            }
            toys[i] = new Toy(Integer.parseInt(params[0]), params[2], Integer.parseInt(params[1]));
        }
        return toys;
    }

    private static ArrayList<Toy> prepareToysListAccordingToFrequency(Toy[] toys) {
        ArrayList<Toy> toysListAccordingToFrequency = new ArrayList<>();
        for (Toy toy : toys) {
            for (int i = 0; i < toy.getDropFrequency(); i++) {
                toysListAccordingToFrequency.add(toy);
            }
        }
        return toysListAccordingToFrequency;
    }

    private static Toy getToyAccordingToDropFrequency(ArrayList<Toy> toysList) {
        return toysList.get((new Random()).nextInt(toysList.size()));
    }
}
