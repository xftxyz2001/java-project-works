package com.xftxyz.chapter8;

import java.util.Scanner;

public class T6 {

    // 两个矩阵相乘
    public static double[][] multiplyMatrix(double[][] a, double[][] b) {
        double[][] c = new double[a.length][b[0].length];
        for (int i = 0; i < c.length; i++)
            for (int j = 0; j < c[0].length; j++)
                for (int k = 0; k < a[0].length; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[][] a = getArr(scanner, "matrix1");
        double[][] b = getArr(scanner, "matrix2");
        scanner.close();

        double[][] c = multiplyMatrix(a, b);
        System.out.println("The multiplication of the matrices is ");
        printResult(a, b, c);
    }

    private static void printResult(double[][] a, double[][] b, double[][] c) {
        for (int i = 0; i < c.length; i++) {
            System.out.printf("%.1f %.1f %.1f", a[i][0], a[i][1], a[i][2]);
            if (i == 1) {
                System.out.print(" * ");
            } else {
                System.out.print("   ");
            }
            System.out.printf("%.1f %.1f %.1f", b[i][0], b[i][1], b[i][2]);
            if (i == 1) {
                System.out.print(" = ");
            } else {
                System.out.print("   ");
            }
            System.out.printf("%.1f %.1f %.1f\n", c[i][0], c[i][1], c[i][2]);
        }
    }

    private static double[][] getArr(Scanner scanner, String s) {
        System.out.printf("Enter %s: ", s);
        double[][] arr = new double[3][3];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                arr[i][j] = scanner.nextDouble();
            }
        }
        return arr;
    }
}
