package com.xftxyz.chapter8;

import java.util.Scanner;

public class T35 {

    // 最大块
    public static int[] findLargestBlock(int[][] m) {
        int n = m.length;
        int[][] dp = new int[n][n];
        int maxSize = 0;
        int maxIndex = -1;
        int[] result = new int[3];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = m[i][j];
                } else if (m[i][j] == 1) {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                if (dp[i][j] > maxSize) {
                    maxSize = dp[i][j];
                    maxIndex = i;
                    result[0] = i - maxSize + 1;
                    result[1] = j - maxSize + 1;
                    result[2] = maxSize;
                }
            }
        }

        if (maxIndex == -1) {
            return null;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows in the matrix: ");
        int row = scanner.nextInt();
        System.out.print("Enter the matrix row by row: ");
        int[][] m = new int[row][row];
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int[] result = findLargestBlock(m);
        System.out.println(
                "The maximum square submatrix is at (" + result[0] + ", " + result[1] + ") with size " + result[2]);
    }
}
