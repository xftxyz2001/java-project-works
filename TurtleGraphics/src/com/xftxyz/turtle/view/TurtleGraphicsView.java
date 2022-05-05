package com.xftxyz.turtle.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xftxyz.turtle.service.XFGlobal;

public class TurtleGraphicsView extends JFrame {
    private TurtleGraphicsJPanel panel;
    private JLabel lblHelp;

    // 画图状态（随指令运行而动态输出）
    private JLabel lblDrawingStatus;

    // 指令输入部分
    private JPanel panelCommand;
    private JLabel instructionJLabel;
    private JTextField instructionJTextField;
    private JLabel paceJLabel;
    private JTextField paceJTextField;

    // 指令
    private int instruction;

    // 构造函数
    public TurtleGraphicsView(String title) throws HeadlessException {
        super(title);
        // 设置窗口大小
        this.setSize(XFGlobal.WIDTH, XFGlobal.HEIGHT);
        // 点击窗口关闭按钮时，退出程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示帮助：程序使用说明
        lblHelp = new JLabel(XFGlobal.HELP_CONTENT);
        this.add(lblHelp, BorderLayout.WEST);

        // 画图状态（随指令运行而动态输出）
        lblDrawingStatus = new JLabel();
        lblDrawingStatus.setFont(new Font("宋体", Font.PLAIN, 30));
        this.add(this.lblDrawingStatus, BorderLayout.NORTH);

        // 添加指令输入部分
        instructionJLabel = new JLabel("指令：");
        instructionJTextField = new JTextField(10);

        paceJLabel = new JLabel("移动步数：");
        paceJTextField = new JTextField(10);
        paceJTextField.setEditable(false);

        panelCommand = new JPanel();
        panelCommand.add(instructionJLabel);
        panelCommand.add(instructionJTextField);
        panelCommand.add(paceJLabel);
        panelCommand.add(paceJTextField);
        this.add(panelCommand, BorderLayout.SOUTH);

        // 添加画布到窗口中间
        panel = new TurtleGraphicsJPanel(this);
        this.add(panel, BorderLayout.CENTER);

        // 添加文本框监听
        addTextFieldActionListener();

        // 设置窗口可见
        this.setVisible(true);

    }

    private void addTextFieldActionListener() {
        // 监听指令文本框，指令文本框内容改变时，更新指令
        instructionJTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // if (e.getSource()==instructionJTextField) {
                instruction = Integer.parseInt(instructionJTextField.getText());
                if (instruction == 5) {
                    paceJTextField.setEditable(true);
                    // 让步数输入框获取焦点
                    paceJTextField.requestFocusInWindow();
                    // 默认选中，方便用户直接输入
                    paceJTextField.selectAll();
                    lblDrawingStatus.setText("请输入移动步数：");
                } else {
                    panel.turtleBehaviour(instruction);
                    // 默认选中，方便用户直接输入
                    instructionJTextField.selectAll();
                    paceJTextField.setEditable(false);
                }
            }
        });

        // 监听移动步数文本框
        paceJTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.setPace(paceJTextField.getText());
                // 让指令输入框获取焦点
                instructionJTextField.requestFocusInWindow();
                // 默认选中，方便用户直接输入
                instructionJTextField.selectAll();
                // 如果是移动指令，先设置步长，再执行前移动作
                panel.turtleBehaviour(instruction);
            }

        });
    }

    public TurtleGraphicsView() {
    }

    public JTextField getInstructionJTextField() {
        return instructionJTextField;
    }

    public JTextField getPaceJTextField() {
        return paceJTextField;
    }

    public void setDrawingStatusText(String str) {
        lblDrawingStatus.setText(str);
    }

}
