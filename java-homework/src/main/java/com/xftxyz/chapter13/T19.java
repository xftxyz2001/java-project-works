package com.xftxyz.chapter13;

import java.math.BigInteger;
import java.util.Scanner;

public class T19 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal number: ");
        String decimal = scanner.next();
        scanner.close();

        Retional r = new Retional(decimal);
        System.out.println("The fraction number is " + r);
    }
}

class Retional extends Number implements Comparable<Retional> {

    private BigInteger numerator; // 分子
    private BigInteger denominator; // 分母

    public Retional() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    public Retional(BigInteger numerator, BigInteger denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        reduce();
    }

    public Retional(String fraction) {
        int index = fraction.indexOf("/");
        if (index != -1) {
            String numerator = fraction.substring(0, index);
            String denominator = fraction.substring(index + 1);
            this.numerator = new BigInteger(numerator);
            this.denominator = new BigInteger(denominator);
        } else {
            index = fraction.indexOf(".");
            if (index != -1) {
                String integer = fraction.substring(0, index);
                String decimal = fraction.substring(index + 1);
                this.numerator = new BigInteger(integer + decimal);
                this.denominator = BigInteger.TEN.pow(decimal.length());
            } else {
                this.numerator = new BigInteger(fraction);
                this.denominator = BigInteger.ONE;
            }

        }
        reduce();
    }

    // public Retional(String fraction) {
    // int index;
    // String numerator, denominator;

    // if ((index = fraction.indexOf("/")) != -1) {
    // numerator = fraction.substring(0, index);
    // denominator = fraction.substring(index + 1);
    // } else if ((index = fraction.indexOf(".")) != -1) {
    // String integer = fraction.substring(0, index);
    // String decimal = fraction.substring(index + 1);
    // numerator = integer + decimal;
    // denominator = String.valueOf(BigInteger.TEN.pow(decimal.length()));
    // } else {
    // numerator = fraction;
    // denominator = "1";
    // }

    // this.numerator = new BigInteger(numerator);
    // this.denominator = new BigInteger(denominator);
    // reduce();
    // }

    // 约分函数
    private void reduce() {
        BigInteger gcd = numerator.gcd(denominator);
        this.numerator = numerator.divide(gcd);
        this.denominator = denominator.divide(gcd);
    }

    public Retional add(Retional r) {
        BigInteger numerator = this.numerator.multiply(r.denominator).add(this.denominator.multiply(r.numerator));
        BigInteger denominator = this.denominator.multiply(r.denominator);
        return new Retional(numerator, denominator);
    }

    public Retional subtract(Retional r) {
        BigInteger numerator = this.numerator.multiply(r.denominator).subtract(this.denominator.multiply(r.numerator));
        BigInteger denominator = this.denominator.multiply(r.denominator);
        return new Retional(numerator, denominator);
    }

    public Retional multiply(Retional r) {
        BigInteger numerator = this.numerator.multiply(r.numerator);
        BigInteger denominator = this.denominator.multiply(r.denominator);
        return new Retional(numerator, denominator);
    }

    public Retional divide(Retional r) {
        BigInteger numerator = this.numerator.multiply(r.denominator);
        BigInteger denominator = this.denominator.multiply(r.numerator);
        return new Retional(numerator, denominator);
    }

    @Override
    public String toString() {
        if (denominator.equals(BigInteger.ONE)) {
            return numerator + "";
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override
    public int compareTo(Retional o) {
        if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) > 0) {
            return 1;
        } else if (this.subtract(o).getNumerator().compareTo(BigInteger.ZERO) < 0) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public int intValue() {
        return numerator.divide(denominator).intValue();
    }

    @Override
    public long longValue() {
        return numerator.divide(denominator).longValue();
    }

    @Override
    public float floatValue() {
        return numerator.divide(denominator).floatValue();
    }

    @Override
    public double doubleValue() {
        return numerator.divide(denominator).doubleValue();
    }

    public BigInteger getNumerator() {
        return numerator;
    }

    public BigInteger getDenominator() {
        return denominator;
    }

}