package com.xftxyz.chapter2;

import java.util.Scanner;

public class T23 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the driving distance: ");
        double distance = scanner.nextDouble();
        System.out.print("Enter miles per gallon: ");
        double milesPerGallon = scanner.nextDouble();
        System.out.print("Enter price per gallon: ");
        double pricePerGallon = scanner.nextDouble();
        scanner.close();

        double cost = distance / milesPerGallon * pricePerGallon;
        System.out.println("The cost of driving is $" + cost);
    }
}
