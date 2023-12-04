package com.xftxyz.chapter7;

import java.util.Scanner;

public class T5 {

    public static void main(String[] args) {

        int[] nums = new int[10];
        int size = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter 10 numbers: ");
        for (int i = 0; i < nums.length; i++) {
            int n = scanner.nextInt();

            // 检查是否重复
            boolean isRepeat = false;
            for (int j = 0; j < size; j++) {
                if (n == nums[j]) {
                    isRepeat = true;
                    break;
                }
            }

            if (!isRepeat) {
                nums[size++] = n;
            }
        }
        scanner.close();

        System.out.printf("The number of distinct number is %d\n", size);
        System.out.print("The distinct numbers are: ");
        for (int i = 0; i < size; i++) {
            System.out.printf("%d ", nums[i]);
        }
    }
}
