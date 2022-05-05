package com.xftxyz.mynotepad.view;

import java.awt.HeadlessException;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xftxyz.mynotepad.adapter.SaveButtonActionListener;

public class SaveFrame extends JFrame {

    private JPanel panelTop = new JPanel();
    private JPanel panelMid = new JPanel();
    private JPanel panelBut = new JPanel();
    private JTextField textFilePath = new JTextField(18);
    private JTextField textFileName = new JTextField(18);
    private JButton SaveButton = new JButton("保存");

    public SaveFrame(String title) throws HeadlessException {
        super(title);
    }

    public JTextField getTextFilePath() {
        return textFilePath;
    }

    public JTextField getTextFileName() {
        return textFileName;
    }

    public SaveFrame(TextEditor editor) {
        super("另存为");
        // iframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLocationRelativeTo(null);

        this.setSize(300, 200);
        Box vbox = Box.createVerticalBox();
        panelTop.add(new JLabel("文件路径："));
        panelTop.add(textFilePath);
        panelMid.add(new JLabel("文 件 名："));
        panelMid.add(textFileName);
        panelBut.add(SaveButton);

        vbox.add(panelTop);
        vbox.add(panelMid);
        vbox.add(panelBut);
        this.add(vbox);

        SaveButton.addActionListener(new SaveButtonActionListener(editor, this));

        this.addWindowListener(new WindowAdapter() {
            @SuppressWarnings("unused")
            public void WindowClosing(WindowEvent e) {
                SaveFrame.this.dispose();
            }
        });
        this.setVisible(true);
    }

}
