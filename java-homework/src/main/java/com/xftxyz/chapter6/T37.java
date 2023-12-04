package com.xftxyz.chapter6;

import java.util.Scanner;

public class T37 {

    // 格式化整数
    public static String format(int number, int width) {
        // return "0".repeat(Math.max(0, width - (number + "").length())) + number;
        String str = number + "";
        if (str.length() < width) {
            // for (int i = 0; i < width - str.length(); i++) {
            // str = "0" + str;
            // }
            // !!! str.length() is not a constant
            int count = width - str.length();
            for (int i = 0; i < count; i++) {
                str = "0" + str;
            }
        }
        return str;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scanner.nextInt();
        System.out.print("Enter the width: ");
        int width = scanner.nextInt();
        scanner.close();

        System.out.println("The formatted number is " + format(number, width));
    }
}
