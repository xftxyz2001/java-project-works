package com.xftxyz.chapter7;

public class T13 {

    // 随机数选择器
    // 返回1-54中的一个随机数（不包括numbers中的数）
    public static int getRandom(int... numbers) {
        int num = 0;
        do {
            num = (int) (Math.random() * 54 + 1);
        } while (isInArray(num, numbers));
        return num;
    }

    private static boolean isInArray(int num, int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            if (num == numbers[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int random = getRandom(50, 51, 52, 53, 54);
        System.out.println(random);
    }
}
