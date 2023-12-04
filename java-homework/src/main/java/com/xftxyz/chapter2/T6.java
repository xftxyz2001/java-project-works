package com.xftxyz.chapter2;

import java.util.Scanner;

public class T6 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 1000: ");
        int number = scanner.nextInt();
        scanner.close();

        int sum = number % 10 + number / 10 % 10 + number / 100;
        System.out.println("The sum of the digits is " + sum);
    }
}
