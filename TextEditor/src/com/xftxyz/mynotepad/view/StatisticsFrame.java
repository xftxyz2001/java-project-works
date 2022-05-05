package com.xftxyz.mynotepad.view;

import java.awt.HeadlessException;
import java.awt.GridLayout;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import com.xftxyz.mynotepad.service.XFGlobal;

public class StatisticsFrame extends JFrame {

    private int alphaCount;
    private int digitCount;
    private int otherCount;

    public StatisticsFrame(String title, String s) throws HeadlessException {
        super(title);
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i)))
                digitCount++;
            else if (Character.isAlphabetic(s.charAt(i)))
                alphaCount++;
            else
                otherCount++;
        }
        this.setSize(XFGlobal.STATISTICS_WIDTH, XFGlobal.STATISTICS_HEIGHT);
        // sframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1));
        this.setLocationRelativeTo(null);

        JLabel alpha = new JLabel("   字母: " + alphaCount);
        JLabel digit = new JLabel("   数字: " + digitCount);
        JLabel other = new JLabel("   其他: " + otherCount);
        this.add(alpha);
        this.add(digit);
        this.add(other);

        this.addWindowListener(new WindowAdapter() {
            @SuppressWarnings("unused")
            public void WindowClosing(WindowEvent e) {
                StatisticsFrame.this.dispose();
            }
        });
        this.setVisible(true);
    }

    public StatisticsFrame() {
    }

}
