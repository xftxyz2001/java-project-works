package com.xftxyz.chapter3;

import java.util.Scanner;

public class T7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an amount in double, for example 11.56: ");
        double amount = scanner.nextDouble();
        scanner.close();

        int remainingAmount = (int) (amount * 100);

        int numberOfOneDollars = remainingAmount / 100;
        remainingAmount = remainingAmount % 100;

        int numberOfQuarters = remainingAmount / 25;
        remainingAmount = remainingAmount % 25;

        int numberOfDimes = remainingAmount / 10;
        remainingAmount = remainingAmount % 10;

        int numberOfNickels = remainingAmount / 5;
        remainingAmount = remainingAmount % 5;

        int numberOfPennies = remainingAmount;

        System.out.println("Your amount " + amount + " consists of");
        if (numberOfOneDollars > 1) {
            System.out.println("    " + numberOfOneDollars + " dollars");
        } else if (numberOfOneDollars == 1) {
            System.out.println("    " + numberOfOneDollars + " dollar");
        }

        if (numberOfQuarters > 1) {
            System.out.println("    " + numberOfQuarters + " quarters");
        } else if (numberOfQuarters == 1) {
            System.out.println("    " + numberOfQuarters + " quarter");
        }

        if (numberOfDimes > 1) {
            System.out.println("    " + numberOfDimes + " dimes");
        } else if (numberOfDimes == 1) {
            System.out.println("    " + numberOfDimes + " dime");
        }

        if (numberOfNickels > 1) {
            System.out.println("    " + numberOfNickels + " nickels");
        } else if (numberOfNickels == 1) {
            System.out.println("    " + numberOfNickels + " nickel");
        }

        if (numberOfPennies > 1) {
            System.out.println("    " + numberOfPennies + " pennies");
        } else if (numberOfPennies == 1) {
            System.out.println("    " + numberOfPennies + " penny");
        }
    }
}
