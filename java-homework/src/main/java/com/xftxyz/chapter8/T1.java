package com.xftxyz.chapter8;

import java.util.Scanner;

public class T1 {
    // 求矩阵中各列数字的和
    public static double sumColumn(double[][] m, int columnIndex) {
        double sum = 0;
        for (int i = 0; i < m.length; i++) {
            sum += m[i][columnIndex];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a 3-by-4 matrix row by row: ");
        double[][] m = new double[3][4];
        for (int i = 0; i < m.length; i++) {
            // String[] line = scanner.nextLine().split(" ");
            // for (int j = 0; j < m[i].length; j++) {
            // m[i][j] = Double.parseDouble(line[j]);
            // }
            for (int j = 0; j < m[i].length; j++) {
                m[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();

        for (int i = 0; i < m[0].length; i++) {
            System.out.println("Sum of the elements at column " + i + " is " + sumColumn(m, i));
        }

    }
}
