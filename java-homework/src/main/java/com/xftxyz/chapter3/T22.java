package com.xftxyz.chapter3;

import java.util.Scanner;

public class T22 {

    public static void main(String[] args) {

        double x0 = 0;
        double y0 = 0;
        double radius = 10;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a point with two coordinates: ");
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        scanner.close();

        double distance = Math.pow(Math.pow(x1 - x0, 2) + Math.pow(y1 - y0, 2), 0.5);

        if (distance <= radius) {
            System.out.println("Point (" + x1 + ", " + y1 + ") is in the circle");
        } else {
            System.out.println("Point (" + x1 + ", " + y1 + ") is not in the circle");
        }

    }
}
