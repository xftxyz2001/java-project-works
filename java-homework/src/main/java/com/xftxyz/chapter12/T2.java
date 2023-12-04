package com.xftxyz.chapter12;

import java.util.Scanner;

public class T2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two integers: ");
        int num1;
        int num2;
        while (true) {
            try {
                num1 = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input, enter again: ");
                scanner.nextLine();
                continue;
            }
            break;
        }
        while (true) {
            try {
                num2 = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Wrong input, enter again: ");
                scanner.nextLine();
                continue;
            }
            break;
        }
        scanner.close();

        System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
    }
}
