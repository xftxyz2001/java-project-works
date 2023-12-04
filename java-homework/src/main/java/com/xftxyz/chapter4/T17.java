package com.xftxyz.chapter4;

import java.util.Scanner;

public class T17 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a year: ");
        int year = scanner.nextInt();
        System.out.print("Enter a month: ");
        String month = scanner.next();
        scanner.close();

        int days = 0;
        switch (month) {
            case "Jan":
            case "Mar":
            case "May":
            case "Jul":
            case "Aug":
            case "Oct":
            case "Dec":
                days = 31;
                break;
            case "Apr":
            case "Jun":
            case "Sep":
            case "Nov":
                days = 30;
                break;
            case "Feb":
                days = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 29 : 28;
                break;
            default:
                System.out.println(month + " is not a correct month name");
                System.exit(1);
        }

        System.out.println(month + " " + year + " has " + days + " days");

    }
}
