package com.xftxyz.chapter7;

import java.util.Scanner;

public class T17 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 输入学生人数
        System.out.print("Enter the number of students: ");
        int num = scanner.nextInt();

        String[] names = new String[num];
        double[] scores = new double[num];

        // 输入学生姓名和成绩
        System.out.print("Enter the name and score of students: ");
        for (int i = 0; i < num; i++) {
            names[i] = scanner.next();
            scores[i] = scanner.nextDouble();
        }
        scanner.close();

        // 排序（降序，插入排序）
        for (int i = 1; i < num; i++) {
            double score = scores[i];
            String name = names[i];
            int j = i - 1;
            for (; j >= 0 && scores[j] < score; j--) {
                scores[j + 1] = scores[j];
                names[j + 1] = names[j];
            }
            scores[j + 1] = score;
            names[j + 1] = name;
        }

        // 输出
        for (int i = 0; i < num; i++) {
            System.out.printf("%s\t%.2f\n", names[i], scores[i]);
        }

    }
}
