package com.xftxyz.chapter12;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class T30 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a filename: ");
        String filename = scanner.nextLine();
        scanner.close();

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(2);
        }

        // 统计每个字符出现的次数（区分大小写）
        Map<Character, Integer> charCount = new HashMap<>();
        FileReader reader = null;
        try {
            reader = new FileReader(file);
            int ch;
            while ((ch = reader.read()) != -1) {
                char character = (char) ch;
                charCount.put(character, charCount.getOrDefault(character, 0) + 1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        for (Map.Entry<Character, Integer> entry : charCount.entrySet()) {
            System.out.println("Number of " + entry.getKey() + "'s: " + entry.getValue());
        }
    }
}