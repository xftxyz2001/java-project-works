package com.xftxyz.chapter9;

import java.util.Scanner;

public class T13 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of rows and columns of the array: ");
        int row = scanner.nextInt();
        int column = scanner.nextInt();

        double[][] doubles = new double[row][column];
        System.out.println("Enter the array:");
        for (int i = 0; i < doubles.length; i++) {
            for (int j = 0; j < doubles[i].length; j++) {
                doubles[i][j] = scanner.nextDouble();
            }
        }
        scanner.close();

        Location location = Location.locateLargest(doubles);
        System.out.println(location);

    }
}

class Location {

    public int row;
    public int column;
    public double maxValue;

    public Location(int row, int column, double maxValue) {
        this.row = row;
        this.column = column;
        this.maxValue = maxValue;
    }

    public static Location locateLargest(double[][] a) {
        int row = 0;
        int column = 0;
        double maxValue = a[row][column];
        for (int i = 0; i < a.length; i++) {
            double[] doubles = a[i];
            for (int j = 0; j < doubles.length; j++) {
                double aDouble = doubles[j];
                if (aDouble > maxValue) {
                    row = i;
                    column = j;
                    maxValue = aDouble;
                }
            }
        }
        return new Location(row, column, maxValue);
    }

    @Override
    public String toString() {
        return "The location of the largest element is " + maxValue + " at (" + row + ", "
                + column + ")";
    }
}