package com.xftxyz.mynotepad.view;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.xftxyz.mynotepad.menu.XFMenuBar;
import com.xftxyz.mynotepad.service.XFGlobal;

public class TextEditor extends JFrame {

    private File file;
    // 文本框
    private JTextArea textArea;
    // 滚动条
    private JScrollPane jsPane;

    // 构造方法
    public TextEditor() {

    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public TextEditor(String title, String res) {
        // 初始化JFrame，设置窗体大小、标题
        super(title);
        this.setSize(XFGlobal.WIDTH, XFGlobal.HEIGHT);
        this.setLocationRelativeTo(null);
        // 点击关闭按钮关闭窗口
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // 初始化文本框、设置文本框初始内容
        textArea = new JTextArea();
        textArea.setText(res);
        textArea.setLineWrap(true);
        // 包装文本框
        jsPane = new JScrollPane(textArea);
        // 将文本框和菜单添加到窗体
        this.add(jsPane);
        // this.setJMenuBar(new XFMenuBar());
        this.setJMenuBar(new XFMenuBar(this));
        // 可视
        this.setVisible(true);
    }

    public JTextArea getTextArea() {
        return textArea;
    }

}
