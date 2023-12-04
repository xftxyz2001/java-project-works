package com.xftxyz.chapter7;

import java.util.Scanner;

public class T26 {

    // 完全相同的数组
    public static boolean equals(int[] list1, int[] list2) {
        if (list1.length != list2.length) {
            return false;
        }

        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter list1 size and contents: ");
        int size1 = scanner.nextInt();
        int[] list1 = new int[size1];
        for (int i = 0; i < size1; i++) {
            list1[i] = scanner.nextInt();
        }

        System.out.print("Enter list2 size and contents: ");
        int size2 = scanner.nextInt();
        int[] list2 = new int[size2];
        for (int i = 0; i < size2; i++) {
            list2[i] = scanner.nextInt();
        }
        scanner.close();

        boolean equals = equals(list1, list2);
        System.out.printf("Two lists are %s\n", equals ? "strictly" : "not strictly");
    }
}
