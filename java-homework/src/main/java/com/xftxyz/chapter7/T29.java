package com.xftxyz.chapter7;

public class T29 {

    // 得到一张牌
    public static String getCard() {
        String[] suits = { "Spades", "Hearts", "Diamonds", "Clubs" };
        String[] ranks = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9",
                "10", "Jack", "Queen", "King" };
        int suit = (int) (Math.random() * 4);
        int rank = (int) (Math.random() * 13);
        return ranks[rank] + " of " + suits[suit];
    }

    // 获得花色
    public static String getSuit(String card) {
        return card.substring(card.indexOf("of") + 3);
    }

    // 获得点数
    public static int getRank(String card) {
        String rank = card.substring(0, card.indexOf("of") - 1);
        switch (rank) {
            case "Ace":
                return 1;
            case "Jack":
                return 11;
            case "Queen":
                return 12;
            case "King":
                return 13;
            default:
                return Integer.parseInt(rank);
        }
    }

    // 随机抽取4张牌计算点数
    public static int getPoint() {
        int point = 0;
        for (int i = 0; i < 4; i++) {
            String card = getCard();
            // System.out.println(card);
            point += getRank(card);
        }
        return point;
    }

    public static void main(String[] args) {
        int count = 0;
        while (true) {
            int point = getPoint();
            count++;
            if (point == 24) {
                break;
            }
        }
        System.out.printf("The number of picks that yields the sum of 24 is %d\n", count);
    }
}
