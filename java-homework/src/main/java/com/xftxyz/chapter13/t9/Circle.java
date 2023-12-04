package com.xftxyz.chapter13.t9;

public class Circle extends GeometricObject implements Comparable<Circle> {
    private double radius;

    public Circle() {
        super();
    }

    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        this.radius = radius;
    }

    // 返回半径
    public double getRadius() {
        return radius;
    }

    // 设置半径
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // 返回面积
    @Override
    public double getArea() {
        return radius * radius * Math.PI;
    }

    // 返回周长
    @Override
    public double getPerimeter() {
        return 2 * radius * Math.PI;
    }

    // 返回直径
    public double getDiameter() {
        return 2 * radius;
    }

    // 打印圆的信息
    public void printCircle() {
        System.out.println("The circle is created " + getDateCreated() + " and the radius is " + radius);
    }

    @Override
    public String toString() {
        return "Circle [radius=" + radius + ", toString()=" + super.toString() + "]";
    }

    @Override
    public int compareTo(Circle o) {
        if (this.radius > o.radius) {
            return 1;
        } else if (this.radius < o.radius) {
            return -1;
        } else {
            return 0;
        }
    }

}