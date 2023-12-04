package com.xftxyz.chapter5;

import java.util.Scanner;

public class T9 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of students: ");
        int count = scanner.nextInt();

        String first = "";
        int firstScore = 0;
        String second = "";
        int secondScore = 0;

        for (int i = 0; i < count; i++) {
            System.out.print("Enter the student's name: ");
            String name = scanner.next();
            System.out.print("Enter the student's score: ");
            int score = scanner.nextInt();

            if (score > firstScore) {
                second = first;
                secondScore = firstScore;
                first = name;
                firstScore = score;
            } else if (score > secondScore) {
                second = name;
                secondScore = score;
            }
        }
        scanner.close();

        System.out.println("The first place is: " + first + ", score is: " + firstScore);
        System.out.println("The second place is: " + second + ", score is: " + secondScore);
    }
}
