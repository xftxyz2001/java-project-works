package com.xftxyz.chapter7;

import java.util.Scanner;

public class T34 {

    // 对字符串中的字符进行排序
    public static String sort(String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char min = chars[i];
            int minIndex = i;
            for (int j = i + 1; j < chars.length; j++) {
                if (chars[j] < min) {
                    min = chars[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                chars[minIndex] = chars[i];
                chars[i] = min;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String s = scanner.next();
        scanner.close();

        System.out.printf("The sorted string is %s\n", sort(s));
    }
}
