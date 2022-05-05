package com.xftxyz.mynotepad.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.xftxyz.mynotepad.adapter.ExitMenuItemActionListener;
import com.xftxyz.mynotepad.adapter.NewMenuItemActionListener;
import com.xftxyz.mynotepad.adapter.OpenMenuItemActionListener;
import com.xftxyz.mynotepad.adapter.SaveAsMenuItemActionListener;
import com.xftxyz.mynotepad.adapter.SaveMenuItemActionListener;
import com.xftxyz.mynotepad.view.TextEditor;

public class XFFileMenu extends JMenu {

    private JMenuItem newMenuItem = new JMenuItem("新建");
    private JMenuItem openMenuItem = new JMenuItem("打开");
    private JMenuItem saveMenuItem = new JMenuItem("保存");
    private JMenuItem saveAsMenuItem = new JMenuItem("另存为");
    private JMenuItem exitMenuItem = new JMenuItem("退出");

    public XFFileMenu() {
    }

    public XFFileMenu(String s, TextEditor te) {
        super(s);

        this.add(newMenuItem);
        this.add(openMenuItem);
        this.addSeparator();
        this.add(saveMenuItem);
        this.add(saveAsMenuItem);
        this.addSeparator();
        this.add(exitMenuItem);

        // 添加监听
        // newMenuItem.addActionListener(new NewMenuItemActionListener(te));
        newMenuItem.addActionListener(new NewMenuItemActionListener());
        openMenuItem.addActionListener(new OpenMenuItemActionListener(te));
        saveMenuItem.addActionListener(new SaveMenuItemActionListener(te));

        saveAsMenuItem.addActionListener(new SaveAsMenuItemActionListener(te));
        exitMenuItem.addActionListener(new ExitMenuItemActionListener(te));

    }
}
