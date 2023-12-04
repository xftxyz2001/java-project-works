package com.xftxyz.chapter8;

import java.util.Scanner;

public class T29 {

    // 相同的数组
    public static boolean equals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length) {
            return false;
        }

        for (int i = 0; i < m1.length; i++) {
            if (m1[i].length != m2[i].length) {
                return false;
            }
            for (int j = 0; j < m1[i].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list1: ");
        int[][] m1 = new int[3][3];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < 3; j++) {
                m1[i][j] = scanner.nextInt();
            }
        }
        System.out.print("Enter list2: ");
        int[][] m2 = new int[3][3];
        for (int i = 0; i < m2.length; i++) {
            for (int j = 0; j < 3; j++) {
                m2[i][j] = scanner.nextInt();
            }
        }
        scanner.close();

        System.out.println("The two arrays are " + (equals(m1, m2) ? "" : "not ") + "identical");
    }
}
