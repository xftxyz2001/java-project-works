package com.xftxyz.crossword.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.plaf.FontUIResource;

import com.xftxyz.crossword.domain.Book;
import com.xftxyz.crossword.service.JudgeButtonAdapter;
import com.xftxyz.crossword.utils.BookUtil;
import com.xftxyz.crossword.utils.MyFileReader;

public class GameMain extends JFrame {

    private BookPanel bookPanel = new BookPanel();
    private JLabel titleLabel = new JLabel("填字游戏");
    private JButton btnJudge = new JButton("判断正误");
    private JButton btnReStart = new JButton("重新开始");
    private Book[] books = null;
    private int score = 0;
    private int hp = 3;

    public BookPanel getBookPanel() {
        return bookPanel;
    }

    public void setBookPanel(BookPanel bookPanel) {
        this.bookPanel = bookPanel;
    }

    public JLabel getTitleLabel() {
        return titleLabel;
    }

    public void setTitleLabel(JLabel titleLabel) {
        this.titleLabel = titleLabel;
    }

    public JButton getBtnJudge() {
        return btnJudge;
    }

    public void setBtnJudge(JButton btnJudge) {
        this.btnJudge = btnJudge;
    }

    public JButton getBtnReStart() {
        return btnReStart;
    }

    public void setBtnReStart(JButton btnReStart) {
        this.btnReStart = btnReStart;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public GameMain() {

        // 两个按钮
        JPanel panelButtons = new JPanel();
        panelButtons.setLayout(new FlowLayout());
        panelButtons.add(btnJudge);
        panelButtons.add(btnReStart);
        JPanel panelTitle = new JPanel();
        titleLabel.setFont(new FontUIResource("楷体", FontUIResource.PLAIN, 80));
        panelTitle.add(titleLabel);

        Container container = this.getContentPane();
        container.setLayout(new BorderLayout());
        container.add(panelTitle, BorderLayout.NORTH);
        container.add(bookPanel, BorderLayout.CENTER);
        container.add(panelButtons, BorderLayout.SOUTH);

        this.setTitle("填字游戏");
        this.setVisible(true);
        // void java.awt.Window.setBounds(int x, int y, int width, int height)
        this.setBounds(100, 100, 500, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        books = MyFileReader.read();
        System.out.println(System.currentTimeMillis() + "初始化数据文件成功");

        // btnJudge.addMouseListener(new JudgeButtonAdapter(this));

        btnReStart.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(System.currentTimeMillis() + "重新开始");
                reStart();
                // repaint();
            }

        });
    }

    public void reStart() {
        bookPanel.setBook(BookUtil.getBookFromBooks(books));
        score = 0;
        hp = 3;
        btnJudge.setEnabled(true);
        if (btnJudge.getMouseListeners().length == 1) {
            btnJudge.addMouseListener(new JudgeButtonAdapter(this));
        }
    }

}
