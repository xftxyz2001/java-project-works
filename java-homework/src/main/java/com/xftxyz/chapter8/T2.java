package com.xftxyz.chapter8;

import java.util.Scanner;

public class T2 {

    // 求矩阵主对角线元素的和
    public static double sumMajorDiagonal(double[][] m) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 4-by-4 matrix row by row: ");
        double[][] m = new double[4][4];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();

        System.out.println("Sum of the elements in the major diagonal is " + sumMajorDiagonal(m));
    }
}
