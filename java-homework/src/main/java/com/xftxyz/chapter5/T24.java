package com.xftxyz.chapter5;

public class T24 {

    public static void main(String[] args) {

        // 数列求和
        double sum = 0;
        for (int i = 1; i <= 97; i += 2) {
            sum += (double) i / (i + 2);
        }
        System.out.println("The sum is " + sum);
    }
}
