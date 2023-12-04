package com.xftxyz.chapter10.t14;

public class MyDate {

    private int year;
    private int month;
    private int day;

    public MyDate() {
        this(System.currentTimeMillis());
    }

    public MyDate(long elapsedTime) {
        setDate(elapsedTime);
    }

    public MyDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setDate(long elapsedTime) {
        long totalDays = elapsedTime / 1000 / 60 / 60 / 24;
        int year = 1970;
        while (totalDays > 365) {
            if (isLeapYear(year)) {
                totalDays -= 366;
            } else {
                totalDays -= 365;
            }
            year++;
        }
        this.year = year;
        int month = 1;
        while (totalDays > 28) {
            if (isLeapYear(year)) {
                if (totalDays > 29) {
                    totalDays -= 29;
                } else {
                    break;
                }
            } else {
                if (totalDays > 28) {
                    totalDays -= 28;
                } else {
                    break;
                }
            }
            month++;
        }
        this.month = month;
        this.day = (int) totalDays;
    }

    private boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    @Override
    public String toString() {
        return String.format("%d-%d-%d", year, month, day);
    }
}