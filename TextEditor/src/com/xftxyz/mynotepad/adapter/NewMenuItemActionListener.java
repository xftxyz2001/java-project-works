package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.xftxyz.mynotepad.view.TextEditor;

public class NewMenuItemActionListener implements ActionListener {

    // private TextEditor editor;

    // public NewMenuItemActionListener(TextEditor te) {
    //     this.editor = te;
    // }

    @Override
    public void actionPerformed(ActionEvent e) {
        new TextEditor("无标题", null);
    }

}
