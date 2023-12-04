package com.xftxyz.chapter13;

import com.xftxyz.chapter13.t1.Triangle;

public class T1 {

    public static void main(String[] args) {

        Triangle triangle = new Triangle(1, 1.5, 1);
        triangle.setColor("yellow");
        triangle.setFilled(true);
        System.out.println(triangle);
        System.out.println("The area is " + triangle.getArea());
        System.out.println("The perimeter is " + triangle.getPerimeter());
        System.out.println("The color is " + triangle.getColor());
        System.out.println("Is filled? " + triangle.isFilled());
    }
}