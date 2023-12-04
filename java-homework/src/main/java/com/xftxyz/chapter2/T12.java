package com.xftxyz.chapter2;

import java.util.Scanner;

public class T12 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter speed and acceleration: ");
        double speed = scanner.nextDouble();
        double acceleration = scanner.nextDouble();
        scanner.close();

        double length = speed * speed / (2 * acceleration);
        System.out.println("The minimum runway length for this airplane is " + length);
    }
}
