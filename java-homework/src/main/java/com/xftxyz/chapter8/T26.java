package com.xftxyz.chapter8;

import java.util.Arrays;
import java.util.Scanner;

public class T26 {

    // 行排序
    public static double[][] sortRows(double[][] m) {
        double[][] result = new double[m.length][m[0].length];
        for (int i = 0; i < m.length; i++) {
            System.arraycopy(m[i], 0, result[i], 0, m[i].length);
            Arrays.sort(result[i]);
        }
        return result;
    }

    // 打印矩阵
    public static void printMatrix(double[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 3-by-3 matrix row by row: ");
        double[][] m = new double[3][3];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();

        double[][] result = sortRows(m);
        System.out.println("The row-sorted array is");
        printMatrix(result);

    }
}
