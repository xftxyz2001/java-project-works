package com.xftxyz.chapter8;

import java.util.Scanner;

public class T25 {

    // 马尔可夫矩阵
    public static boolean isMarkovMatrix(double[][] m) {
        for (int i = 0; i < m[1].length; i++) {
            double sumColumn = 0;
            for (int j = 0; j < m.length; j++) {
                if (m[i][j] < 0) {
                    return false;
                }
                sumColumn += m[j][i];
            }
            // if (sumRow != 1) {
            if (Math.abs(sumColumn - 1) > 1e-7) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 3-by-3 matrix row by row:");
        double[][] m = new double[3][3];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < 3; j++) {
                m[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();

        System.out.println("It is " + (isMarkovMatrix(m) ? "" : "not ") + "a Markov matrix");

    }
}
