package com.xftxyz.chapter4;

public class T25 {

    public static void main(String[] args) {

        String carNumber = "";
        for (int i = 0; i < 3; i++) {
            char random = (char) (Math.random() * 26 + 'A');
            carNumber += random;
        }
        for (int i = 0; i < 4; i++) {
            int random = (int) (Math.random() * 10);
            carNumber += random;
        }

        System.out.println("The car number is " + carNumber);
    }
}
