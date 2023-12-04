package com.xftxyz.chapter6;

import java.util.Scanner;

public class T34 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter full year (e.g., 2012): ");
        int year = scanner.nextInt();

        System.out.print("Enter month as a number between 1 and 12: ");
        int month = scanner.nextInt();
        scanner.close();

        printMonth(year, month);

    }

    public static void printMonth(int year, int month) {
        printMonthTitle(year, month);
        printMonthBody(year, month);
    }

    private static void printMonthTitle(int year, int month) {
        System.out.println("         " + getMonthName(month) + " " + year);
        System.out.println("-----------------------------");
        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");
    }

    private static String getMonthName(int month) {
        String monthName = "";
        switch (month) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "Feburary";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "Octorber";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
        }
        return monthName;
    }

    private static void printMonthBody(int year, int month) {
        int startDay = getStartDay(year, month);
        int numberOfDaysInMonth = getNumberOfDaysInMonth(year, month);

        int i = 0;
        for (i = 0; i < startDay; i++) {
            System.out.print("    ");
        }

        for (i = 1; i <= numberOfDaysInMonth; i++) {
            System.out.printf("%4d", i);
            if ((i + startDay) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }

    private static int getStartDay(int year, int month) {
        int q = 1;
        int m = month;
        if (month == 1) {
            m = 13;
            year--;
        } else if (month == 2) {
            m = 14;
            year--;
        }
        int j = year / 100;
        int k = year % 100;

        int h = (q + (26 * (m + 1)) / 10 + k + k / 4 + j / 4 + 5 * j) % 7;
        return (h + 6) % 7;
    }

    // private static int getStartDay(int year, int month) {
    // final int START_DAY_FOR_JAN_1_1800 = 3;
    // int totalNumberOfDays = getTotalNumberOfDays(year, month);
    // return (totalNumberOfDays + START_DAY_FOR_JAN_1_1800) % 7;
    // }

    // private static int getTotalNumberOfDays(int year, int month) {
    // int total = 0;
    // for (int i = 1800; i < year; i++) {
    // if (isLeapYear(i)) {
    // total += 366;
    // } else {
    // total += 365;
    // }
    // }
    // for (int i = 1; i < month; i++) {
    // total += getNumberOfDaysInMonth(year, i);
    // }
    // return total;
    // }

    private static int getNumberOfDaysInMonth(int year, int month) {
        if (month == 1 || month == 3 || month == 5
                || month == 7 || month == 8 || month == 10
                || month == 12) {
            return 31;
        }
        if (month == 4 || month == 6 || month == 9
                || month == 11) {
            return 30;
        }
        if (month == 2) {
            return isLeapYear(year) ? 29 : 28;
        }
        return 0;
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }
}
