package com.xftxyz.chapter3;

import java.util.Scanner;

public class T9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first 9 digits of an ISBN as integer: ");
        int isbn = scanner.nextInt();
        scanner.close();

        int d1 = isbn / 100000000;
        int remaining = isbn % 100000000;

        int d2 = remaining / 10000000;
        remaining = remaining % 10000000;

        int d3 = remaining / 1000000;
        remaining = remaining % 1000000;

        int d4 = remaining / 100000;
        remaining = remaining % 100000;

        int d5 = remaining / 10000;
        remaining = remaining % 10000;

        int d6 = remaining / 1000;
        remaining = remaining % 1000;

        int d7 = remaining / 100;
        remaining = remaining % 100;

        int d8 = remaining / 10;
        remaining = remaining % 10;

        int d9 = remaining;

        int d10 = (d1 * 1 + d2 * 2 + d3 * 3 + d4 * 4 + d5 * 5
                + d6 * 6 + d7 * 7 + d8 * 8 + d9 * 9) % 11;

        System.out.print("The ISBN-10 number is ");
        // if (d10 == 10) {
        // System.out.println(d1 + "" + d2 + "" + d3 + "" + d4 + "" + d5 + ""
        // + d6 + "" + d7 + "" + d8 + "" + d9 + "X");
        // } else {
        // System.out.println(d1 + "" + d2 + "" + d3 + "" + d4 + "" + d5 + ""
        // + d6 + "" + d7 + "" + d8 + "" + d9 + "" + d10);
        // }
        System.out.println(d1 + "" + d2 + "" + d3 + "" + d4 + "" + d5 + ""
                + d6 + "" + d7 + "" + d8 + "" + d9 + "" + (d10 == 10 ? "X" : d10));
    }
}
