package com.xftxyz.clock.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import com.xftxyz.clock.domain.ClockEventItem;

public class ClockListPanel extends JPanel {

    private JButton btnAddClock;
    private JButton btnRemoveClock;
    private JPanel btnPanel;
    private ClockEventDialog dialog;
    // 闹钟事件表格
    private JTable clockEventsTable;
    private EventsTableModel tbModelEvents;

    public ClockListPanel(AlarmClockView alarmClockView) {
        // 布局上下两部分
        this.setLayout(new BorderLayout());

        // 初始化按钮
        this.btnAddClock = new JButton("添加闹钟");
        this.btnRemoveClock = new JButton("删除闹钟");

        // 为按钮添加事件监听器
        this.btnAddClock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                // 自定义一个对话框
                dialog = new ClockEventDialog(alarmClockView, "添加闹钟", true);
                // 显示对话框
                // dialog.setVisible(true);
                if (dialog.isOK()) {
                    // 如果对话框的确定按钮被点击，则添加闹钟事件
                    ClockEventItem clockEventItem = dialog.getClockEventItem();
                    if (clockEventItem != null) {
                        tbModelEvents.addClockEventItem(clockEventItem);
                    } else {
                        JOptionPane.showMessageDialog(null, "输入的日期时间格式有误", "错误", JOptionPane.ERROR_MESSAGE);
                    }
                }

            }

        });

        this.btnRemoveClock.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = clockEventsTable.getSelectedRow();
                if (selectedRow == -1) {
                    // 提示用户需要选择一个闹钟
                    JOptionPane.showMessageDialog(null, "请选择一项", "提示", JOptionPane.INFORMATION_MESSAGE);
                    return;
                }
                int result = JOptionPane.showConfirmDialog(null, "确认删除?", "删除", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE);
                if (result == JOptionPane.OK_OPTION) {
                    // 删除选中的行
                    tbModelEvents.removeClockEventItem(selectedRow);
                }
            }

        });

        // 初始化按钮面板
        this.btnPanel = new JPanel();
        // 按钮面板添加按钮
        this.btnPanel.add(this.btnAddClock);
        this.btnPanel.add(this.btnRemoveClock);
        // 按钮面板添加到面板
        this.add(btnPanel, BorderLayout.NORTH);

        this.tbModelEvents = new EventsTableModel();
        this.clockEventsTable = new JTable(tbModelEvents);
        // 设置表格单行选中
        this.clockEventsTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        // 设置表格列宽
        Vector<String> columnNames = this.tbModelEvents.getColumnNames();
        this.clockEventsTable.getColumn(columnNames.get(0)).setMinWidth(140);
        this.clockEventsTable.getColumn(columnNames.get(1)).setMinWidth(100);
        this.clockEventsTable.getColumn(columnNames.get(2)).setMinWidth(38);
        this.clockEventsTable.getColumn(columnNames.get(2)).setMaxWidth(50);
        // 设置表头不可拖动
        this.clockEventsTable.getTableHeader().setReorderingAllowed(false);

        // 添加滚动条
        this.add(new JScrollPane(clockEventsTable), BorderLayout.CENTER);
    }

    public EventsTableModel getEventsTableModel() {
        return this.tbModelEvents;
    }

    public Vector<ClockEventItem> getClockList() {
        return this.tbModelEvents.getEvents();
    }
}
