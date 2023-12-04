package com.xftxyz.chapter4;

import java.util.Scanner;

public class T21 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a SSN: ");
        String s = scanner.nextLine();
        scanner.close();

        boolean matches = s.matches("\\d{3}-\\d{2}-\\d{4}");
        System.out.println(s + " is " + (matches ? "a valid " : "an invalid ") + "social security number");
    }
}
