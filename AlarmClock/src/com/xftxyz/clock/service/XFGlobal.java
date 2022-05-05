package com.xftxyz.clock.service;

import java.awt.Font;
import java.io.File;
import java.time.format.DateTimeFormatter;

import javax.swing.plaf.FontUIResource;

public interface XFGlobal {
    int WIDTH = 880;
    int HEIGHT = 400;
    Font DATE_FONT = new FontUIResource("宋体", FontUIResource.BOLD, 56);
    DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy年MM月dd日");
    Font TIME_FONT = new FontUIResource("宋体", FontUIResource.BOLD, 82);
    DateTimeFormatter TIME_FORMAT = DateTimeFormatter.ofPattern("HH:mm:ss");
    DateTimeFormatter DATE_TIME_FORMAT = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss");
    String ABOUT_CONTENT = "提示：点击添加闹钟以开始。闹钟的日期格式为：yyyy年MM月dd日 HH:mm:ss";
    File SAVE_FILE = new File("a.dat");

}
