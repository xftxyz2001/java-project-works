package com.xftxyz.chapter13.t1;

public abstract class GeometricObject {
    private String color = "white";
    private boolean filled;
    private java.util.Date dateCreated;

    protected GeometricObject() {
        dateCreated = new java.util.Date();
    }

    protected GeometricObject(String color, boolean filled) {
        this();
        this.color = color;
        this.filled = filled;
    }

    // 返回颜色
    public String getColor() {
        return color;
    }

    // 设置颜色
    public void setColor(String color) {
        this.color = color;
    }

    // 返回是否填充
    public boolean isFilled() {
        return filled;
    }

    // 设置是否填充
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // 返回创建日期
    public java.util.Date getDateCreated() {
        return dateCreated;
    }

    // 返回几何对象的字符串描述
    @Override
    public String toString() {
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    // 抽象方法，返回几何对象的面积
    public abstract double getArea();

    // 抽象方法，返回几何对象的周长
    public abstract double getPerimeter();
}