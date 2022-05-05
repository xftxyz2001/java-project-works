package com.xftxyz.clock.utils;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;

import com.xftxyz.clock.domain.ClockEventItem;
import com.xftxyz.clock.service.XFGlobal;

public class XFFileUtil {

    public static void saveClockList(Vector<ClockEventItem> clockList) {
        PrintWriter pw = null;
        clockList.sort(new Comparator<ClockEventItem>() {

            @Override
            public int compare(ClockEventItem o1, ClockEventItem o2) {
                return o1.compareTo(o2);
            }

        });
        try {
            pw = new PrintWriter(new FileWriter(XFGlobal.SAVE_FILE));
            pw.println(clockList.size());
            for (ClockEventItem clockEventItem : clockList) {
                pw.println(clockEventItem.getEventTime().toString());
                pw.println(clockEventItem.getEvent());
                pw.println(clockEventItem.isPlaySound());
            }
        } catch (IOException e) {
            // 提示用户保存失败
            JOptionPane.showMessageDialog(null, "保存文件失败", "错误", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }

    }

    public static Vector<ClockEventItem> loadClockList() {
        Vector<ClockEventItem> clockList = new Vector<ClockEventItem>();
        Scanner scanner = null;
        PrintWriter pw = null;
        try {
            if (!XFGlobal.SAVE_FILE.exists()) {
                pw = new PrintWriter(new FileWriter(XFGlobal.SAVE_FILE));
                pw.println(0);
            }
            scanner = new Scanner(XFGlobal.SAVE_FILE);
            int size = scanner.nextInt();
            for (int i = 0; i < size; i++) {
                LocalDateTime eventTime = LocalDateTime.parse(scanner.next());
                String event = scanner.next();
                boolean playSound = scanner.nextBoolean();
                clockList.add(new ClockEventItem(eventTime, event, playSound));
            }
        } catch (IOException e) {
            // 提示用户读取失败
            JOptionPane.showMessageDialog(null, "读取文件失败", "错误", JOptionPane.ERROR_MESSAGE);
        } finally {
            if (scanner != null) {
                scanner.close();
            }
            if (pw != null) {
                pw.close();
            }
        }
        return clockList;
    }

}
