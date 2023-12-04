package com.xftxyz.chapter3;

import java.util.Scanner;

public class T19 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter three edges: ");
        double edge1 = scanner.nextDouble();
        double edge2 = scanner.nextDouble();
        double edge3 = scanner.nextDouble();
        scanner.close();

        if (edge1 + edge2 > edge3 && edge1 + edge3 > edge2 && edge2 + edge3 > edge1) {
            System.out.println("The perimeter is " + (edge1 + edge2 + edge3));
        } else {
            System.out.println("Input is invalid");
        }

    }
}
