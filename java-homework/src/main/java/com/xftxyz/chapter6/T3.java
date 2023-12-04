package com.xftxyz.chapter6;

import java.util.Scanner;

public class T3 {

    // Return the inversal of an integer, e.g., reverse(456) returns 654
    public static int reverse(int number) {
        int result = 0;
        while (number > 0) {
            result = result * 10 + number % 10; // 取出最后一位
            number /= 10; // 去掉最后一位
        }
        return result;
    }

    // Return true if number is a palindrome
    public static boolean isPalindrome(int number) {
        return number == reverse(number);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num = scanner.nextInt();
        scanner.close();

        System.out.println("The number " + num + " is " + (isPalindrome(num) ? "" : "not ") + "a palindrome");
    }
}
