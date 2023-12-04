package com.xftxyz.chapter10;

public class T27 {

    public static void main(String[] args) {

        MyStringBuilder1 s1 = new MyStringBuilder1("BBBAAA");
        MyStringBuilder1 s2 = new MyStringBuilder1("def");
        MyStringBuilder1 s3 = s1.append(s2);
        System.out.println(s3);
        System.out.println(s3.length());
        System.out.println(s3.charAt(0));
        System.out.println(s3.toLowerCase());
        System.out.println(s3.substring(1, 3));
    }
}

class MyStringBuilder1 {

    private char[] chars;
    private int size;

    public MyStringBuilder1() {
        this(16);
    }

    public MyStringBuilder1(int capacity) {
        chars = new char[capacity];
    }

    public MyStringBuilder1(String s) {
        this(s.toCharArray());
    }

    public MyStringBuilder1(char[] chars) {
        this(chars.length);
        append(chars);
    }

    private MyStringBuilder1 append(char[] chars) {
        if (size + chars.length > this.chars.length) {
            char[] temp = new char[size + chars.length];
            System.arraycopy(this.chars, 0, temp, 0, size);
            this.chars = temp;
        }
        System.arraycopy(chars, 0, this.chars, size, chars.length);
        size += chars.length;
        return this;
    }

    public MyStringBuilder1 append(MyStringBuilder1 s) {
        return append(s.chars);
    }

    public MyStringBuilder1 append(int i) {
        return append(String.valueOf(i).toCharArray());
    }

    public int length() {
        return size;
    }

    public char charAt(int index) {
        return chars[index];
    }

    public MyStringBuilder1 toLowerCase() {
        for (int i = 0; i < size; i++) {
            chars[i] = Character.toLowerCase(chars[i]);
        }
        return this;
    }

    public MyStringBuilder1 substring(int begin, int end) {
        char[] temp = new char[end - begin];
        System.arraycopy(chars, begin, temp, 0, end - begin);
        return new MyStringBuilder1(temp);
    }

    public String toString() {
        return new String(chars, 0, size);
    }

}