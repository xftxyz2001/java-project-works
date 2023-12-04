package com.xftxyz.chapter6;

import java.util.Scanner;

public class T36 {

    // 计算正多边形的面积
    public static double area(int n, double side) {
        return n * side * side / (4 * Math.tan(Math.PI / n));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of sides: ");
        int n = scanner.nextInt();
        System.out.print("Enter the side: ");
        double side = scanner.nextDouble();
        scanner.close();

        System.out.println("The area of the polygon is " + area(n, side));
    }
}
