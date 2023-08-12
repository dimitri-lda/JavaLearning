package com.gb.final_test;

public class Toy {
    private final int id;
    private final String name;
    private final int dropFrequency;

    public Toy(int id, String name, int dropFrequency) {
        this.id = id;
        this.name = name;
        this.dropFrequency = dropFrequency;
    }

    public int getId() { return this.id; }
    public String getName() { return this.name; }
    public int getDropFrequency() { return this.dropFrequency; }
}
