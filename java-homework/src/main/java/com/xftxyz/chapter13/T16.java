package com.xftxyz.chapter13;

public class T16 {

    public static void main(String[] args) {

        // 有理数计算器
        if (args.length != 1) {
            System.out.println("Usage: java T16 \"1/2 + 1/3\"");
            System.exit(1);
        }

        String input = args[0];
        String[] parts = input.split(" ");
        Rational r1 = new Rational(parts[0]);
        Rational r2 = new Rational(parts[2]);
        String operator = parts[1];

        Rational result;
        switch (operator) {
            case "+":
                result = r1.add(r2);
                break;
            case "-":
                result = r1.subtract(r2);
                break;
            case "*":
                result = r1.multiply(r2);
                break;
            case "/":
                result = r1.divide(r2);
                break;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }

        System.out.println(result);
    }
}

class Rational {
    private int numerator;
    private int denominator;

    public Rational(String fraction) {
        String[] parts = fraction.split("/");
        this.numerator = Integer.parseInt(parts[0]);
        this.denominator = Integer.parseInt(parts[1]);
    }

    // Implement add, subtract, multiply, divide methods here
    public Rational add(Rational r) {
        int numerator = this.numerator * r.denominator + this.denominator * r.numerator;
        int denominator = this.denominator * r.denominator;
        return new Rational(numerator + "/" + denominator);
    }

    public Rational subtract(Rational r) {
        int numerator = this.numerator * r.denominator - this.denominator * r.numerator;
        int denominator = this.denominator * r.denominator;
        return new Rational(numerator + "/" + denominator);
    }

    public Rational multiply(Rational r) {
        int numerator = this.numerator * r.numerator;
        int denominator = this.denominator * r.denominator;
        return new Rational(numerator + "/" + denominator);
    }

    public Rational divide(Rational r) {
        int numerator = this.numerator * r.denominator;
        int denominator = this.denominator * r.numerator;
        return new Rational(numerator + "/" + denominator);
    }
}