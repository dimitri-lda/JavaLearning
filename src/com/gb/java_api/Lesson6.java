package com.gb.java_api;

import java.util.HashMap;
import java.util.Iterator;

/*
 Разработать программу, имитирующую поведение коллекции HashSet. В программе содать метод add добавляющий элемент,
 метод toString возвращающий строку с элементами множества и метод позволяющий читать элементы по индексу.
 *Реализовать все методы из семинара.
 Формат данных Integer.
 */
public class Lesson6 {
    public static void main(String[] args) {
        MySet<Integer> ms = new MySet<>();
        System.out.println(ms.add(9));
        System.out.println(ms.add(9));
        System.out.println(ms.add(7));
        System.out.println("Size: " + ms.size());
        System.out.println(ms.remove(9));
        System.out.println(ms.remove(9));
        ms.add(10);
        ms.add(12);
        ms.add(5);
        System.out.println("Size: " + ms.size());
        System.out.println();

        Iterator<Integer> iter = ms.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        System.out.println(ms);
//      or System.out.println(ms.toString());
    }
}

class MySet<E> {
    private HashMap<E, Object> mp;
    private static final Object OBJ = new Object();

    public MySet() {
        mp = new HashMap<>();
    }

    public boolean add(E num) {
        return mp.put(num, OBJ) == null;
    }

    public boolean remove(E num) {
        return mp.remove(num) != null;
    }

    public int size() {
        return mp.size();
    }

    public Iterator<E> iterator() {
        return mp.keySet().iterator();
    }

    public String toString() {
        String str = "";
        for (E num: mp.keySet()) {
            str += num + "; ";
        }

        return str;
    }
}