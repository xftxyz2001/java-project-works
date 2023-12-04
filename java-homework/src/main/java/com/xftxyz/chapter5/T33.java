package com.xftxyz.chapter5;

public class T33 {

    public static void main(String[] args) {

        // 完全数
        for (int i = 1; i <= 10000; i++) {
            int sum = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    sum += j;
                }
            }
            if (sum == i) {
                System.out.println(i);
            }
        }
        // 6
        // 28
        // 496
        // 8128
    }
}
