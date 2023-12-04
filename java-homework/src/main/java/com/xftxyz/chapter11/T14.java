package com.xftxyz.chapter11;

import java.util.ArrayList;
import java.util.Scanner;

public class T14 {

    // 合并两个列表
    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        if (list1 == null || list1.size() == 0) {
            return list2;
        }

        if (list2 == null || list2.size() == 0) {
            return list1;
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.addAll(list1);
        list.addAll(list2);
        return list;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter five integers for list1: ");
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list1.add(scanner.nextInt());
        }

        System.out.print("Enter five integers for list2: ");
        ArrayList<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list2.add(scanner.nextInt());
        }

        scanner.close();

        ArrayList<Integer> list = union(list1, list2);
        System.out.println("The combined list is " + list);
    }
}
