package com.xftxyz.chapter6;

public class T24 {

    // 显示当前的日期和时间
    public static void printDateTime() {
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        long currentSecond = totalSeconds % 60;
        long totalMinutes = totalSeconds / 60;
        long currentMinute = totalMinutes % 60;
        long totalHours = totalMinutes / 60;
        long currentHour = totalHours % 24;

        System.out.printf("Current time is %d:%d:%d GMT\n", currentHour, currentMinute, currentSecond);

        long totalDays = totalHours / 24;
        int currentYear = 1970;
        while (totalDays >= 365) {
            if (isLeapYear(currentYear)) {
                totalDays -= 366;
            } else {
                totalDays -= 365;
            }
            currentYear++;
        }

        int currentMonth = 1;
        while (totalDays >= 28) {
            if (currentMonth == 2) {
                if (isLeapYear(currentYear)) {
                    totalDays -= 29;
                } else {
                    totalDays -= 28;
                }
            } else if (currentMonth == 4 || currentMonth == 6 || currentMonth == 9 || currentMonth == 11) {
                totalDays -= 30;
            } else {
                totalDays -= 31;
            }
            currentMonth++;
        }

        System.out.printf("Current date is %d-%d-%d\n", currentYear, currentMonth, totalDays + 1);
    }

    private static boolean isLeapYear(int year) {
        return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0);
    }

    public static void main(String[] args) {
        printDateTime();
    }
}
