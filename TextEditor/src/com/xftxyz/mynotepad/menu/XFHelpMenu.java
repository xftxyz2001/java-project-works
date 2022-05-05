package com.xftxyz.mynotepad.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.xftxyz.mynotepad.adapter.AboutHelpMenuActionListener;
import com.xftxyz.mynotepad.adapter.ViewHelpMenuItemActionListener;
import com.xftxyz.mynotepad.view.TextEditor;

public class XFHelpMenu extends JMenu {
    private JMenuItem viewHelpMenuItem = new JMenuItem("查看帮助");
    private JMenuItem aboutHelpMenuItem = new JMenuItem("关于作者");

    public XFHelpMenu() {
    }

    public XFHelpMenu(String s, TextEditor te) {
        super(s);
        this.add(viewHelpMenuItem);
        this.addSeparator();
        this.add(aboutHelpMenuItem);

        viewHelpMenuItem.addActionListener(new ViewHelpMenuItemActionListener());
        aboutHelpMenuItem.addActionListener(new AboutHelpMenuActionListener());
    }

}
