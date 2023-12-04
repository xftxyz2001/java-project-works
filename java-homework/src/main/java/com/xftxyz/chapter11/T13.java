package com.xftxyz.chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class T13 {

    // 从 ArrayList 中删除重复元素
    public static void removeDuplicate(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }

        ArrayList<Integer> temp = new ArrayList<>();
        for (Integer integer : list) {
            if (!temp.contains(integer)) {
                temp.add(integer);
            }
        }

        list.clear();
        list.addAll(temp);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter ten integers: ");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(scanner.nextInt());
        }
        scanner.close();

        removeDuplicate(list);
        System.out.println("The distinct integers are " + list);
    }
}
