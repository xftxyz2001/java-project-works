package com.xftxyz.chapter2;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a degree in Celsius: ");
        double celsius = scanner.nextDouble();
        scanner.close();

        double fahrenheit = (9.0 / 5) * celsius + 32;
        System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit");
    }
}
