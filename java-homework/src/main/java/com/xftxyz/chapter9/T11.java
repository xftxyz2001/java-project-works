package com.xftxyz.chapter9;

import java.util.Scanner;

public class T11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a, b, c, d, e, f: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double d = scanner.nextDouble();
        double e = scanner.nextDouble();
        double f = scanner.nextDouble();
        scanner.close();

        LinearEquation linearEquation = new LinearEquation(a, b, c, d, e, f);
        if (!linearEquation.isSolvable()) {
            System.out.println("The equation has no solution.");
        } else {
            System.out.println("x is " + linearEquation.getX() + " and y is " + linearEquation.getY());
        }

    }
}

class LinearEquation {

    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

    LinearEquation(double a, double b, double c, double d, double e, double f) {
        if (!isSolvable())
            System.out.println("The equation has no solution.");

        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
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

    double getD() {
        return d;
    }

    double getE() {
        return e;
    }

    double getF() {
        return f;
    }

    boolean isSolvable() {
        return a * d - b * c != 0;
    }

    double getX() {
        return (e * d - b * f) / (a * d - b * c);
    }

    double getY() {
        return (a * f - e * c) / (a * d - b * c);
    }
}