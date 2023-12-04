package com.xftxyz.chapter2;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a value for feet: ");
        double feet = scanner.nextDouble();
        scanner.close();

        double meters = feet * 0.305;
        System.out.println(feet + " feet is " + meters + " meters");
    }
}
