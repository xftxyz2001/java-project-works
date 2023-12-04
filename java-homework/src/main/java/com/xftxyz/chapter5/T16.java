package com.xftxyz.chapter5;

import java.util.Scanner;

public class T16 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 输入一个整数
        System.out.print("Enter an integer: ");
        int number = scanner.nextInt();
        scanner.close();

        // 输出所有的最小因子
        for (int i = 2; i <= number; i++) {
            while (number % i == 0) {
                System.out.print(i + " ");
                number /= i;
            }
        }

    }
}
