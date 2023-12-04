package com.xftxyz.chapter10;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T26 {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Main \"operand1 operator operand2\"");
            System.exit(1);
        }

        Pattern pattern = Pattern.compile("(\\d+)\\s+([-+*/])\\s+(\\d+)");
        Matcher matcher = pattern.matcher(args[0]);

        if (matcher.matches()) {
            double operand1 = Double.parseDouble(matcher.group(1));
            String operator = matcher.group(2);
            double operand2 = Double.parseDouble(matcher.group(3));

            switch (operator) {
                case "+":
                    System.out.println(operand1 + operand2);
                    break;
                case "-":
                    System.out.println(operand1 - operand2);
                    break;
                case "*":
                    System.out.println(operand1 * operand2);
                    break;
                case "/":
                    if (operand2 != 0) {
                        System.out.println(operand1 / operand2);
                    } else {
                        System.out.println("Error: Division by zero");
                    }
                    break;
                default:
                    System.out.println("Error: Invalid operator");
                    break;
            }
        } else {
            System.out.println("Invalid argument format. It should be \"operand1operatoroperand2\"");
        }
    }
}
