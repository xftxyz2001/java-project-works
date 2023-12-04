package com.xftxyz.chapter5;

public class T7 {

    public static void main(String[] args) {

        // 计算将来的学费
        double tuition = 10000;
        for (int i = 1; i <= 10; i++) {
            tuition *= 1.05;
        }
        System.out.printf("The tuition fee in ten years is: %.2f\n", tuition);

        // 计算四年的学费
        double total = 0;
        for (int i = 1; i <= 4; i++) {
            total += tuition;
            tuition *= 1.05;
        }
        System.out.printf("The tuition fee for four years after 10 years is %.2f\n", total);
    }
}
