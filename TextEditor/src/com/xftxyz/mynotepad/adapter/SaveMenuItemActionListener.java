package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;

import com.xftxyz.mynotepad.utils.XFFileUtil;
import com.xftxyz.mynotepad.view.TextEditor;

public class SaveMenuItemActionListener implements ActionListener {

    private TextEditor editor;

    public SaveMenuItemActionListener(TextEditor te) {
        this.editor = te;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // editor.SaveFile(XFGlobal.WORKSPACE, XFGlobal.BOOK_NAME,
        // editor.getTextArea().getText());
        if (editor.getFile() != null) {
            XFFileUtil.SaveFile(editor.getFile(), editor.getTextArea().getText());
        } else {
            JFileChooser fileChoose = new JFileChooser(); // 创建文件对话框
            // fileChoose.setFileFilter(new FileNameExtensionFilter("java文件", "java"));

            int result = fileChoose.showSaveDialog(null); // 显示文件对话框

            if (result == JFileChooser.APPROVE_OPTION) {
                // this.textshow.setText(null); // 设置文本区内容为空
                File file = new File(fileChoose.getSelectedFile().getAbsolutePath());
                editor.setFile(file);
                editor.setTitle(file.toString());
                String content = editor.getTextArea().getText();
                XFFileUtil.SaveFile(file, content);

            }
        }
    }

}
