package com.xftxyz.crossword.service;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;

import com.xftxyz.crossword.utils.BookUtil;
import com.xftxyz.crossword.view.GameMain;
import com.xftxyz.crossword.view.WordOrSpace;

public class JudgeButtonAdapter extends MouseAdapter {

    private GameMain This;

    public JudgeButtonAdapter(GameMain ga) {
        this.This = ga;
    }

    public GameMain getThis() {
        return This;
    }

    public void setThis(GameMain this1) {
        This = this1;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        System.out.println(System.currentTimeMillis() + "判断正误，用户输入：");
        boolean isAnswer = BookUtil.judgeAnswer(This.getBookPanel().getPanelBook());
        for (WordOrSpace wos : This.getBookPanel().getPanelRoles()) {
            if (isAnswer) {
                isAnswer = BookUtil.judgeAnswer(wos);
            } else {
                BookUtil.judgeAnswer(wos);
            }
        }
        if (isAnswer) {
            This.setScore(This.getScore() + 1);
            JOptionPane.showMessageDialog(null, "恭喜您回答正确，当前得分为：" + This.getScore(), "回答正确", JOptionPane.DEFAULT_OPTION);
            This.setHp(3);
            This.getBookPanel().setBook(BookUtil.getBookFromBooks(This.getBooks()));
        } else {
            This.setHp(This.getHp() - 1);
            if (This.getHp() <= 0) {
                JOptionPane.showMessageDialog(null, "正确答案为：" + This.getBookPanel().getBook(), "游戏结束",
                        JOptionPane.DEFAULT_OPTION);

                JOptionPane.showMessageDialog(null, "游戏结束，最终得分为：" + This.getScore(), "游戏结束",
                        JOptionPane.DEFAULT_OPTION);
                // btnJudge.disable();
                This.getBtnJudge().setEnabled(false);
                This.getBtnJudge().removeMouseListener(this);
            } else {
                // 答案错误，你还有机会
                JOptionPane.showMessageDialog(null, "回答错误，您还有" + This.getHp() + "次机会", "回答错误",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        System.out.println(System.currentTimeMillis() + "当前分数：" + This.getScore() + " 当前机会：" + This.getHp());

    }

}
