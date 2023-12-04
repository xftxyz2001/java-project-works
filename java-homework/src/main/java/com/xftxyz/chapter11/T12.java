package com.xftxyz.chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class T12 {

    // 对 ArrayList 求和
    public static double sum(ArrayList<Double> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }

        double sum = 0;
        for (Double aDouble : list) {
            sum += aDouble;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter five numbers: ");
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(scanner.nextDouble());
        }
        scanner.close();

        System.out.println("The sum is " + sum(list));
    }
}
