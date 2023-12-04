package com.xftxyz.chapter9;

public class T9 {

    public static void main(String[] args) {

        RegularPolygon regularPolygon = new RegularPolygon();
        RegularPolygon regularPolygon1 = new RegularPolygon(6, 4);
        RegularPolygon regularPolygon2 = new RegularPolygon(10, 4, 5.6, 7.8);

        System.out.println("regularPolygon:");
        System.out.println("perimeter: " + regularPolygon.getPerimeter());
        System.out.println("area: " + regularPolygon.getArea());
        System.out.println();

        System.out.println("regularPolygon1:");
        System.out.println("perimeter: " + regularPolygon1.getPerimeter());
        System.out.println("area: " + regularPolygon1.getArea());
        System.out.println();

        System.out.println("regularPolygon2:");
        System.out.println("perimeter: " + regularPolygon2.getPerimeter());
        System.out.println("area: " + regularPolygon2.getArea());
        System.out.println();

    }
}

class RegularPolygon {
    private int n = 3;
    private double side = 1;
    private double x = 0;
    private double y = 0;

    RegularPolygon() {

    }

    RegularPolygon(int n, double side) {
        this.n = n;
        this.side = side;
    }

    RegularPolygon(int n, double side, double x, double y) {
        this(n, side);
        this.x = x;
        this.y = y;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getPerimeter() {
        return n * side;
    }

    public double getArea() {
        return n * side * side / (4 * Math.tan(Math.PI / n));
    }
}