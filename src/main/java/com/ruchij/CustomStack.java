package com.ruchij;

class CustomStack {

    private final int[] stack;
    private int index;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.index = 0;
    }

    public void push(int x) {
        if (index < stack.length) {
            stack[index] = x;
            index++;
        }
    }

    public int pop() {
        if (index == 0) {
            return -1;
        } else {
            index--;
            return stack[index];
        }

    }

    public void increment(int k, int val) {
        for (int i = 0; i < k && i < index; i++) {
            stack[i] = stack[i] + val;
        }
    }
}