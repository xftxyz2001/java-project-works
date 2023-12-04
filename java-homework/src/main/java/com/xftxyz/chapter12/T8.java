package com.xftxyz.chapter12;

import com.xftxyz.chapter12.t8.HexFormatException;

public class T8 {

    public static int hexToDec(String hexString) throws HexFormatException {
        int result = 0;
        for (int i = 0; i < hexString.length(); i++) {
            char ch = hexString.charAt(i);
            if (ch >= '0' && ch <= '9') {
                result = result * 16 + ch - '0';
            } else if (ch >= 'A' && ch <= 'F') {
                result = result * 16 + ch - 'A' + 10;
            } else if (ch >= 'a' && ch <= 'f') {
                result = result * 16 + ch - 'a' + 10;
            } else {
                throw new HexFormatException("Wrong input: " + hexString);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(hexToDec("1A"));
        System.out.println(hexToDec("1a"));
        System.out.println(hexToDec("1Z"));
    }
}
