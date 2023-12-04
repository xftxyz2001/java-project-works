package com.xftxyz.chapter3;

public class T24 {

    public static void main(String[] args) {

        int random = (int) (Math.random() * 52);
        String card = "";
        switch (random / 13) {
            case 0:
                card = "Clubs";
                break;
            case 1:
                card = "Diamonds";
                break;
            case 2:
                card = "Hearts";
                break;
            default:
                card = "Spades";
                break;
        }

        String number = "";
        switch (random % 13) {
            case 0:
                number = "Ace";
                break;
            case 10:
                number = "Jack";
                break;
            case 11:
                number = "Queen";
                break;
            case 12:
                number = "King";
                break;
            default:
                number = "" + (random % 13 + 1);
                break;
        }

        System.out.println("The card you picked is " + number + " of " + card);
    }
}
