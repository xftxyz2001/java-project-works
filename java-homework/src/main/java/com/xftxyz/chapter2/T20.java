package com.xftxyz.chapter2;

import java.util.Scanner;

public class T20 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter balance and interest rate (e.g., 3 for 3%): ");
        double balance = scanner.nextDouble();
        double interestRate = scanner.nextDouble();
        scanner.close();

        double interest = balance * (interestRate / 1200);
        System.out.println("The interest is " + interest);
    }
}
