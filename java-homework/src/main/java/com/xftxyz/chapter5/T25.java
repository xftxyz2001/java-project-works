package com.xftxyz.chapter5;

public class T25 {

    public static void main(String[] args) {

        // 近似计算
        double sum = 0;
        int sign = 1;
        for (int i = 1; i <= 100000; i += 2) {
            sum += sign * (double) 1 / i;
            sign *= -1;
            if (i % 10000 == 1) {
                System.out.println("The sum is " + sum * 4);
            }
        }

    }
}
