package com.xftxyz.chapter7;

public class T7 {

    public static void main(String[] args) {

        int[] nums = new int[10];

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 10);
            nums[n]++;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.printf("%d occurs %d time%s\n", i, nums[i], nums[i] > 1 ? "s" : "");
        }
    }
}
