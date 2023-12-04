package com.xftxyz.chapter5;

import java.util.Scanner;

public class T29 {

    public static void main(String[] args) {

        // 显示日历
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the year: ");
        int year = scanner.nextInt();
        System.out.print("Enter the first day of the year: ");
        int firstDay = scanner.nextInt();
        scanner.close();

        // 显示日历
        for (int month = 1; month <= 12; month++) {
            // 显示月份
            System.out.print("        ");
            switch (month) {
                case 1:
                    System.out.println("January " + year);
                    break;
                case 2:
                    System.out.println("February " + year);
                    break;
                case 3:
                    System.out.println("March " + year);
                    break;
                case 4:
                    System.out.println("April " + year);
                    break;
                case 5:
                    System.out.println("May " + year);
                    break;
                case 6:
                    System.out.println("June " + year);
                    break;
                case 7:
                    System.out.println("July " + year);
                    break;
                case 8:
                    System.out.println("August " + year);
                    break;
                case 9:
                    System.out.println("September " + year);
                    break;
                case 10:
                    System.out.println("October " + year);
                    break;
                case 11:
                    System.out.println("November " + year);
                    break;
                case 12:
                    System.out.println("December " + year);
                    break;
            }

            // 显示日历头
            System.out.println("-----------------------------");
            System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

            // 显示日历主体
            int days = 0;
            switch (month) {
                case 1:
                    days = 31;
                    break;
                case 2:
                    days = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 29 : 28;
                    break;
                case 3:
                    days = 31;
                    break;
                case 4:
                    days = 30;
                    break;
                case 5:
                    days = 31;
                    break;
                case 6:
                    days = 30;
                    break;
                case 7:
                    days = 31;
                    break;
                case 8:
                    days = 31;
                    break;
                case 9:
                    days = 30;
                    break;
                case 10:
                    days = 31;
                    break;
                case 11:
                    days = 30;
                    break;
                case 12:
                    days = 31;
                    break;
            }
            int day = 1;
            for (int i = 0; i < firstDay; i++) {
                System.out.print("    ");
            }
            for (int i = firstDay; i < 7; i++) {
                System.out.printf("%4d", day);
                day++;
            }
            System.out.println();
            while (day <= days) {
                for (int i = 0; i < 7; i++) {
                    System.out.printf("%4d", day);
                    day++;
                    if (day > days) {
                        break;
                    }
                }
                System.out.println();
            }

            // 换行
            System.out.println();
            firstDay = (firstDay + days) % 7;
        }

    }
}
