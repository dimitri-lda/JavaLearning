package com.javalearn;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String username = scanner.nextLine();

        System.out.println("Enter your age:");
        int age = scanner.nextInt();

        System.out.println("Enter you sex (M or W):");
        String user_sex = scanner.next();
        char sex = user_sex.charAt(0);

        System.out.println("Hello, " + username + "!");
        System.out.println("Your age is: " + age + ";");
        System.out.println("Your sex is: " + sex + ".");
    }
}