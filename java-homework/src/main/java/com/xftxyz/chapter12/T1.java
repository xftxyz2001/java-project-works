package com.xftxyz.chapter12;

public class T1 {

    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Usage: java Main \"operand1 operator operand2\"");
            System.exit(1);
        }

        int result = 0;
        try {
            switch (args[1].charAt(0)) {
                case '+':
                    result = Integer.parseInt(args[0]) + Integer.parseInt(args[2]);
                    break;
                case '-':
                    result = Integer.parseInt(args[0]) - Integer.parseInt(args[2]);
                    break;
                case '.':
                    result = Integer.parseInt(args[0]) * Integer.parseInt(args[2]);
                    break;
                case '/':
                    result = Integer.parseInt(args[0]) / Integer.parseInt(args[2]);
                    break;
            }
        } catch (NumberFormatException e) {
            System.out.println("Wrong Input: " + e.getMessage());
            System.exit(2);
        }

        System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result);

    }
}
