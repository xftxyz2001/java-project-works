package com.xftxyz.chapter3;

import java.util.Scanner;

public class T17 {

    public static void main(String[] args) {

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

        Scanner scanner = new Scanner(System.in);
        System.out.print("scissor (0), rock (1), paper (2): ");
        int guess = scanner.nextInt();
        scanner.close();

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
        }
    }
}
