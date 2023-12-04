package com.xftxyz.chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class T4 {

    // ArrayList 的最大元素
    public static Integer max(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return null;
        }

        Integer max = list.get(0);
        for (Integer integer : list) {
            if (integer > max) {
                max = integer;
            }
        }

        return max;
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter integers (input ends with 0): ");
        int number;
        while ((number = scanner.nextInt()) != 0) {
            list.add(number);
        }
        scanner.close();

        System.out.println("The maximum number is " + max(list));
    }
}
