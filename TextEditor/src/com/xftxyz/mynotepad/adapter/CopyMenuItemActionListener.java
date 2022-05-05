package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.xftxyz.mynotepad.utils.ClipboardUtil;
import com.xftxyz.mynotepad.view.TextEditor;

public class CopyMenuItemActionListener implements ActionListener {

    private TextEditor editor;

    public CopyMenuItemActionListener(TextEditor te) {
        this.editor = te;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ClipboardUtil.setSystemClipboardText(editor.getTextArea().getText());
    }

}
