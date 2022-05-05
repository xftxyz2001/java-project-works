package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

public class AboutHelpMenuActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // 关于
        JOptionPane.showMessageDialog(null, "简易文本编辑器\n\t\t庞晓宇\n\t\t2020118100", "关于", JOptionPane.INFORMATION_MESSAGE);
    }

}
