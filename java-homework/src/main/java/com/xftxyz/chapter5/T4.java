package com.xftxyz.chapter5;

public class T4 {

    public static void main(String[] args) {

        System.out.println("英里\t千米");
        for (int i = 1; i <= 10; i++) {
            System.out.printf("%d\t%.3f\n", i, i * 1.609);
        }

    }
}
