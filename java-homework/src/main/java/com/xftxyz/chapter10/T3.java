package com.xftxyz.chapter10;

public class T3 {

    public static void main(String[] args) {

        MyInteger myInteger = new MyInteger(5);
        System.out.println(myInteger.isEven());
        System.out.println(myInteger.isOdd());
        System.out.println(myInteger.isPrime());

        System.out.println(MyInteger.isEven(5));
        System.out.println(MyInteger.isOdd(5));
        System.out.println(MyInteger.isPrime(5));

        System.out.println(MyInteger.isEven(myInteger));
        System.out.println(MyInteger.isOdd(myInteger));
        System.out.println(MyInteger.isPrime(myInteger));

        System.out.println(myInteger.equals(5));
        System.out.println(myInteger.equals(myInteger));

        System.out.println(MyInteger.parseInt(new char[] { '1', '2', '3' }));
        System.out.println(MyInteger.parseInt("123"));
    }
}

class MyInteger {

    private int value;

    MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return value % 2 == 0;
    }

    public boolean isOdd() {
        return value % 2 != 0;
    }

    public boolean isPrime() {
        if (value == 2) {
            return true;
        }
        if (value % 2 == 0) {
            return false;
        }
        for (int i = 3; i < value; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(int value) {
        return value % 2 == 0;
    }

    public static boolean isOdd(int value) {
        return value % 2 != 0;
    }

    public static boolean isPrime(int value) {
        if (value == 2) {
            return true;
        }
        if (value % 2 == 0) {
            return false;
        }
        for (int i = 3; i < value; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isEven(MyInteger value) {
        return value.isEven();
    }

    public static boolean isOdd(MyInteger value) {
        return value.isOdd();
    }

    public static boolean isPrime(MyInteger value) {
        return value.isPrime();
    }

    public boolean equals(int value) {
        return this.value == value;
    }

    public boolean equals(MyInteger value) {
        return this.value == value.getValue();
    }

    public static int parseInt(char[] chars) {
        int value = 0;
        for (char c : chars) {
            value = value * 10 + (c - '0');
        }
        return value;
    }

    public static int parseInt(String str) {
        int value = 0;
        for (char c : str.toCharArray()) {
            value = value * 10 + (c - '0');
        }
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}