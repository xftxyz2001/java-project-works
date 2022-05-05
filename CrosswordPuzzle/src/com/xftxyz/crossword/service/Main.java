package com.xftxyz.crossword.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import com.xftxyz.crossword.domain.XFConstant;
import com.xftxyz.crossword.view.GameMain;

public class Main {
    public static void main(String[] args) {
        try {
            System.setOut(new PrintStream(new FileOutputStream(XFConstant.LOG_FILE_NAME, true)));
        } catch (FileNotFoundException e) {
            System.err.println("出错了");
        }
        GameMain gameMain = new GameMain();
        System.out.println(System.currentTimeMillis() + "初始化-" + XFConstant.CR);
        gameMain.reStart();
        System.out.println(System.currentTimeMillis() + "游戏开始");
    }
}
