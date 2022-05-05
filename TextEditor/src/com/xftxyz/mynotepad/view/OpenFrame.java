package com.xftxyz.mynotepad.view;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xftxyz.mynotepad.adapter.OpenButtonActionListener;

public class OpenFrame extends JFrame {

    private JPanel panelTop = new JPanel();
    private JPanel panelBut = new JPanel();
    private JTextField textFilePathName = new JTextField(18);
    private JButton OpenButton = new JButton("打开文件");

    public JTextField getTextFilePathName() {
        return textFilePathName;
    }

    public OpenFrame(TextEditor editor) {
        super("打开");
        this.setLocationRelativeTo(null);
        // oframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setSize(300, 150);
        Box vbox = Box.createVerticalBox();
        panelTop.add(new JLabel("文件路径："));
        panelTop.add(textFilePathName);
        panelBut.add(OpenButton);

        vbox.add(panelTop);
        vbox.add(panelBut);
        this.add(vbox);
        OpenButton.addActionListener(new OpenButtonActionListener(editor, this));

        this.addWindowListener(new WindowAdapter() {
            @SuppressWarnings("unused")
            public void WindowClosing(WindowEvent e) {
                OpenFrame.this.dispose();
            }
        });
        this.setVisible(true);
    }

}
