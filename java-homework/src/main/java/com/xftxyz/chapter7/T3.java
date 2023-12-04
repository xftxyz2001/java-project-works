package com.xftxyz.chapter7;

import java.util.Scanner;

public class T3 {

    public static void main(String[] args) {
        // 计算数字出现的次数
        int[] numsCount = new int[101];

        System.out.print("Enter the integers between 1 and 100: ");
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        while ((num = scanner.nextInt()) != 0) {
            numsCount[num]++;
        }
        scanner.close();

        for (int i = 1; i < numsCount.length; i++) {
            if (numsCount[i] != 0) {
                System.out.printf("%d occurs %d time%s\n", i, numsCount[i], numsCount[i] > 1 ? "s" : "");
            }
        }
    }
}
