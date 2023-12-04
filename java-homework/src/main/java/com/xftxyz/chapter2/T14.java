package com.xftxyz.chapter2;

import java.util.Scanner;

public class T14 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter weight in pounds: ");
        double weight = scanner.nextDouble();
        System.out.print("Enter height in inches: ");
        double height = scanner.nextDouble();
        scanner.close();

        double weightInKilograms = weight * 0.45359237;
        double heightInMeters = height * 0.0254;

        double bmi = weightInKilograms / (heightInMeters * heightInMeters);

        System.out.println("BMI is " + bmi);
    }
}
