package com.xftxyz.chapter8;

import java.util.Scanner;

public class T13 {

    // 定位最大的元素
    public static int[] locateLargest(double[][] a) {
        int[] index = new int[2];
        double max = a[0][0];
        index[0] = 0;
        index[1] = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                if (a[i][j] > max) {
                    max = a[i][j];
                    index[0] = i;
                    index[1] = j;
                }
        }
        return index;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns of the array: ");
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        double[][] a = new double[row][column];
        System.out.println("Enter the array:");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++)
                a[i][j] = scanner.nextDouble();
        }
        scanner.close();

        int[] index = locateLargest(a);
        System.out.printf("The location of the largest element is at (%d, %d)\n", index[0], index[1]);
    }
}
