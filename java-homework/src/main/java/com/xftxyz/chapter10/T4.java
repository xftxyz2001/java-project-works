package com.xftxyz.chapter10;

public class T4 {

    public static void main(String[] args) {

        MyPoint p1 = new MyPoint();
        MyPoint p2 = new MyPoint(10, 30.5);

        System.out.println(p1.distance(p2));

    }
}

class MyPoint {
    private double x;
    private double y;

    public MyPoint() {
        this(0, 0);
    }

    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double distance(MyPoint point) {
        return distance(point.x, point.y);
    }

    public double distance(double x2, double y2) {
        return Math.hypot(x - x2, y - y2);
    }

    public static double distance(MyPoint p1, MyPoint p2) {
        return p1.distance(p2);
    }

}