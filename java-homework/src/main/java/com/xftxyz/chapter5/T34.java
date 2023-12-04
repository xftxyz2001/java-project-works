package com.xftxyz.chapter5;

import java.util.Scanner;

public class T34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int winCount = 0; // 赢的次数
        int lastWin = -1; // 上一次赢的一方，0表示玩家赢，1表示电脑赢
        while (winCount < 3) {

            int random = (int) (Math.random() * 3);
            String computer = "";
            switch (random) {
                case 0:
                    computer = "scissor";
                    break;
                case 1:
                    computer = "rock";
                    break;
                default:
                    computer = "paper";
                    break;
            }

            System.out.print("scissor (0), rock (1), paper (2): ");
            int guess = scanner.nextInt();

            String guessString = "";
            switch (guess) {
                case 0:
                    guessString = "scissor";
                    break;
                case 1:
                    guessString = "rock";
                    break;
                default:
                    guessString = "paper";
                    break;
            }

            System.out.print("The computer is " + computer + ". ");

            if (guess == random) {
                System.out.println("You are " + guessString + " too. It is a draw");

            } else {
                boolean win = (guess == 0 && random == 1) || (guess == 1 && random == 2) || (guess == 2 && random == 0);
                System.out.println("You are " + guessString + ". You " + (win ? "win" : "lose"));
                if (win) {
                    if (lastWin == 0) {
                        winCount++;
                    } else {
                        winCount = 1;
                    }
                    lastWin = 0;
                } else {
                    if (lastWin == 1) {
                        winCount++;
                    } else {
                        winCount = 1;
                    }
                    lastWin = 1;
                }
            }
        }
        scanner.close();

        if (lastWin == 0) {
            System.out.println("You win the game");
        } else {
            System.out.println("You lose the game");
        }
    }
}