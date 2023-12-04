package com.xftxyz.chapter11;

import java.util.ArrayList;

public class T18 {

    // 字符数组列表
    public static ArrayList<Character> toCharacterArray(String s) {
        ArrayList<Character> list = new ArrayList<>();
        for (char ch : s.toCharArray()) {
            list.add(ch);
        }
        return list;
    }

    public static void main(String[] args) {

        ArrayList<Character> list = toCharacterArray("Hello");
        System.out.println(list);
    }
}
