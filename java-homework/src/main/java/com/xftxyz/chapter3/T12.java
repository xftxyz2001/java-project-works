package com.xftxyz.chapter3;

import java.util.Scanner;

public class T12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a three-digit integer: ");
        int number = scanner.nextInt();
        scanner.close();

        int d1 = number / 100;
        int remaining = number % 100;

        // int d2 = remaining / 10;
        remaining = remaining % 10;

        int d3 = remaining;

        System.out.println((d1 == d3 ? number + " is a palindrome" : number + " is not a palindrome"));
    }
}
