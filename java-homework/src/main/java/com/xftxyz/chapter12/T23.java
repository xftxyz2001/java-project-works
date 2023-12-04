package com.xftxyz.chapter12;

import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class T23 {

    public static void main(String[] args) {
        try {
            @SuppressWarnings("deprecation")
            URL url = new URL("http://liveexample.pearsoncmg.com/data/Scores.txt");
            URLConnection connection = url.openConnection();
            Scanner scanner = new Scanner(connection.getInputStream());
            double sum = 0;
            int count = 0;
            while (scanner.hasNext()) {
                sum += scanner.nextDouble();
                count++;
            }
            System.out.println("总分: " + sum);
            System.out.println("平均分: " + sum / count);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
