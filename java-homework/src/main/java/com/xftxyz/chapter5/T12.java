package com.xftxyz.chapter5;

public class T12 {

    public static void main(String[] args) {

        int n = 0;
        while (Math.pow(n, 2) <= 12000) {
            n++;
        }
        System.out.println("The smallest n such that n^2 > 12,000 is " + n);
    }
}
