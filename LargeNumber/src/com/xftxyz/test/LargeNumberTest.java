package com.xftxyz.test;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

import com.xftxyz.util.LargeNumber;

import org.junit.Test;

public class LargeNumberTest {
    final int[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8 };

    @Test
    public void testValue() throws Exception {
        LargeNumber x = new LargeNumber("-12345464531534534563454564616535341");

        long l = x.longValue();
        System.out.println(l);

        float f = x.floatValue();
        System.out.println(f);

        double d = x.doubleValue();
        System.out.println(d);

    }

    @Test
    public void testToString() throws Exception {
        LargeNumber x = new LargeNumber("-1274456456436413546845133");

        System.out.println(x);
    }

    @Test
    public void testCompare() throws Exception {
        LargeNumber x = new LargeNumber("0");
        LargeNumber y = new LargeNumber("0");
        System.out.println(x.compareTo(y));
    }

    @Test
    public void testFinalArrayClone() throws Exception {
        LargeNumberTest test = new LargeNumberTest();
        int[] x = test.numbers.clone();
        x[0] = 3;
        System.out.println(Arrays.toString(x));
        System.out.println(Arrays.toString(test.numbers));
    }

    public void testAAA() {
        // int[] res = null;
        // int carry = 0, NumIndex = this.num.length - 1, ThisNumIndex = num.length;

    }

    @Test
    public void testAddSameSign() throws Exception {
        LargeNumber x = new LargeNumber("1111");
        LargeNumber y = new LargeNumber("22222");// 24444

        LargeNumber z = x.add(y);
        System.out.println(z);
    }

    @Test
    public void testAddSameSign2() throws Exception {
        LargeNumber x = new LargeNumber("-1111");
        LargeNumber y = new LargeNumber("-22222");// -23333

        LargeNumber z = x.add(y);
        System.out.println(z);
    }

    @Test
    public void testSub() throws Exception {
        LargeNumber x = new LargeNumber("123");
        LargeNumber y = new LargeNumber("122");
        LargeNumber z1 = x.add(y);
        LargeNumber z2 = x.subtract(y);// 878

        System.out.println(z1);
        System.out.println(z2);

    }

    @Test
    public void testSub2() throws Exception {
        LargeNumber x = new LargeNumber("123");
        LargeNumber y = new LargeNumber("-456");
        LargeNumber z1 = x.add(y);
        LargeNumber z2 = x.subtract(y);

        System.out.println(z1);
        System.out.println(z2);

    }

    @Test
    public void testMultiplication() throws Exception {
        LargeNumber x = new LargeNumber("123");
        LargeNumber y = new LargeNumber("10");
        LargeNumber z = x.multiply(y);
        System.out.println(z);
    }

    @Test
    public void testMultiplication2() throws Exception {
        LargeNumber x = new LargeNumber("521");
        LargeNumber y = new LargeNumber("114514");
        LargeNumber z = x.multiply(y);
        System.out.println(z);

    }

    @Test
    public void testMultiplication3() throws Exception {
        LargeNumber x = new LargeNumber("1145156132456414");
        LargeNumber y = new LargeNumber("-1");
        LargeNumber z = x.multiply(y);
        System.out.println(z);
        // System.out.println(1/0);

    }

    @Test
    public void testDivide() throws Exception {
        LargeNumber x = new LargeNumber("5265");
        LargeNumber y = new LargeNumber("251");
        // 90115879817765432

        LargeNumber z = x.divide(y);
        System.out.println(z);
        System.out.println(x.mod(y));
        // System.out.println(5265%251);
    }

    @Test
    public void testDivide1() throws Exception {
        LargeNumber x = new LargeNumber("1657463153435");
        LargeNumber y = new LargeNumber("1244561");
        System.out.println(x.divide(y));
        System.out.println(123123 / 124);
        System.out.println(x.mod(y));

        System.out.println(123123 % 124);
    }

    @Test
    public void testDivide2() throws Exception {
        String x = "-12314";
        String y = "46";
        LargeNumber lx = new LargeNumber(x);
        LargeNumber ly = new LargeNumber(y);
        BigInteger bx = new BigInteger(x);
        BigInteger by = new BigInteger(y);
        System.out.println(lx.add(ly));
        System.out.println(bx.add(by));
        System.out.println(lx.divide(ly));
        System.out.println(bx.divide(by));

    }

    @Test
    public void testDivide3() {
        Random rand = new Random();
        try {
            System.setOut(new PrintStream("D:\\XF\\Desktop\\Workspace\\JavaProjectWorks\\LargeNumber\\testOut.txt"));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (true) {

            String x = String.valueOf(rand.nextLong());
            String y = String.valueOf(rand.nextLong());
            System.out.println("x=" + x + " y=" + y);
            System.err.println("x=" + x + " y=" + y);
            LargeNumber lx = new LargeNumber(x);
            LargeNumber ly = new LargeNumber(y);
            BigInteger bx = new BigInteger(x);
            BigInteger by = new BigInteger(y);

            String add = lx.add(ly).toString();
            System.out.println("lx+ly=" + add + ":" + add.equals(bx.add(by).toString()));

            String subtract = lx.subtract(ly).toString();
            System.out.println("lx-ly=" + subtract + ":" + subtract.equals(bx.subtract(by).toString()));

            String multiply = lx.multiply(ly).toString();
            System.out.println("lx*ly=" + multiply + ":" + multiply.equals(bx.multiply(by).toString()));

            String divide = lx.divide(ly).toString();
            System.out.println("lx/ly=" + divide + ":" + divide.equals(bx.divide(by).toString()));

            // if (ly.compareTo(new LargeNumber("0")) > 0) {
            // String mod = lx.mod(ly).toString();
            // System.out.println("lx%ly=" + mod + ":" + mod.equals(bx.mod(by).toString()));
            // }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    @Test
    public void testFinal() {
        Random rand = new Random();
        try {
            System.setOut(new PrintStream("D:\\XF\\Desktop\\Workspace\\JavaProjectWorks\\LargeNumber\\testOut.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (true) {

            String x = String.valueOf(rand.nextLong());
            String y = String.valueOf(rand.nextLong());
            System.out.println("x=" + x + " y=" + y);
            System.err.println("x=" + x + " y=" + y);
            LargeNumber lx = new LargeNumber(x);
            LargeNumber ly = new LargeNumber(y);
            BigInteger bx = new BigInteger(x);
            BigInteger by = new BigInteger(y);

            String add = lx.add(ly).toString();
            if (add.equals(bx.add(by).toString())) {
                System.out.println("lx+ly=" + add + ":" + true);
            } else {
                System.err.println("==========lx+ly=" + add + ":" + false);
            }

            String subtract = lx.subtract(ly).toString();
            if (subtract.equals(bx.subtract(by).toString())) {
                System.out.println("lx-ly=" + subtract + ":" + true);
            } else {
                System.err.println("==========lx-ly=" + subtract + ":" + false);
            }

            String multiply = lx.multiply(ly).toString();
            if (multiply.equals(bx.multiply(by).toString())) {
                System.out.println("lx*ly=" + multiply + ":" + true);
            } else {
                System.err.println("==========lx*ly=" + multiply + ":" + false);
            }

            String divide = lx.divide(ly).toString();
            if (divide.equals(bx.divide(by).toString())) {
                System.out.println("lx/ly=" + divide + ":" + true);
            } else {
                System.err.println("==========lx/ly=" + divide + ":" + false);
            }

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

}
