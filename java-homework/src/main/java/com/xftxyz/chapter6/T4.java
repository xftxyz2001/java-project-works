package com.xftxyz.chapter6;

import java.util.Scanner;

public class T4 {

    // 反序显示一个整数
    public static void reverse(int value) {
        while (value > 0) {
            System.out.print(value % 10);
            value /= 10;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int value = scanner.nextInt();
        scanner.close();

        reverse(value);

    }
}
