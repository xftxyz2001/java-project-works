package com.xftxyz.chapter12;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class T19 {

    public static void main(String[] args) {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Lincoln.txt");
            URLConnection connection = url.openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            int wordCount = 0;
            while (scanner.hasNext()) {
                scanner.next();
                wordCount++;
            }
            System.out.println("单词数: " + wordCount);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}