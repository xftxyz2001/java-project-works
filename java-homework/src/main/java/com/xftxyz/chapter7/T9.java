package com.xftxyz.chapter7;

import java.util.Scanner;

public class T9 {

    // 找出最小元素
    public static double min(double[] array) {
        double min = array[0];
        for (double n : array) {
            if (n < min) {
                min = n;
            }
        }
        return min;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        double[] nums = new double[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextDouble();
        }
        scanner.close();

        System.out.printf("The minimum number is: %f\n", min(nums));
    }
}
