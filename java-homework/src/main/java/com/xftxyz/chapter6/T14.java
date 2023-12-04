package com.xftxyz.chapter6;

public class T14 {

    // Return the sum of m(i) = 4*(1-1/3+1/5-1/7+1/9-1/11+...+(-1)^(i+1)/(2i-1))
    public static double sumSeries(int n) {
        double sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += Math.pow(-1, i + 1) / (2 * i - 1);
        }
        return 4 * sum;
    }

    public static void main(String[] args) {

        System.out.println("i\tm(i)");
        System.out.println("-------------");
        for (int i = 1; i <= 901; i += 100) {
            System.out.printf("%d\t%.4f\n", i, sumSeries(i));
        }
    }
}
