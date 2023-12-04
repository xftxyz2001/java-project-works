package com.xftxyz.chapter2;

import java.util.Scanner;

public class T13 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the monthly saving amount: ");
        double savingAmount = scanner.nextDouble();
        scanner.close();

        double monthlyInterestRate = 0.05 / 12;
        double firstMonth = savingAmount * (1 + monthlyInterestRate);
        double secondMonth = (savingAmount + firstMonth) * (1 + monthlyInterestRate);
        double thirdMonth = (savingAmount + secondMonth) * (1 + monthlyInterestRate);
        double fourthMonth = (savingAmount + thirdMonth) * (1 + monthlyInterestRate);
        double fifthMonth = (savingAmount + fourthMonth) * (1 + monthlyInterestRate);
        double sixthMonth = (savingAmount + fifthMonth) * (1 + monthlyInterestRate);

        System.out.println("After the sixth month, the account value is $" + sixthMonth);
    }
}
