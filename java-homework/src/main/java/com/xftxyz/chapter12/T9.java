package com.xftxyz.chapter12;

import com.xftxyz.chapter12.t9.BinaryFormatException;

public class T9 {

    public static int binToDec(String binString) throws BinaryFormatException {
        int result = 0;
        for (int i = 0; i < binString.length(); i++) {
            char ch = binString.charAt(i);
            if (ch == '0' || ch == '1') {
                result = result * 2 + ch - '0';
            } else {
                throw new BinaryFormatException("Wrong input: " + binString);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(binToDec("1010"));
        System.out.println(binToDec("1012"));

    }
}
