package com.xftxyz.chapter5;

import java.util.Scanner;

public class T47 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 12 digits of an ISBN-13 as a string: ");
        String isbn12 = scanner.next();
        scanner.close();
        if (isbn12.length() != 12) {
            System.out.println(isbn12 + " is an invalid input");
            System.exit(1);
        }

        int sum = 0;
        for (int i = 0; i < isbn12.length(); i++) {
            int number = isbn12.charAt(i) - '0';
            if (i % 2 == 0) {
                sum += number;
            } else {
                sum += number * 3;
            }
        }
        int d13 = 10 - sum % 10;
        if (d13 == 10) {
            d13 = 0;
        }

        String isbn13 = isbn12 + d13;
        System.out.println("The ISBN-13 number is " + isbn13);

    }
}
