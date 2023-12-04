package com.xftxyz.chapter3;

import java.util.Scanner;

public class T32 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three points for p0, p1, and p2: ");
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        scanner.close();

        double result = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);

        if (result > 0) {
            System.out.println("p2 is on the left side of the line");
        } else if (result == 0) {
            System.out.println("p2 is on the same line");
        } else {
            System.out.println("p2 is on the right side of the line");
        }
    }
}
