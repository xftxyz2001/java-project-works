package com.xftxyz.chapter6;

public class T30 {
    // 双骰子赌博

    public static int roll() {
        return (int) (Math.random() * 6 + 1);
    }

    public static boolean run(boolean debug) {
        int r1 = roll();
        int r2 = roll();

        int sum = r1 + r2;
        if (debug)
            System.out.println("You rolled " + r1 + " + " + r2 + " = " + sum);
        if (sum == 2 || sum == 3 || sum == 12) { // craps
            if (debug)
                System.out.println("You lose");
            return false;
        } else if (sum == 7 || sum == 11) { // natural
            if (debug)
                System.out.println("You win");
            return true;
        } else {
            int point = sum;
            if (debug)
                System.out.println("point is " + point);
            while (true) {
                r1 = roll();
                r2 = roll();
                sum = r1 + r2;
                if (debug)
                    System.out.println("You rolled " + r1 + " + " + r2 + " = " + sum);
                if (sum == point) {
                    if (debug)
                        System.out.println("You win");
                    return true;
                    // break;
                } else if (sum == 7) {
                    if (debug)
                        System.out.println("You lose");
                    return false;
                    // break;
                }
            }
        }

    }

    public static void run() {
        run(true);
    }

    public static void main(String[] args) {
        run();
        // int win = 0;
        // int lose = 0;
        // for (int i = 0; i < 10000; i++) {
        //     if (run(false)) {
        //         win++;
        //     } else {
        //         lose++;
        //     }
        // }
        // System.out.println("win: " + win);
        // System.out.println("lose: " + lose);
    }
}
