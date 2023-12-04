package com.xftxyz.chapter13;

import java.util.Scanner;

public class T17 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first complex number: ");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        Complex c1 = new Complex(a, b);

        System.out.print("Enter the second complex number: ");
        a = scanner.nextDouble();
        b = scanner.nextDouble();
        Complex c2 = new Complex(a, b);

        scanner.close();

        System.out.println(c1 + " + " + c2 + " = " + c1.add(c2));
        System.out.println(c1 + " - " + c2 + " = " + c1.subtract(c2));
        System.out.println(c1 + " * " + c2 + " = " + c1.multiply(c2));
        System.out.println(c1 + " / " + c2 + " = " + c1.divide(c2));
        System.out.println("|" + c1 + "| = " + c1.abs());

    }
}

class Complex implements Cloneable, Comparable<Complex> {

    private double a;
    private double b;

    public Complex() {
        this(0, 0);
    }

    public Complex(double a) {
        this(a, 0);
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Complex add(Complex c) {
        return new Complex(a + c.a, b + c.b);
    }

    public Complex subtract(Complex c) {
        return new Complex(a - c.a, b - c.b);
    }

    public Complex multiply(Complex c) {
        return new Complex(a * c.a - b * c.b, a * c.b + b * c.a);
    }

    public Complex divide(Complex c) {
        return new Complex((a * c.a + b * c.b) / (c.a * c.a + c.b * c.b),
                (b * c.a - a * c.b) / (c.a * c.a + c.b * c.b));
    }

    public double abs() {
        return Math.sqrt(a * a + b * b);
    }

    @Override
    public String toString() {
        if (b == 0) {
            return a + "";
        } else {
            return a + " + " + b + "i";
        }
    }

    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }

    @Override
    public int compareTo(Complex o) {
        if (this.abs() > o.abs()) {
            return 1;
        } else if (this.abs() < o.abs()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public Complex clone() {
        try {
            return (Complex) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

}