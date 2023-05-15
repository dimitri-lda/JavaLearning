package com.gb.javalearn.cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        int discountLimit = 60;
        int regPrice = 10;
        int discPrice = 8;
        int totalPrice;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatsInRow = scanner.nextInt();
        int seatsNumber = rows * seatsInRow;
        if (seatsNumber > discountLimit) {
            int rowsInFirstHalf = rows / 2;
            int firstHalf = seatsInRow * rowsInFirstHalf;
            int secHalf = seatsInRow * (rows - rowsInFirstHalf);
            totalPrice = discPrice * secHalf + regPrice * firstHalf;
        } else {
            totalPrice = regPrice * seatsNumber;
        }
        System.out.println("Total income:");
        System.out.print('$');
        System.out.print(totalPrice);
    }
}