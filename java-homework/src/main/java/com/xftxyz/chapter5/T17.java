package com.xftxyz.chapter5;

import java.util.Scanner;

public class T17 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 输入一个1-15之间的整数
        System.out.print("Enter an integer between 1 and 15: ");
        int number = scanner.nextInt();
        scanner.close();

        // 显示一个金字塔
        for (int i = 1; i <= number; i++) {
            // 打印空格
            for (int j = 1; j <= number - i; j++) {
                System.out.print("  ");
            }
            // 打印左半部分
            for (int j = i; j >= 1; j--) {
                System.out.print(j + " ");
            }
            // 打印右半部分
            for (int j = 2; j <= i; j++) {
                System.out.print(j + " ");
            }
            // 换行
            System.out.println();
        }

    }
}
