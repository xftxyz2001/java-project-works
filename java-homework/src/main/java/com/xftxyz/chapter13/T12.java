package com.xftxyz.chapter13;

import com.xftxyz.chapter13.t12.Rectangle;
import com.xftxyz.chapter13.t9.Circle;
import com.xftxyz.chapter13.t9.GeometricObject;

public class T12 {

    public static double sumArea(GeometricObject[] gos) {
        double sum = 0;
        for (GeometricObject go : gos) {
            sum += go.getArea();
        }
        return sum;
    }

    public static void main(String[] args) {

        GeometricObject[] gos = new GeometricObject[4];
        gos[0] = new Rectangle(1, 1);
        gos[1] = new Rectangle(2, 3);
        gos[2] = new Circle(1);
        gos[3] = new Circle(2);

        System.out.println(sumArea(gos));
    }
}
