package com.xftxyz.chapter7;

import java.util.Scanner;

public class T10 {

    // 找出最小元素的下标
    public static int indexOfSmallestElement(double[] array) {
        int index = 0;
        for (int i = 1; i < array.length; i++) {
            if (array[index] > array[i]) {
                index = i;
                array[index] = array[i];
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        double[] nums = new double[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextDouble();
        }
        scanner.close();

        System.out.printf("The index of the minimum number is: %d\n", indexOfSmallestElement(nums));
    }
}
