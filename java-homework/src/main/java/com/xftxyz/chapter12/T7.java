package com.xftxyz.chapter12;

public class T7 {

    public static int binToDec(String binString) throws NumberFormatException {
        int result = 0;
        for (int i = 0; i < binString.length(); i++) {
            char ch = binString.charAt(i);
            if (ch == '0' || ch == '1') {
                result = result * 2 + ch - '0';
            } else {
                throw new NumberFormatException("Wrong input: " + binString);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binToDec("1010"));
        System.out.println(binToDec("1012"));

    }
}
