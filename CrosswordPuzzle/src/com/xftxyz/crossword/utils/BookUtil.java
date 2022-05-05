package com.xftxyz.crossword.utils;

import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JTextField;

import com.xftxyz.crossword.domain.Book;
import com.xftxyz.crossword.view.WordOrSpace;

public class BookUtil {
    public static Book getBookFromBooks(Book[] books) {
        return books[(int) (Math.random() * books.length)];
    }

    public static int[] getSortedRands(int numBooks) {
        int[] rands = new int[numBooks / 2];
        int count = 0;
        while (count < rands.length) {
            int rand = (int) (Math.random() * numBooks);
            boolean isHas = false;
            for (int i = 0; i < count; i++) {
                if (rands[i] == rand) {
                    isHas = true;
                }
            }
            if (isHas) {
                continue;
            } else {
                rands[count++] = rand;
            }
        }
        Arrays.sort(rands);
        return rands;

    }

    public static boolean judgeAnswer(WordOrSpace wos) {
        ArrayList<String> inWords = new ArrayList<String>();
        for (Component c : wos.getLabels()) {
            if (c instanceof JLabel j) {
                inWords.add(j.getText());
            } else if (c instanceof JTextField j) {
                inWords.add(j.getText());
            }

        }
        System.out.println(System.currentTimeMillis() + "" + inWords);
        ArrayList<String> words = wos.getWords();
        boolean isAnswer = true;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).equals(inWords.get(i))) {
                wos.getLabels().get(i).setBackground(Color.WHITE);
                continue;
            } else {
                isAnswer = false;
                // break;
                wos.getLabels().get(i).setBackground(Color.RED);
            }
        }
        return isAnswer;
    }
}
