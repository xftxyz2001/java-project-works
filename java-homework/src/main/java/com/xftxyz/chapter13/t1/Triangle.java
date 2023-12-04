package com.xftxyz.chapter13.t1;

public class Triangle extends GeometricObject {
    private double side1;
    private double side2;
    private double side3;

    public Triangle() {
        super();
        side1 = side2 = side3 = 1.0;
    }

    public Triangle(double side1, double side2, double side3) {
        super();
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) {
        super(color, filled);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // 计算三角形的面积
    @Override
    public double getArea() {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    // 计算三角形的周长
    @Override
    public double getPerimeter() {
        return side1 + side2 + side3;
    }

    // 返回三角形的字符串描述
    @Override
    public String toString() {
        return "Triangle [side1=" + side1 + ", side2=" + side2 + ", side3=" + side3 + ", toString()="
                + super.toString() + "]";
    }

}