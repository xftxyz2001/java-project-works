package com.xftxyz.clock.view;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.xftxyz.clock.domain.ClockEventItem;
import com.xftxyz.clock.service.XFGlobal;

public class ClockEventDialog extends JDialog {

    private JPanel mainPanel;

    private JPanel panelTime;
    private JLabel lblTime;
    private JTextField time;

    private JPanel panelMessage;
    private JLabel lblMessage;
    private JTextField message;

    private JPanel panelButton;
    private JButton btnOK;
    private JButton btnCancel;

    private boolean ok = false;

    public ClockEventDialog(Frame owner, String title, boolean modal) {
        super(owner, title, modal);
        this.setSize(XFGlobal.WIDTH - 200, XFGlobal.HEIGHT / 2);
        this.setLocationRelativeTo(null);
        this.lblTime = new JLabel("时间：");
        this.time = new JTextField(50);
        this.time.setText(LocalDateTime.now().format(XFGlobal.DATE_TIME_FORMAT));
        this.panelTime = new JPanel();
        this.panelTime.add(this.lblTime);
        this.panelTime.add(this.time);
        // this.add(this.panelTime);

        this.lblMessage = new JLabel("事件：");
        this.message = new JTextField(50);
        this.message.setText("闹钟");
        this.panelMessage = new JPanel();
        this.panelMessage.add(this.lblMessage);
        this.panelMessage.add(this.message);
        // this.add(this.panelMessage);

        this.btnOK = new JButton("确定");
        this.btnOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ok = true;
                ClockEventDialog.this.dispose();
            }
        });
        this.btnCancel = new JButton("取消");
        this.btnCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ok = false;
                ClockEventDialog.this.dispose();
            }
        });

        this.panelButton = new JPanel();
        this.panelButton.add(this.btnOK);
        this.panelButton.add(this.btnCancel);
        // this.add(this.panelButton);

        this.mainPanel = new JPanel();
        this.mainPanel.add(this.panelTime);
        this.mainPanel.add(this.panelMessage);
        this.mainPanel.add(this.panelButton);
        this.add(this.mainPanel);
        this.setVisible(true);

    }

    public ClockEventItem getClockEventItem() {
        try {
            String timeStr = this.time.getText();
            // LocalDateTime time = (LocalDateTime)
            // XFGlobal.DATE_TIME_FORMAT.parse(timeStr);
            LocalDateTime time = LocalDateTime.parse(timeStr, XFGlobal.DATE_TIME_FORMAT);
            String messageStr = this.message.getText();
            ClockEventItem item = new ClockEventItem(time, messageStr, true);
            return item;
        } catch (DateTimeParseException e) {
            return null;
        }

    }

    public boolean isOK() {
        return this.ok;
    }

}
