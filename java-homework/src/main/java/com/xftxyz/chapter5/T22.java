package com.xftxyz.chapter5;

import java.util.Scanner;

public class T22 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Loan Amount: ");
        double loanAmount = scanner.nextDouble();
        System.out.print("Number of Years: ");
        int numberOfYears = scanner.nextInt();
        System.out.print("Annual Interest Rate: ");
        double annualInterestRate = scanner.nextDouble();
        scanner.close();

        double monthlyInterestRate = annualInterestRate / 1200;
        double monthlyPayment = loanAmount * monthlyInterestRate
                / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12));
        double totalPayment = monthlyPayment * numberOfYears * 12;

        System.out.println();
        System.out.printf("Monthly Payment: %.2f\n", monthlyPayment);
        System.out.printf("Total Payment: %.2f\n", totalPayment);
        System.out.println();

        double balance = loanAmount;

        // 表头
        System.out.println("Payment#     Interest     Principal     Balance");

        for (int i = 1; i <= numberOfYears * 12; i++) {
            double interest = balance * monthlyInterestRate;
            double principal = monthlyPayment - interest;
            balance = balance - principal;
            System.out.printf("%-13d%-13.2f%-14.2f%.2f\n", i, interest, principal, balance);
        }
    }
}
