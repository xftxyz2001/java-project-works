package com.xftxyz.chapter5;

import java.util.Scanner;

public class T30 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 输入金额、年利率、月份数
        System.out.print("Enter the amount invested: ");
        double amount = scanner.nextDouble();
        System.out.print("Enter annual interest rate: ");
        double annualInterestRate = scanner.nextDouble();
        System.out.print("Enter number of months: ");
        int months = scanner.nextInt();
        scanner.close();

        // 计算月利率
        double monthlyInterestRate = annualInterestRate / 1200;

        // 计算总金额
        double total = amount * Math.pow(1 + monthlyInterestRate, months);

        // 输出结果
        System.out.printf("Accumulated value is $%.2f\n", total);
    }
}
