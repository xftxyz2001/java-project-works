package com.xftxyz.chapter6;

public class T26 {

    // 判断回文数
    public static boolean isPalindrome(int value) {
        return value == reverse(value);
    }

    private static int reverse(int value) {
        int result = 0;
        while (value > 0) {
            result = result * 10 + value % 10;
            value /= 10;
        }
        return result;
    }

    // 判断素数
    public static boolean isPrime(int value) {
        if (value == 2) {
            return true;
        }
        if (value % 2 == 0) {
            return false;
        }
        for (int i = 3; i * i <= value; i += 2) {
            if (value % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        final int NUMBERS_PER_LINE = 10;
        int count = 0;
        int i = 2;
        while (count < 100) {
            if (isPrime(i) && isPalindrome(i)) {
                System.out.printf("%10d", i);
                count++;
                if (count % NUMBERS_PER_LINE == 0) {
                    System.out.println();
                }
            }
            i++;
        }
    }
}
