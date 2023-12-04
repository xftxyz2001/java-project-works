package com.xftxyz.chapter7;

import java.util.Scanner;

public class T18 {

    // 冒泡排序
    public static void bubbleSort(double[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            boolean isSorted = true;
            // 每次循环都会把最大的数放到最后
            for (int j = 0; j < array.length - 1 - i; j++) {
                // 如果前面的数比后面的数大，则交换
                if (array[j] > array[j + 1]) {
                    double temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    isSorted = false;
                }
            }
            // 如果没有发生交换，则说明已经排好序了，直接退出循环
            if (isSorted) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ten numbers: ");
        double[] nums = new double[10];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = scanner.nextDouble();
        }
        scanner.close();

        bubbleSort(nums);

        System.out.print("The sorted numbers are: ");
        for (double n : nums) {
            System.out.printf("%f ", n);
        }
    }
}
