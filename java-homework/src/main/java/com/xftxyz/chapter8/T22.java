package com.xftxyz.chapter8;

import java.util.Arrays;

public class T22 {

    // 产生一个6*6的01矩阵
    public static int[][] getMatrix() {
        int[][] m = new int[6][6];
        for (int i = 0; i < m.length; i++) {
            int sum = 0;
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = (int) (Math.random() * 2);
                sum += m[i][j];
            }
            m[i][m[i].length - 1] = sum % 2;
        }
        return m;
    }

    // 检查矩阵每行每列是否有偶数个1
    public static boolean check(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            int sumRow = 0;
            int sumColumn = 0;
            for (int j = 0; j < m[i].length; j++) {
                sumRow += m[i][j];
                sumColumn += m[j][i];
            }
            if (sumRow % 2 != 0 || sumColumn % 2 != 0) {
                return false;
            }
        }
        return true;
    }

    // 打印矩阵
    public static void printMatrix(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }

    public static void main(String[] args) {
        int[][] m = getMatrix();
        printMatrix(m);
        System.out.println(check(m));
    }
}
