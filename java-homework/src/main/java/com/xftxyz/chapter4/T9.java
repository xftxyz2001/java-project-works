package com.xftxyz.chapter4;

import java.util.Scanner;

public class T9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a character: ");
        char ch = scanner.next().charAt(0);
        scanner.close();

        int code = (int) ch;
        System.out.println("The Unicode for the character " + ch + " is " + code);
    }
}
