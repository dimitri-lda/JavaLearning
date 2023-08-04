package com.gb.java_exceptions.lesson3;

public class InvalidUserDataInputAmountException extends RuntimeException {
    public InvalidUserDataInputAmountException(int expectedAmount, int actualAmount) {
        super(
            "Неверное кол-во вводимых параметров пользователя! " +
            "Ожидается: " + expectedAmount + ", введено: " + actualAmount
        );
    }
}
