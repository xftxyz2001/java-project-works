package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.xftxyz.mynotepad.view.StatisticsFrame;
import com.xftxyz.mynotepad.view.TextEditor;

public class StatisticsMenuItemActionListener implements ActionListener {

    private TextEditor editor;

    public StatisticsMenuItemActionListener(TextEditor te) {
        this.editor = te;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new StatisticsFrame("统计", editor.getTextArea().getText());
    }

}
