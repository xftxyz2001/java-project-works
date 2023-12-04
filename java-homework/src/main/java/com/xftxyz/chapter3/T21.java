package com.xftxyz.chapter3;

import java.util.Scanner;

public class T21 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter year: (e.g., 2012): ");
        int year = scanner.nextInt();
        System.out.print("Enter month: 1-12: ");
        int month = scanner.nextInt();
        System.out.print("Enter the day of the month: 1-31: ");
        int day = scanner.nextInt();
        scanner.close();

        int q = day;
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

        String dayName = "";
        switch (h) {
            case 0:
                dayName = "Saturday";
                break;
            case 1:
                dayName = "Sunday";
                break;
            case 2:
                dayName = "Monday";
                break;
            case 3:
                dayName = "Tuesday";
                break;
            case 4:
                dayName = "Wednesday";
                break;
            case 5:
                dayName = "Thursday";
                break;
            default:
                dayName = "Friday";
                break;
        }

        System.out.println("Day of the week is " + dayName);

    }
}
