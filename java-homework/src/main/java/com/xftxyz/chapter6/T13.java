package com.xftxyz.chapter6;

public class T13 {

    // Return the sum of m(i) = 1/2 + 2/3 + ... + i/(i+1)
    public static double sumSeries(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += (double) i / (i + 1);
        }
        return sum;
    }

    public static void main(String[] args) {

        System.out.println("i\tm(i)");
        System.out.println("-------------");
        for (int i = 1; i <= 20; i++) {
            System.out.printf("%d\t%.4f\n", i, sumSeries(i));
        }
    }
}
