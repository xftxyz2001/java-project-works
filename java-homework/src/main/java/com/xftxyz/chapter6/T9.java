package com.xftxyz.chapter6;

public class T9 {

    // Convert from feet to meters
    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    // Convert from meters to feet
    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

    public static void main(String[] args) {

        System.out.println("英尺\t米\t|\t米\t英尺");
        System.out.println("------------------------------------------");
        for (double feet = 1, meters = 20; feet <= 10; feet++, meters += 5) {
            System.out.printf("%4.1f\t%4.3f\t|\t%4.1f\t%4.3f\n", feet, footToMeter(feet), meters, meterToFoot(meters));
        }
    }
}
