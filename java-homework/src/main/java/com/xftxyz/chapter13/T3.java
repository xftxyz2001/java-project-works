package com.xftxyz.chapter13;

import java.util.ArrayList;

public class T3 {

    // 排序
    public static void sort(ArrayList<Number> list) {
        if (list == null || list.size() == 0) {
            return;
        }

        list.sort((o1, o2) -> {
            if (o1.doubleValue() > o2.doubleValue()) {
                return 1;
            } else if (o1.doubleValue() < o2.doubleValue()) {
                return -1;
            } else {
                return 0;
            }
        });
    }

    public static void main(String[] args) {

        ArrayList<Number> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
        sort(list);
        System.out.println(list);
    }
}
