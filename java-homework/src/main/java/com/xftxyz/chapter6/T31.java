package com.xftxyz.chapter6;

import java.util.Scanner;

public class T31 {

    // Return true if the card number is valid
    public static boolean isValid(long number) {
        return (getSize(number) >= 13 && getSize(number) <= 16)
                && (prefixMatched(number, 4) || prefixMatched(number, 5) || prefixMatched(number, 37)
                        || prefixMatched(number, 6))
                && ((sumOfDoubleEvenPlace(number) + sumOfOddPlace(number)) % 10 == 0);
    }

    // Get the result from Step 2
    public static int sumOfDoubleEvenPlace(long number) {
        int sum = 0;
        while (number > 0) {
            number /= 10;
            sum += getDigit((int) (number % 10) * 2);
            number /= 10;
        }
        return sum;
    }

    // Return this number if it is a single digit, otherwise, return the sum of the
    // two digits
    public static int getDigit(int number) {
        return number < 10 ? number : number / 10 + number % 10;
    }

    // Return sum of odd-place digits in number
    public static int sumOfOddPlace(long number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 100;
        }
        return sum;
    }

    // Return true if the digit d is a prefix for number
    public static boolean prefixMatched(long number, int d) {
        return getPrefix(number, getSize(d)) == d;
    }

    // Return the number of digits in d
    public static int getSize(long d) {
        int count = 0;
        while (d > 0) {
            count++;
            d /= 10;
        }
        return count;
    }

    // Return the first k number of digits from number. If the number of digits in
    // number is less than k, return number
    public static long getPrefix(long number, int k) {
        long result = number;
        for (int i = 0; i < getSize(number) - k; i++) {
            result /= 10;
        }
        return result;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a credit card number as a long integer: ");
        long number = scanner.nextLong();
        scanner.close();

        System.out.println(number + " is " + (isValid(number) ? "valid" : "invalid"));
    }
}
