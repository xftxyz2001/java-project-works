package com.xftxyz.chapter12;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class T11 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java T11 str filename");
            System.exit(1);
        }

        String str = args[0];
        String filename = args[1];

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

            String content = sb.toString().replace(str, "");

            PrintWriter writer = new PrintWriter(file);
            writer.write(content);
            writer.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}