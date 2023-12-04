package com.xftxyz.chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class T16 {

    public static void main(String[] args) {
        // java T16 file oldString newString
        if (args.length != 3) {
            System.out.println("Usage: java T16 file oldString newString");
            System.exit(1);
        }

        String filename = args[0];
        String oldString = args[1];
        String newString = args[2];

        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File does not exist");
            System.exit(2);
        }

        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append("\n");
            }
            scanner.close();

            String content = sb.toString().replace(oldString, newString);

            PrintWriter writer = new PrintWriter(file);
            writer.write(content);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            System.out.println("Done");
        }

    }
}
