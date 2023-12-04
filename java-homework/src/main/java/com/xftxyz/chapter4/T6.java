package com.xftxyz.chapter4;

public class T6 {

    public static void main(String[] args) {

        double radius = 40;

        // 产生三个圆上的点
        double angle1 = Math.random() * 2 * Math.PI;
        double angle2 = Math.random() * 2 * Math.PI;
        double angle3 = Math.random() * 2 * Math.PI;

        double x1 = radius * Math.cos(angle1);
        double y1 = radius * Math.sin(angle1);
        double x2 = radius * Math.cos(angle2);
        double y2 = radius * Math.sin(angle2);
        double x3 = radius * Math.cos(angle3);
        double y3 = radius * Math.sin(angle3);

        // 计算三个点构成三角形的三个角的角度
        double a = Math.pow(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2), 0.5);
        double b = Math.pow(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2), 0.5);
        double c = Math.pow(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2), 0.5);

        double A = Math.toDegrees(Math.acos((a * a - b * b - c * c) / (-2 * b * c)));
        double B = Math.toDegrees(Math.acos((b * b - a * a - c * c) / (-2 * a * c)));
        double C = Math.toDegrees(Math.acos((c * c - b * b - a * a) / (-2 * a * b)));

        // 输出结果
        System.out.println("The three angles are " + Math.round(A * 100) / 100.0 + " " + Math.round(B * 100) / 100.0
                + " " + Math.round(C * 100) / 100.0);
    }
}
