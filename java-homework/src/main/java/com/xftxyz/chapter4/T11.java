package com.xftxyz.chapter4;

import java.util.Scanner;

public class T11 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a decimal value (0 to 15): ");
        int decimal = scanner.nextInt();
        scanner.close();

        if (decimal < 0 || decimal > 15) {
            System.out.println(decimal + " is an invalid input");
            System.exit(1);
        }

        char hex = (decimal <= 9) ? (char) (decimal + '0') : (char) (decimal - 10 + 'A');
        System.out.println("The hex value is " + hex);
    }
}
