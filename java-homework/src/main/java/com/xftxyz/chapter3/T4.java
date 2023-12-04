package com.xftxyz.chapter3;

public class T4 {

    public static void main(String[] args) {

        int random = (int) (Math.random() * 12) + 1;
        String month = "";
        switch (random) {
            case 1:
                month = "January";
                break;
            case 2:
                month = "February";
                break;
            case 3:
                month = "March";
                break;
            case 4:
                month = "April";
                break;
            case 5:
                month = "May";
                break;
            case 6:
                month = "June";
                break;
            case 7:
                month = "July";
                break;
            case 8:
                month = "August";
                break;
            case 9:
                month = "Septemper";
                break;
            case 10:
                month = "October";
                break;
            case 11:
                month = "November";
                break;
            default:
                month = "December";
                break;
        }

        System.out.println("The random month is " + month);
    }
}
