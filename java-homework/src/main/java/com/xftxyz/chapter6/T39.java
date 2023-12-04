package com.xftxyz.chapter6;

import java.util.Scanner;

public class T39 {

    // 点与线段的关系
    public static double relation(double x0, double y0, double x1, double y1, double x2, double y2) {
        double result = (x1 - x0) * (y2 - y0) - (x2 - x0) * (y1 - y0);
        return result;
    }

    public static boolean leftOfTheLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        return relation(x0, y0, x1, y1, x2, y2) > 0;
    }

    public static boolean onTheSameLine(double x0, double y0, double x1, double y1, double x2, double y2) {
        // return relation(x0, y0, x1, y1, x2, y2) == 0;
        return Math.abs(relation(x0, y0, x1, y1, x2, y2)) < 1e-7;
    }

    public static boolean onTheLineSegment(double x0, double y0, double x1, double y1, double x2, double y2) {
        return onTheSameLine(x0, y0, x1, y1, x2, y2) && (x2 >= Math.min(x0, x1) && x2 <= Math.max(x0, x1))
                && (y2 >= Math.min(y0, y1) && y2 <= Math.max(y0, y1));
    }

    // public static boolean rightOfTheLine(double x0, double y0, double x1, double
    // y1, double x2, double y2) {
    // return relation(x0, y0, x1, y1, x2, y2) < 0;
    // }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter three points for p0, p1, and p2: ");
        double x0 = scanner.nextDouble();
        double y0 = scanner.nextDouble();
        double x1 = scanner.nextDouble();
        double y1 = scanner.nextDouble();
        double x2 = scanner.nextDouble();
        double y2 = scanner.nextDouble();
        scanner.close();

        System.out.print("(" + x2 + ", " + y2 + ") is on the ");
        if (leftOfTheLine(x0, y0, x1, y1, x2, y2)) {
            System.out.print("left side of the line");
        } else if (onTheLineSegment(x0, y0, x1, y1, x2, y2)) {
            System.out.print("line segment");
        } else if (onTheSameLine(x0, y0, x1, y1, x2, y2)) {
            System.out.print("same line");
            // } else if (rightOfTheLine(x0, y0, x1, y1, x2, y2)) {
            // System.out.print("right side of the line");
            // }
        } else {
            System.out.print("right side of the line");
        }
        System.out.println(" from (" + x0 + ", " + y0 + ") to (" + x1 + ", " + y1 + ")");
    }
}
