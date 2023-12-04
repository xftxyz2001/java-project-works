package com.xftxyz.chapter12;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        // 随机生成100个整数
        int[] nums = new int[100];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = (int) (Math.random() * 100);
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index of the array: ");
        int index = scanner.nextInt();
        scanner.close();

        try {
            System.out.println(nums[index]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Out of Bounds");
        }

    }
}
