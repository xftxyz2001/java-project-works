package com.xftxyz.chapter9;

import java.util.Scanner;

public class T10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        scanner.close();

        QuadraticEquation quadraticEquation = new QuadraticEquation(a, b, c);
        if (quadraticEquation.getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else if (quadraticEquation.getDiscriminant() == 0) {
            System.out.println("The equation has one root " + quadraticEquation.getRoot1());
        } else {
            System.out.println("The equation has two roots " + quadraticEquation.getRoot1() + " and "
                    + quadraticEquation.getRoot2());
        }
    }
}

class QuadraticEquation {

    private double a;
    private double b;
    private double c;

    QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    double getA() {
        return a;
    }

    double getB() {
        return b;
    }

    double getC() {
        return c;
    }

    double getDiscriminant() {
        return b * b - 4 * a * c;
    }

    double getRoot1() {
        if (getDiscriminant() < 0) {
            return 0;
        } else {
            return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
        }
    }

    double getRoot2() {
        if (getDiscriminant() < 0) {
            return 0;
        } else {
            return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
        }
    }
}