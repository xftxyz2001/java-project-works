package com.xftxyz.chapter2;

import java.util.Scanner;

public class T7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of minutes: ");
        int minutes = scanner.nextInt();
        scanner.close();

        int days = minutes / 60 / 24;
        int years = days / 365;
        int remainingDays = days % 365;

        System.out.println(minutes + " minutes is approximately " + years + " years and " + remainingDays + " days");
    }
}
