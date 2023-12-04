package com.xftxyz.chapter12;

public class T10 {

    public static void main(String[] args) {
        // 创造一个OOM并cach
        try {
            @SuppressWarnings("unused")
            int[] array = new int[Integer.MAX_VALUE];
        } catch (OutOfMemoryError e) {
            System.out.println("Out of memory");
        }

    }
}
