package com.xftxyz.chapter10;

import java.util.Scanner;
import java.util.Stack;

public class T5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int number = scanner.nextInt();
        scanner.close();

        StackOfIntegers stack = new StackOfIntegers();
        int factor = 2;
        while (factor <= number) {
            if (number % factor == 0) {
                stack.push(factor);
                number /= factor;
            } else {
                factor++;
            }
        }
        while (!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }

    }
}

class StackOfIntegers extends Stack<Integer> {

}