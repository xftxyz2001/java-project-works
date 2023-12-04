package com.xftxyz.chapter3;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.close();

        double discriminant = Math.pow(b, 2) - 4 * a * c;
        if (discriminant > 0) {
            double r1 = (-b + Math.pow(discriminant, 0.5)) / 2 / a;
            double r2 = (-b - Math.pow(discriminant, 0.5)) / 2 / a;
            System.out.println("The equation has two roots " + r1 + " and " + r2);
        } else if (discriminant == 0) {
            double r = -b / 2 / a;
            System.out.println("The equation has one root " + r);
        } else {
            System.out.println("The equation has no real roots");
        }
    }
}
