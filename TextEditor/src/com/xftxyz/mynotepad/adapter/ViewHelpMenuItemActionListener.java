package com.xftxyz.mynotepad.adapter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import com.xftxyz.mynotepad.service.XFGlobal;
import com.xftxyz.mynotepad.view.TextEditor;

public class ViewHelpMenuItemActionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        new TextEditor("帮助", XFGlobal.HELP_CONTENT);

    }

}
