package com.xftxyz.chapter6;

import java.util.Scanner;

public class T18 {

    public static boolean checkPassword(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i)) || Character.isLetter(password.charAt(i))) {
                count++;
            } else {
                return false;
            }
        }

        return count >= 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();
        scanner.close();

        System.out.println(checkPassword(password) ? "Valid Password" : "Invalid Password");
    }
}
