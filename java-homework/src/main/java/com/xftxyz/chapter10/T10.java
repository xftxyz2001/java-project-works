package com.xftxyz.chapter10;

public class T10 {

    public static void main(String[] args) {

        Queue queue = new Queue();
        for (int i = 0; i < 20; i++) {
            queue.enqueue(i);
        }
        while (!queue.empty()) {
            System.out.print(queue.dequeue() + " ");
        }

    }
}

class Queue {

    private int[] elements;
    private int size;
    private int capacity;

    public Queue() {
        this(8);
    }

    public Queue(int capacity) {
        this.capacity = capacity;
        elements = new int[capacity];
    }

    public void enqueue(int v) {
        if (size >= capacity) {
            int[] temp = new int[capacity * 2];
            System.arraycopy(elements, 0, temp, 0, capacity);
            elements = temp;
            capacity *= 2;
        }
        elements[size++] = v;
    }

    public int dequeue() {
        int v = elements[0];
        System.arraycopy(elements, 1, elements, 0, --size);
        return v;
    }

    public boolean empty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}