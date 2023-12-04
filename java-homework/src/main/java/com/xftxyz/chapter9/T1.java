package com.xftxyz.chapter9;

public class T1 {

    public static void main(String[] args) {
        Rectangle rectangle1 = new Rectangle(4, 40);
        Rectangle rectangle2 = new Rectangle(3.5, 35.9);

        System.out.println("rectangle1:");
        System.out.println("width: " + rectangle1.width);
        System.out.println("height: " + rectangle1.height);
        System.out.println("area: " + rectangle1.getArea());
        System.out.println("perimeter: " + rectangle1.getPerimeter());

        System.out.println();

        System.out.println("rectangle2:");
        System.out.println("width: " + rectangle2.width);
        System.out.println("height: " + rectangle2.height);
        System.out.println("area: " + rectangle2.getArea());
        System.out.println("perimeter: " + rectangle2.getPerimeter());
    }
}

class Rectangle {

    double width = 1;
    double height = 1;

    Rectangle() {

    }

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    double getArea() {
        return width * height;
    }

    double getPerimeter() {
        return 2 * (width + height);
    }
}