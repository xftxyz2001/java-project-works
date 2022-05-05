package com.xftxyz.crossword.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import com.xftxyz.crossword.domain.Book;
import com.xftxyz.crossword.domain.XFConstant;

public class MyFileReader {

    private static final int ROLE_NUMBER = 5;

    // 生成默认数据文件
    public static void write() {
        File file = new File(XFConstant.DATA_FILE);
        System.out.println(System.currentTimeMillis() + "创建默认数据文件");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.err.println("文件创建失败");
            }
        }
        PrintWriter output = null;
        try {
            output = new PrintWriter(file);
            output.print(XFConstant.DEFAULT_DATA);
        } catch (FileNotFoundException e) {
            System.err.println("文件异常。");
        } finally {
            if (output != null) {
                output.close();
            }
        }
    }

    public static Book[] read() {
        File file = new File(XFConstant.DATA_FILE);
        if (!file.exists()) {
            System.out.println(System.currentTimeMillis() + "数据文件不存在");
            write();
        }
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            int bookNumber = sc.nextInt();
            Book[] books = new Book[bookNumber];
            for (int i = 0; i < books.length; i++) {
                String bookName = sc.next();
                String[] roles = new String[ROLE_NUMBER];
                for (int j = 0; j < roles.length; j++) {
                    roles[j] = sc.next();
                }
                books[i] = new Book(bookName, roles);
            }
            return books;
        } catch (FileNotFoundException e) {
            System.err.println("文件异常");
            return null;
        } finally {
            if (sc != null) {
                sc.close();
            }
        }

    }
}
