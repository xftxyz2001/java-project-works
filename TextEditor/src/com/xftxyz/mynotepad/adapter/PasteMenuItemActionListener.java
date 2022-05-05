package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.xftxyz.mynotepad.utils.ClipboardUtil;
import com.xftxyz.mynotepad.view.TextEditor;

public class PasteMenuItemActionListener implements ActionListener {
    private TextEditor editor;

    public PasteMenuItemActionListener(TextEditor te) {
        this.editor = te;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        editor.getTextArea().setText(editor.getTextArea().getText() + ClipboardUtil.getSystemClipboardText());

    }

}
