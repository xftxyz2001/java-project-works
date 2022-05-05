package com.xftxyz.mynotepad.menu;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import com.xftxyz.mynotepad.adapter.AddFontSizeMenuItemActionListener;
import com.xftxyz.mynotepad.adapter.CopyMenuItemActionListener;
import com.xftxyz.mynotepad.adapter.PasteMenuItemActionListener;
import com.xftxyz.mynotepad.adapter.SubFontSizeMenuItemActionListener;
import com.xftxyz.mynotepad.view.TextEditor;

public class XFEditMenu extends JMenu {
    private JMenuItem copyMenuItem = new JMenuItem("复制");
    private JMenuItem pasteMenuItem = new JMenuItem("粘贴");
    private JMenuItem addFontSizeMenuItem = new JMenuItem("增大字号");
    private JMenuItem subFontSizeMenuItem = new JMenuItem("减小字号");

    public XFEditMenu() {
    }

    public XFEditMenu(String s, TextEditor te) {
        super(s);
        this.add(copyMenuItem);
        this.add(pasteMenuItem);
        this.addSeparator();
        this.add(addFontSizeMenuItem);
        this.add(subFontSizeMenuItem);

        copyMenuItem.addActionListener(new CopyMenuItemActionListener(te));
        pasteMenuItem.addActionListener(new PasteMenuItemActionListener(te));
        addFontSizeMenuItem.addActionListener(new AddFontSizeMenuItemActionListener(te));
        subFontSizeMenuItem.addActionListener(new SubFontSizeMenuItemActionListener(te));
    }

}
