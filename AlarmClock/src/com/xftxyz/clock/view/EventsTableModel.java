package com.xftxyz.clock.view;

import java.util.Comparator;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.xftxyz.clock.domain.ClockEventItem;
import com.xftxyz.clock.service.XFGlobal;
import com.xftxyz.clock.utils.XFFileUtil;

public class EventsTableModel extends AbstractTableModel {

    private Vector<String> columnNames = new Vector<String>();
    private Vector<ClockEventItem> event = new Vector<ClockEventItem>();

    public EventsTableModel() {
        columnNames.add("时间");
        columnNames.add("事件");
        columnNames.add("响铃");

        event = XFFileUtil.loadClockList();
        event.sort(new Comparator<ClockEventItem>() {

            @Override
            public int compare(ClockEventItem o1, ClockEventItem o2) {
                return o1.compareTo(o2);
            }

        });

    }

    public Vector<String> getColumnNames() {
        return columnNames;
    }

    @Override
    public int getRowCount() {
        return event.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.size();
    }

    @Override
    public String getColumnName(int column) {
        return columnNames.get(column);
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        ClockEventItem item = event.get(rowIndex);
        switch (columnIndex) {
        case 0:
            return item.getEventTime().format(XFGlobal.DATE_TIME_FORMAT);
        case 1:
            return item.getEvent();
        case 2:
            return item.isPlaySound();
        default:
            return null;
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public Vector<ClockEventItem> getEvents() {
        return event;
    }

    public void addClockEventItem(ClockEventItem cei) {
        event.add(cei);
        event.sort(new Comparator<ClockEventItem>() {

            @Override
            public int compare(ClockEventItem o1, ClockEventItem o2) {
                return o1.compareTo(o2);
            }

        });
        this.fireTableDataChanged();
    }

    public void removeClockEventItem(int selectedRow) {
        event.remove(selectedRow);
        this.fireTableDataChanged();
    }

}
