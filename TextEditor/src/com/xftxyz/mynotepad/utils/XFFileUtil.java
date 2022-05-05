package com.xftxyz.mynotepad.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class XFFileUtil {
    /*
     * 写
     */
    public static void SaveFile(String savePath, String saveName, String res) {
        File file = new File(savePath + saveName);
        SaveFile(file, res);
    }

    public static void SaveFile(File file, String res) {
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(file));
            out.write(res);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
     * 读
     */
    public static String ReadFile(String openPathName) {
        File file = new File(openPathName);
        return ReadFile(file);

    }

    public static String ReadFile(File file) {
        String res = "";
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            String line = br.readLine();
            if (line != null)
                res += line;
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }
}
