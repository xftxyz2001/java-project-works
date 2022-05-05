package com.xftxyz.clock.view;

import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.xftxyz.clock.service.XFGlobal;
import com.xftxyz.clock.utils.XFFileUtil;

public class AlarmClockView extends JFrame {

    private DateTimePanel dateTimePanel;
    private ClockListPanel clockListPanel;

    public AlarmClockView(String title) throws HeadlessException {
        super(title);
        this.setSize(XFGlobal.WIDTH, XFGlobal.HEIGHT);
        this.setLocationRelativeTo(null);
        // 点击关闭按钮先什么都不做
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 布局左右两部分
        this.setLayout(new GridLayout(1, 2));
        // 先将右边的部分创建好
        clockListPanel = new ClockListPanel(this);
        // 再将左边的部分创建好，并将右边的部分添加进去，以便左边的部分可以控制右边的部分
        dateTimePanel = new DateTimePanel(clockListPanel);
        this.add(dateTimePanel);
        this.add(clockListPanel);

        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(null, "确认退出?", "确认", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    // 退出
                    XFFileUtil.saveClockList(clockListPanel.getClockList());
                    System.exit(0);
                }
            }
        });
    }

    public AlarmClockView() {
    }

}
