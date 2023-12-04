package com.xftxyz.chapter8;

import java.util.Arrays;

public class T4 {

    public static int sumRow(int[][] m, int rowIndex) {
        int sum = 0;
        for (int i = 0; i < m[rowIndex].length; i++) {
            sum += m[rowIndex][i];
        }
        return sum;
    }

    public static void main(String[] args) {
        /**
         * 2 4 3 4 5 8 8
         * 7 3 4 3 3 4 4
         * 3 3 4 3 3 2 2
         * 9 3 4 7 3 4 1
         * 3 5 4 3 6 3 8
         * 3 4 4 6 3 4 4
         * 3 7 4 8 3 8 4
         * 6 3 5 9 2 7 9
         */
        int[][] m = new int[][] {
                { 2, 4, 3, 4, 5, 8, 8 },
                { 7, 3, 4, 3, 3, 4, 4 },
                { 3, 3, 4, 3, 3, 2, 2 },
                { 9, 3, 4, 7, 3, 4, 1 },
                { 3, 5, 4, 3, 6, 3, 8 },
                { 3, 4, 4, 6, 3, 4, 4 },
                { 3, 7, 4, 8, 3, 8, 4 },
                { 6, 3, 5, 9, 2, 7, 9 }
        };

        int[][] sum = new int[m.length][2];
        for (int i = 0; i < m.length; i++) {
            sum[i][0] = i;
            sum[i][1] = sumRow(m, i);
        }

        Arrays.sort(sum, (o1, o2) -> o2[1] - o1[1]);

        for (int i = 0; i < sum.length; i++) {
            System.out.println("Employee " + sum[i][0] + "'s total hours is " + sum[i][1]);
        }

    }
}
