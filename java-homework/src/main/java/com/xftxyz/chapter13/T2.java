package com.xftxyz.chapter13;

import java.util.ArrayList;

public class T2 {

    // 打乱 ArrayList
    public static void shuffle(ArrayList<Number> list) {
        if (list == null || list.size() == 0) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int index = (int) (Math.random() * list.size());
            Number temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }

    public static void main(String[] args) {

        ArrayList<Number> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
        shuffle(list);
        System.out.println(list);
    }
}
