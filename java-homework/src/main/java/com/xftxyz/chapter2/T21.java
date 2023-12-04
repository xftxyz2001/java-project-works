package com.xftxyz.chapter2;

import java.util.Scanner;

public class T21 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter investment amount: ");
        double investmentAmount = scanner.nextDouble();
        System.out.print("Enter annual interest rate in percentage: ");
        double annualInterestRate = scanner.nextDouble();
        System.out.print("Enter number of years: ");
        int years = scanner.nextInt();
        scanner.close();

        double monthlyInterestRate = annualInterestRate / 1200;
        double futureInvestmentValue = investmentAmount * Math.pow(1 + monthlyInterestRate, years * 12);

        System.out.println("Accumulated value is $" + futureInvestmentValue);
    }
}
