package com.xftxyz.chapter11;

import java.util.ArrayList;

public class T7 {

    // 打乱 ArrayList
    public static void shuffle(ArrayList<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int index = (int) (Math.random() * list.size());
            Integer temp = list.get(i);
            list.set(i, list.get(index));
            list.set(index, temp);
        }
    }

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list);
        shuffle(list);
        System.out.println(list);
    }
}
