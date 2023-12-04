package com.xftxyz.chapter5;

import java.util.Scanner;

public class T1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an integer, the input ends if it is 0: ");

        int positive = 0;
        int negative = 0;
        double total = 0;
        int count = 0;

        while (true) {
            int number = scanner.nextInt();
            if (number == 0) {
                break;
            }
            if (number > 0) {
                positive++;
            } else {
                negative++;
            }
            total += number;
            count++;
        }
        scanner.close();

        if (count == 0) {
            System.out.println("No numbers are entered except 0");
        } else {
            System.out.println("The number of positives is " + positive);
            System.out.println("The number of negatives is " + negative);
            System.out.println("The total is " + total);
            System.out.println("The average is " + total / count);
        }

    }
}
