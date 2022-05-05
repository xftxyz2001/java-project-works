package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.xftxyz.mynotepad.view.TextEditor;

public class ExitMenuItemActionListener implements ActionListener {

    private TextEditor editor;

    public ExitMenuItemActionListener(TextEditor te) {
        this.editor = te;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        editor.dispose();

    }

}
