package com.xftxyz.chapter13;

import java.util.ArrayList;

public class T8 {

    public static void main(String[] args) {

        MyStack myStack = new MyStack();
        for (int i = 0; i < 10; i++) {
            myStack.push(i);
        }

        try {
            MyStack myStack1 = (MyStack) myStack.clone();
            System.out.println(myStack1);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

class MyStack {
    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(list.size() - 1);
    }

    public Object pop() {
        Object o = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    @Override
    public String toString() {
        return "stack: " + list.toString();
    }

    @Override
    @SuppressWarnings("unchecked")
    protected Object clone() throws CloneNotSupportedException {
        MyStack myStack = new MyStack();
        myStack.list = (ArrayList<Object>) list.clone();
        return myStack;
    }
}