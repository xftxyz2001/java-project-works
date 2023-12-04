package com.xftxyz.chapter13.t12;

import com.xftxyz.chapter13.t9.GeometricObject;

public class Rectangle extends GeometricObject implements Comparable<Rectangle> {

    private double width;
    private double height;

    public Rectangle() {
        super();
    }

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color, boolean filled) {
        super(color, filled);
        this.width = width;
        this.height = height;
    }

    // 返回宽度
    public double getWidth() {
        return width;
    }

    // 设置宽度
    public void setWidth(double width) {
        this.width = width;
    }

    // 返回高度
    public double getHeight() {
        return height;
    }

    // 设置高度
    public void setHeight(double height) {
        this.height = height;
    }

    // 返回面积
    @Override
    public double getArea() {
        return width * height;
    }

    // 返回周长
    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public int compareTo(Rectangle o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        } else if (this.getArea() < o.getArea()) {
            return -1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Rectangle [width=" + width + ", height=" + height + ", toString()=" + super.toString() + "]";
    }
}
