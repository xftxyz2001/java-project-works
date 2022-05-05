package com.xftxyz.mynotepad.menu;

import javax.swing.JMenuBar;

import com.xftxyz.mynotepad.view.TextEditor;

public class XFMenuBar extends JMenuBar {
    public XFMenuBar(TextEditor te) {
        // 添加一级菜单
        this.add(new XFFileMenu("文件", te));
        this.add(new XFEditMenu("编辑", te));
        this.add(new XFViewMenu("视图", te));
        this.add(new XFHelpMenu("帮助", te));

    }

}
