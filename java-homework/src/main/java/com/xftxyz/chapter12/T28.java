package com.xftxyz.chapter12;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class T28 {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("Exercise(\\d+)_(\\d+)\\.java");

        for (String arg : args) {
            Matcher matcher = pattern.matcher(arg);
            if (matcher.matches()) {
                String i = matcher.group(1);
                String j = matcher.group(2);

                if (i.length() == 1) {
                    i = "0" + i;
                }

                String newFileName = "Exercise" + i + "_" + j + ".java";

                try {
                    Path sourcePath = Paths.get(arg);
                    Files.move(sourcePath, sourcePath.resolveSibling(newFileName));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}