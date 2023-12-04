package com.xftxyz.chapter8;

import java.util.Scanner;

public class T11 {

    public static int[][] getStatus(int n) {
        int status[][] = new int[3][3];
        for (int i = status.length - 1; i >= 0; i--) {
            for (int j = status[0].length - 1; j >= 0; j--) {
                status[i][j] = n & 1;
                n >>= 1;
            }
        }
        return status;
    }

    public static void printStatus(int[][] status) {
        for (int i = 0; i < status.length; i++) {
            for (int j = 0; j < status[0].length; j++) {
                System.out.print(status[i][j] == 0 ? "H " : "T ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number between 0 and 511: ");
        int n = scanner.nextInt();
        scanner.close();

        int[][] status = getStatus(n);
        printStatus(status);

    }
}
