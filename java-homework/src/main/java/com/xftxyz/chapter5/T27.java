package com.xftxyz.chapter5;

public class T27 {

    public static void main(String[] args) {

        // 显示闰年
        final int NUM_PER_LINE = 10;
        final int FROM_YEAR = 101;
        final int TO_YEAR = 2100;

        int count = 0;
        for (int year = FROM_YEAR; year <= TO_YEAR; year++) {
            if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
                count++;
                System.out.printf("%5d", year);
                if (count % NUM_PER_LINE == 0) {
                    System.out.println();
                }
            }
        }

    }
}
