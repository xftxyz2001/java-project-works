package com.xftxyz.chapter8;

import java.util.Scanner;

public class T10 {

    public static int maxRow(int[][] m) {
        int maxIndex = 0;
        int maxSum = 0;
        for (int i = 0; i < m.length; i++) {
            int sum = 0;
            for (int j = 0; j < m[i].length; j++)
                sum += m[i][j];
            if (sum > maxSum) {
                maxSum = sum;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static int maxColumn(int[][] m) {
        int maxIndex = 0;
        int maxSum = 0;
        for (int i = 0; i < m[0].length; i++) {
            int sum = 0;
            for (int j = 0; j < m.length; j++) {
                sum += m[j][i];
            }
            if (sum > maxSum) {
                maxSum = sum;
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] m = new int[4][4];
        for (int i = 0; i < m.length; i++) {
            String line = scanner.nextLine();
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = line.charAt(j) - '0';
            }
        }
        scanner.close();

        System.out.println("The largest row index: " + maxRow(m));
        System.out.println("The largest column index: " + maxColumn(m));

    }
}
