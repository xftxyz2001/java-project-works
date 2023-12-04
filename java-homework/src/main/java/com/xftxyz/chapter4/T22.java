package com.xftxyz.chapter4;

import java.util.Scanner;

public class T22 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter string s1: ");
        String s1 = scanner.nextLine();
        System.out.print("Enter string s2: ");
        String s2 = scanner.nextLine();
        scanner.close();

        boolean isSubString = s1.contains(s2);
        System.out.println(s2 + (isSubString ? " is " : " is not ") + "a substring of " + s1);
    }
}
