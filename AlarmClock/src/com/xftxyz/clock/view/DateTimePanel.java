package com.xftxyz.clock.view;

import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.xftxyz.clock.domain.ClockEventItem;
import com.xftxyz.clock.service.XFGlobal;

public class DateTimePanel extends JPanel {

    private LocalDateTime localDateTime;
    private JLabel lbDate;
    private JLabel lbTime;
    private JLabel lbAbout;

    public DateTimePanel(ClockListPanel clockListPanel) {
        // 布局上中下三部分
        this.setLayout(new GridLayout(3, 1));
        localDateTime = LocalDateTime.now();
        lbDate = new JLabel(localDateTime.format(XFGlobal.DATE_FORMAT));
        lbDate.setFont(XFGlobal.DATE_FONT);
        lbTime = new JLabel(localDateTime.format(XFGlobal.TIME_FORMAT));
        lbTime.setFont(XFGlobal.TIME_FONT);
        lbAbout = new JLabel(XFGlobal.ABOUT_CONTENT);
        this.add(lbDate);
        this.add(lbTime);
        this.add(lbAbout);

        // 得到事件集合
        Vector<ClockEventItem> clockList = clockListPanel.getClockList();
        // 循环检查事件
        for (ClockEventItem clockEventItem : clockList) {
            // 如果事件未触发
            if (clockEventItem.isPlaySound() && clockEventItem.getEventTime().compareTo(localDateTime) <= 0) {
                // 提示事件
                JOptionPane.showMessageDialog(clockListPanel,
                        clockEventItem.getEventTime().format(XFGlobal.DATE_TIME_FORMAT) + "\n"
                                + clockEventItem.getEvent(),
                        "已过期事件提醒", JOptionPane.INFORMATION_MESSAGE);
                clockListPanel.getEventsTableModel().fireTableDataChanged();
                // 将事件设置为已触发
                clockEventItem.setPlaySound(false);
            }
        }

        new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    // 每秒更新一次时间
                    localDateTime = LocalDateTime.now();
                    // 将时间更新到面板上
                    lbDate.setText(localDateTime.format(XFGlobal.DATE_FORMAT));
                    lbTime.setText(localDateTime.format(XFGlobal.TIME_FORMAT));

                    // 得到事件集合
                    Vector<ClockEventItem> clockList = clockListPanel.getClockList();
                    // 循环检查事件
                    for (ClockEventItem clockEventItem : clockList) {
                        // 如果事件未触发
                        if (clockEventItem.isPlaySound()
                                && clockEventItem.getEventTime().compareTo(localDateTime) <= 0) {
                            // 提示事件
                            JOptionPane.showMessageDialog(clockListPanel,
                                    clockEventItem.getEventTime().format(XFGlobal.DATE_TIME_FORMAT) + "\n"
                                            + clockEventItem.getEvent(),
                                    "提醒", JOptionPane.INFORMATION_MESSAGE);
                            clockListPanel.getEventsTableModel().fireTableDataChanged();
                            // 将事件设置为已触发
                            clockEventItem.setPlaySound(false);
                        }
                    }
                    // repaint();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }

        }).start();
    }

}
