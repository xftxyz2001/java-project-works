package com.xftxyz.crossword.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.plaf.FontUIResource;

import com.xftxyz.crossword.utils.BookUtil;

public class WordOrSpace extends JPanel {
    ArrayList<Component> labels = new ArrayList<Component>();
    ArrayList<String> words = new ArrayList<String>();
    ArrayList<Boolean> isSpace = new ArrayList<Boolean>();

    public WordOrSpace() {
    }

    public ArrayList<Component> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<Component> labels) {
        this.labels = labels;
    }

    public ArrayList<String> getWords() {
        return words;
    }

    public void setWords(ArrayList<String> words) {
        this.words = words;
    }

    public ArrayList<Boolean> getIsSpace() {
        return isSpace;
    }

    public void setIsSpace(ArrayList<Boolean> isSpace) {
        this.isSpace = isSpace;
    }

    public void setWord(String word, boolean isBook) {
        words.clear();
        isSpace.clear();
        labels.clear();

        char[] charArray = word.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            words.add("" + charArray[i]);
        }

        if (isBook) {
            int[] rands = BookUtil.getSortedRands(charArray.length);
            System.out.println(System.currentTimeMillis() + "挖空坐标：" + Arrays.toString(rands));
            for (int i = 0, j = 0; i < charArray.length; i++) {
                if (j < rands.length && i == rands[j]) {
                    // if (i == rands[j]) {
                    // isSpace.add(true);
                    // j++;
                    // }
                    isSpace.add(true);
                    j++;
                } else {
                    isSpace.add(false);
                }
            }
        } else {
            int rand = (int) (Math.random() * word.length());
            for (int i = 0; i < charArray.length; i++) {
                isSpace.add(i != rand);
            }
        }
        System.out.println(System.currentTimeMillis() + "" + words);
        System.out.println(System.currentTimeMillis() + "" + isSpace);
        for (int i = 0; i < charArray.length; i++) {
            if (isSpace.get(i)) {
                JTextField temp = new JTextField(2);
                temp.setFont(new FontUIResource("宋体", FontUIResource.PLAIN, 30));
                labels.add(temp);
            } else {
                JLabel temp = new JLabel(words.get(i));
                temp.setFont(new FontUIResource("宋体", FontUIResource.PLAIN, 30));
                labels.add(temp);
            }
        }
        // this.removeAll();
        for (Component c : labels) {
            this.add(c);
        }
    }

}
