package com.xftxyz.chapter9;

import java.util.Date;

public class T3 {

    public static void main(String[] args) {
        Date date = new Date();
        for (int i = 0; i < 8; i++) {
            date.setTime((long) (Math.pow(10, 4) * Math.pow(10, i)));
            System.out.println(date);
        }

    }
}
