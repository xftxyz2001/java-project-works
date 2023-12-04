package com.xftxyz.chapter5;

public class T19 {

    public static void main(String[] args) {

        for (int i = 1; i <= 8; i++) {
            // 打印空格
            for (int j = 1; j <= 8 - i; j++) {
                System.out.print("    ");
            }
            // 打印左半部分
            for (int j = 1; j <= i; j++) {
                System.out.printf("%4d", (int) Math.pow(2, j - 1));
            }
            // 打印右半部分
            for (int j = i - 1; j >= 1; j--) {
                System.out.printf("%4d", (int) Math.pow(2, j - 1));
            }
            // 换行
            System.out.println();
        }
    }
}
