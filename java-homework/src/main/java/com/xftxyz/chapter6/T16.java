package com.xftxyz.chapter6;

public class T16 {

    public static int numberOfDaysInAYear(int year) {
        if (isLeapYear(year)) {
            return 366;
        } else {
            return 365;
        }
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {

        System.out.println("Year\tDays");
        System.out.println("-------------");
        for (int i = 2000; i <= 2020; i++) {
            System.out.printf("%d\t%d\n", i, numberOfDaysInAYear(i));
        }
    }
}
