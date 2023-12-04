package com.xftxyz.chapter5;

import java.util.Scanner;

public class T48 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String string = scanner.nextLine();
        scanner.close();

        // 显示奇数位置的字符
        for (int i = 0; i < string.length(); i += 2) {
            System.out.print(string.charAt(i));
        }
    }
}
