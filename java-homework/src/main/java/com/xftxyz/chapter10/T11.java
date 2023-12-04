package com.xftxyz.chapter10;

public class T11 {

    public static void main(String[] args) {

        Circle2D c1 = new Circle2D(2, 2, 5.5);
        System.out.println(c1.contains(3, 3));
        System.out.println(c1.contains(new Circle2D(4, 5, 10.5)));
        System.out.println(c1.overlaps(new Circle2D(3, 5, 2.3)));

    }
}

class Circle2D {

    private double x;
    private double y;
    private double radius;

    public Circle2D() {
        this(0, 0, 1);
    }

    public Circle2D(double x, double y, double radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getRadius() {
        return radius;
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean contains(double x, double y) {
        return distance(x, y) < radius;
    }

    public boolean contains(Circle2D circle) {
        return distance(circle.x, circle.y) + circle.radius < radius;
    }

    public boolean overlaps(Circle2D circle) {
        return distance(circle.x, circle.y) < radius + circle.radius;
    }

    private double distance(double x, double y) {
        return Math.hypot(this.x - x, this.y - y);
    }

}