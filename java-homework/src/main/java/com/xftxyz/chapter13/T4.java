package com.xftxyz.chapter13;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class T4 {

    public static void main(String[] args) {
        if (args.length > 2) {
            System.out.println("Usage: java T4 month year");
            System.exit(1);
        }

        PrintCalendar calendar = null;
        if (args.length == 0) {
            calendar = new PrintCalendar();
        } else if (args.length == 1) {
            calendar = new PrintCalendar(Integer.parseInt(args[0]), 1);
        } else {
            calendar = new PrintCalendar(Integer.parseInt(args[0]), Integer.parseInt(args[1]));
        }

        calendar.printMonth();

    }
}

class PrintCalendar {
    private Calendar calendar;

    public PrintCalendar() {
        calendar = new GregorianCalendar();
    }

    public PrintCalendar(int year, int month) {
        calendar = new GregorianCalendar(year, month - 1, 1);
    }

    public void printMonth() {

        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int numberOfDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        System.out.println(" Sun Mon Tue Wed Thu Fri Sat");

        for (int i = 1; i < startDay; i++) {
            System.out.print("    ");
        }

        for (int day = 1; day <= numberOfDays; day++) {
            System.out.printf(" %3d", day);

            if ((day + startDay - 1) % 7 == 0) {
                System.out.println();
            }
        }

        System.out.println();
    }
}