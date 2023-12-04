package com.xftxyz.chapter3;

public class T16 {

    public static void main(String[] args) {

        double x0 = 0;
        double y0 = 0;
        double width = 100;
        double height = 200;

        double x1 = Math.random() * width + (x0 - width / 2);
        double y1 = Math.random() * height + (y0 - height / 2);

        System.out.println("(" + x1 + ", " + y1 + ")");
    }
}
