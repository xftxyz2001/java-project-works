package com.xftxyz.crossword.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

import com.xftxyz.crossword.domain.Book;
import com.xftxyz.crossword.domain.XFConstant;

public class BookPanel extends JPanel {

    Book book = null;
    JLabel lAddBookName = new JLabel("填书名");
    JLabel lAddRoleName = new JLabel("填人名");
    WordOrSpace panelBook = new WordOrSpace();
    WordOrSpace[] panelRoles = new WordOrSpace[XFConstant.ROLE_CHOOSE_NUMBER];

    public Book getBook() {
        return book;
    }

    public WordOrSpace getPanelBook() {
        return panelBook;
    }

    public void setPanelBook(WordOrSpace panelBook) {
        this.panelBook = panelBook;
    }

    public WordOrSpace[] getPanelRoles() {
        return panelRoles;
    }

    public void setPanelRoles(WordOrSpace[] panelRoles) {
        this.panelRoles = panelRoles;
    }

    public BookPanel() {
        this.setLayout(new GridLayout(6, 1));
        JPanel plAddBookName = new JPanel();
        lAddBookName.setFont(new FontUIResource("楷体", FontUIResource.PLAIN, 50));
        plAddBookName.add(lAddBookName);
        JPanel plAddRoleName = new JPanel();
        lAddRoleName.setFont(new FontUIResource("楷体", FontUIResource.PLAIN, 50));
        plAddRoleName.add(lAddRoleName);
        this.add(plAddBookName);
        this.add(panelBook);
        this.add(plAddRoleName);
        for (int i = 0; i < panelRoles.length; i++) {
            panelRoles[i] = new WordOrSpace();
            this.add(panelRoles[i]);
        }
    }

    public void setBook(Book book) {
        this.book = book;
        panelBook.removeAll();
        panelBook.setWord(book.getBookName(), true);

        String[] rolesName = book.getRoles();
        ArrayList<String> rolesList = new ArrayList<String>();
        for (String roleName : rolesName) {
            rolesList.add(roleName);
        }
        for (int i = rolesList.size(); i > XFConstant.ROLE_CHOOSE_NUMBER; i--) {
            rolesList.remove((int) (Math.random() * i));
        }

        String[] rolesNameRand = new String[rolesList.size()];
        rolesList.toArray(rolesNameRand);

        for (int i = 0; i < panelRoles.length; i++) {
            panelRoles[i].removeAll();
            panelRoles[i].setWord(rolesNameRand[i], false);
        }

        this.updateUI();
        // repaint();
    }

}