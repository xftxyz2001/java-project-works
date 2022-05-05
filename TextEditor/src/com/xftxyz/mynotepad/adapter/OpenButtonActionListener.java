package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.xftxyz.mynotepad.utils.XFFileUtil;
import com.xftxyz.mynotepad.view.OpenFrame;
import com.xftxyz.mynotepad.view.TextEditor;

public class OpenButtonActionListener implements ActionListener {

    private TextEditor editor;
    private OpenFrame openFrame;

    public OpenButtonActionListener(TextEditor editor, OpenFrame openFrame) {
        this.editor = editor;
        this.openFrame = openFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = XFFileUtil.ReadFile(openFrame.getTextFilePathName().getText());
        editor.getTextArea().setText(s);
        openFrame.dispose();

    }

}
