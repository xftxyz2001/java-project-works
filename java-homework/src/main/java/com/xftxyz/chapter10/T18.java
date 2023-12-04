package com.xftxyz.chapter10;

import java.math.BigInteger;

public class T18 {

    public static void main(String[] args) {
        BigInteger bigInteger = BigInteger.valueOf(Long.MAX_VALUE);
        int count = 0;

        while (count < 5) {
            bigInteger = bigInteger.add(BigInteger.ONE);
            if (bigInteger.isProbablePrime(1)) {
                System.out.println(bigInteger);
                count++;
            }
        }
    }
}