package com.xftxyz.mynotepad.adapter;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.plaf.FontUIResource;

import com.xftxyz.mynotepad.view.TextEditor;

public class AddFontSizeMenuItemActionListener implements ActionListener {

    private TextEditor editor;

    public AddFontSizeMenuItemActionListener(TextEditor te) {
        this.editor = te;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Font font = editor.getTextArea().getFont();
        FontUIResource newFont = new FontUIResource(font.getFontName(), font.getStyle(), font.getSize() + 1);
        editor.getTextArea().setFont(newFont);
        // editor.repaint();

    }

}
