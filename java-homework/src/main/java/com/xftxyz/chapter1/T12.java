package com.xftxyz.chapter1;

public class T12 {

    public static void main(String[] args) {

        int seconds = ((1 * 60) + 40) * 60 + 35;
        double distance = 24 * 1.6;

        double speed = distance / seconds;
        System.out.println(speed);
    }
}
