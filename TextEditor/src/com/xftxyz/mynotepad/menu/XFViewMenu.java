package com.xftxyz.mynotepad.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.xftxyz.mynotepad.adapter.StatisticsMenuItemActionListener;
import com.xftxyz.mynotepad.view.TextEditor;

public class XFViewMenu extends JMenu {
    private JMenuItem statisticsMenuItem = new JMenuItem("统计");

    public XFViewMenu() {
    }

    public XFViewMenu(String s, TextEditor te) {
        super(s);
        this.add(statisticsMenuItem);

        statisticsMenuItem.addActionListener(new StatisticsMenuItemActionListener(te));

    }

}
