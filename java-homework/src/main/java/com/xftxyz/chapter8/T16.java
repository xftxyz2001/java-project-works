package com.xftxyz.chapter8;

import java.util.Arrays;

public class T16 {

    // 对二维数组的行进行排序
    public static void sortRow(int[][] m) {
        Arrays.sort(m, (o1, o2) -> {
            int r1 = o1[0] - o2[0];
            if (r1 != 0) {
                return r1;
            } else {
                return o1[1] - o2[1];
            }
        });
    }

    public static void main(String[] args) {
        int[][] m = new int[][] {
                { 4, 2 },
                { 1, 7 },
                { 4, 5 },
                { 1, 2 },
                { 1, 1 },
                { 4, 1 },
                { 4, 3 },
                { 4, 4 },
                { 1, 4 },
                { 1, 5 },
                { 1, 6 },
                { 4, 6 },
                { 4, 7 },
                { 4, 8 },
                { 2, 1 },
                { 2, 2 },
                { 2, 3 },
                { 2, 4 },
                { 2, 5 },
                { 2, 6 },
                { 2, 7 },
                { 2, 8 },
                { 3, 1 },
                { 3, 2 },
                { 3, 3 },
                { 3, 4 },
                { 3, 5 },
                { 3, 6 },
                { 3, 7 },
                { 3, 8 },
        };

        sortRow(m);

        for (int i = 0; i < m.length; i++) {
            System.out.println(Arrays.toString(m[i]));
        }
    }
}
