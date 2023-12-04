package com.xftxyz.chapter4;

import java.util.Scanner;

public class T13 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a letter: ");
        char ch = scanner.next().charAt(0);
        scanner.close();

        if (ch < 'A' || ch > 'Z' && ch < 'a' || ch > 'z') {
            System.out.println(ch + " is an invalid input");
            System.exit(1);
        }

        ch = Character.toUpperCase(ch);

        if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            System.out.println(ch + " is a vowel");
        } else {
            System.out.println(ch + " is a consonant");
        }
    }
}
