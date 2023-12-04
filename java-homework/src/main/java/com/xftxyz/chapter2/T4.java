package com.xftxyz.chapter2;

import java.util.Scanner;

public class T4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number in pounds: ");
        double pounds = scanner.nextDouble();
        scanner.close();

        double kilograms = pounds * 0.454;
        System.out.println(pounds + " pounds is " + kilograms + " kilograms");
    }
}
