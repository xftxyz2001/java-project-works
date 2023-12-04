package com.xftxyz.chapter10;

public class T22 {

    public static void main(String[] args) {

        MyString1 s1 = new MyString1(new char[] { 'a', 'b', 'c', 'd' });
        MyString1 s2 = MyString1.valueOf(123);

        System.out.println(s1.charAt(2));
        System.out.println(s1.length());
        System.out.println(s1.substring(1, 3).charAt(1));
        System.out.println(s1.toLowerCase().charAt(2));
        System.out.println(s1.equals(new MyString1(new char[] { 'a', 'b', 'c', 'd' })));
        System.out.println(s1.equals(new MyString1(new char[] { 'a', 'b', 'c', 'e' })));
        System.out.println(s2.charAt(2));
        System.out.println(s2.length());
        System.out.println(s2.substring(1, 3).charAt(1));
        System.out.println(s2.toLowerCase().charAt(2));
        System.out.println(s2.equals(new MyString1(new char[] { '1', '2', '3' })));
        System.out.println(s2.equals(new MyString1(new char[] { '1', '2', '4' })));
    }
}

class MyString1 {

    private final char[] chars;

    public MyString1(char[] chars) {
        this.chars = chars;
    }

    public char charAt(int index) {
        return chars[index];
    }

    public int length() {
        return chars.length;
    }

    public MyString1 substring(int begin, int end) {
        char[] temp = new char[end - begin];
        System.arraycopy(chars, begin, temp, 0, end - begin);
        return new MyString1(temp);
    }

    public MyString1 toLowerCase() {
        char[] temp = new char[chars.length];
        for (int i = 0; i < chars.length; i++) {
            temp[i] = Character.toLowerCase(chars[i]);
        }
        return new MyString1(temp);
    }

    public boolean equals(MyString1 s) {
        if (chars.length != s.length()) {
            return false;
        }
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static MyString1 valueOf(int i) {
        int length = 0;
        int temp = i;
        while (temp != 0) {
            temp /= 10;
            length++;
        }
        char[] chars = new char[length];
        for (int j = length - 1; j >= 0; j--) {
            chars[j] = (char) ('0' + i % 10);
            i /= 10;
        }
        return new MyString1(chars);
    }
}