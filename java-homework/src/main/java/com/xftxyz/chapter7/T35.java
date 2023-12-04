package com.xftxyz.chapter7;

import java.util.Scanner;

public class T35 {
    // 猜字词游戏
    public static void main(String[] args) {

        String[] words = { "write", "that", "program", "java", "hello", "world" };

        Scanner scanner = new Scanner(System.in);

        while (true) {
            int index = (int) (Math.random() * words.length);
            String word = words[index];

            char[] chars = new char[word.length()];
            for (int i = 0; i < chars.length; i++) {
                chars[i] = '*';
            }

            int count = 0;
            while (true) {
                System.out.print("(Guess) Enter a letter in word " + String.valueOf(chars) + " > ");
                char ch = scanner.next().charAt(0);

                if (isInWord(ch, word)) {
                    if (isInWord(ch, chars)) {
                        System.out.println(ch + " is already in the word");
                    } else {
                        for (int i = 0; i < chars.length; i++) {
                            if (ch == word.charAt(i)) {
                                chars[i] = ch;
                            }
                        }
                    }
                } else {
                    System.out.println(ch + " is not in the word");
                    count++;
                }

                if (isAllInWord(chars)) {
                    System.out.println(
                            "The word is " + word + ". You missed " + count + " time" + (count > 1 ? "s" : ""));
                    break;
                }
            }

            System.out.print("Do you want to guess another word? Enter y or n > ");
            char ch = scanner.next().charAt(0);
            if (ch == 'n') {
                break;
            }
        }

        scanner.close();
    }

    private static boolean isAllInWord(char[] chars) {
        for (char ch : chars) {
            if (ch == '*') {
                return false;
            }
        }
        return true;
    }

    private static boolean isInWord(char ch, String word) {
        for (int i = 0; i < word.length(); i++) {
            if (ch == word.charAt(i)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isInWord(char ch, char[] chars) {
        for (int i = 0; i < chars.length; i++) {
            if (ch == chars[i]) {
                return true;
            }
        }
        return false;
    }
}
