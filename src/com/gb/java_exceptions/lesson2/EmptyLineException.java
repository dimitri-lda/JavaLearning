package com.gb.java_exceptions.lesson2;

public class EmptyLineException extends RuntimeException {
    public EmptyLineException() {
        super("Пустые строки вводить нельзя!");
    }
}
