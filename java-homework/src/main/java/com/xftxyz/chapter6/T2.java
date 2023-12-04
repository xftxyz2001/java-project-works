package com.xftxyz.chapter6;

import java.util.Scanner;

public class T2 {

    public static int sumDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10; // 取出最后一位
            num /= 10; // 去掉最后一位
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        System.out.println("The sum of the digits is " + sumDigits(num));
    }
}
