package com.gb.java_api;

import java.util.*;

enum Male {
    John,
    Dmitrii,
    Evgenii,
    Michale,
    Esteban,
    Sharle,
    Fernando,
    Max,
    Stan,
    Niko
}
enum Female {
    Elen,
    lisa,
    Monica,
    Rachel,
    Anna,
    Natali,
    Kira,
    Nadiya,
    Maria,
    Sara
}

public class Lesson5sem {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task2() {
        Map<Integer, String> maleNames = new HashMap<>();
        Map<Integer, String> femaleNames = new HashMap<>();

        for (var male: Male.values()) {
            maleNames.put(new Random().nextInt(10), male.toString());
        }
        System.out.println(maleNames);
        for (var female: Female.values()) {
            femaleNames.put(new Random().nextInt(10), female.toString());
        }
        System.out.println(femaleNames);
        for (var maleName: maleNames.entrySet()) {
            if (femaleNames.containsKey(maleName.getKey())) {
                System.out.println(maleName.getKey() + ": " + maleName.getValue() + " " + femaleNames.get(maleName.getKey()));
            }
        }
    }

    private static void task1() {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            mp.put(i, new Random().nextInt(0, 100));
        }
        System.out.println(mp);

        for (int key: mp.keySet()) {
            if (mp.get(key) % 3 == 0) {
                System.out.println(key + ": " + mp.get(key));
            }
        }
    }
}