package com.xftxyz.chapter9;

public class T6 {

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        // 测试选择排序
        int[] array = new int[100000];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100000);
        }
        stopWatch.start();
        selectionSort(array);
        stopWatch.stop();
        System.out.println("The execution time of sorting 100,000 numbers using selection sort: "
                + stopWatch.getElapsedTime() + " milliseconds");

    }

    private static void selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            // 找到最小的元素
            int min = array[i];
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (min > array[j]) {
                    // 更新最小值和最小值的下标
                    min = array[j];
                    minIndex = j;
                }
            }
            // 交换array[i]和array[minIndex]
            if (minIndex != i) {
                array[minIndex] = array[i];
                array[i] = min;
            }
        }

    }
}

class StopWatch {

    private long startTime;
    private long endTime;

    StopWatch() {
        startTime = System.currentTimeMillis();
    }

    void start() {
        startTime = System.currentTimeMillis();
    }

    void stop() {
        endTime = System.currentTimeMillis();
    }

    long getElapsedTime() {
        return endTime - startTime;
    }
}