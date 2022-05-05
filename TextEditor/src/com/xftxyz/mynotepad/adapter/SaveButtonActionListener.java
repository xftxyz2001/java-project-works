package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.xftxyz.mynotepad.utils.XFFileUtil;
import com.xftxyz.mynotepad.view.SaveFrame;
import com.xftxyz.mynotepad.view.TextEditor;

public class SaveButtonActionListener implements ActionListener {

    private TextEditor editor;
    private SaveFrame saveFrame;

    public SaveButtonActionListener(TextEditor editor, SaveFrame saveFrame) {
        this.editor = editor;
        this.saveFrame = saveFrame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        XFFileUtil.SaveFile(saveFrame.getTextFilePath().getText(), saveFrame.getTextFileName().getText(),
                editor.getTextArea().getText());
        saveFrame.dispose();
    }

}
