package com.xftxyz.chapter8;

import java.util.Scanner;

public class T23 {

    // 找到翻转的单元格
    public static int[][] getFlipCell(int[][] m) {
        int[][] flipCell = new int[2][2];
        for (int i = 0; i < m.length; i++) {
            int sumRow = 0;
            int sumColumn = 0;
            for (int j = 0; j < m[i].length; j++) {
                sumRow += m[i][j];
                sumColumn += m[j][i];
            }
            if (sumRow % 2 != 0) {
                flipCell[0][0] = i;
            }
            if (sumColumn % 2 != 0) {
                flipCell[0][1] = i;
            }
        }
        return flipCell;
    }

    public static void main(String[] args) {
        int[][] m = new int[6][6];
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a 6-by-6 matrix row by row:");
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        int[][] flipCell = getFlipCell(m);
        System.out.println("The flipped cell is at (" + flipCell[0][0] + ", " + flipCell[0][1] + ")");
    }
}
