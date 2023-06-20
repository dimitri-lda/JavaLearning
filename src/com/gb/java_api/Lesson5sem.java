package com.gb.java_api;

import java.util.*;


public class Lesson5sem {
    public static void main(String[] args) {
        Map<Integer, Integer> mp = new HashMap<Integer, Integer>();
        for (int i = 0; i < 10; i++) {
            mp.put(i, new Random().nextInt(0, 100));
        }
        for (var it: mp.entrySet()) System.out.println(it.getKey() + ": " + it.getValue());

        for (int key: mp.keySet()) {
            if (mp.get(key) % 3 == 0) {
                System.out.println(key + ": " + mp.get(key));
            }
        }
    }
}