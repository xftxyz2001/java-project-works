package com.xftxyz.chapter4;

import java.util.Scanner;

public class T20 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.nextLine();
        scanner.close();

        System.out.println("The length of the string is " + s.length());
        System.out.println("The first character of the string is " + s.charAt(0));
    }
}
