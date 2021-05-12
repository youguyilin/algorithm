package com.coder.yingen.algorithm.stack;

/**
 * Created by Alex Chu on 2021/5/11.
 */
public class ArrayStack {
    private Integer[] arr;
    private Integer size;

    public ArrayStack(Integer initSize) {
        if (initSize < 0) {
            throw new IllegalArgumentException("The init size is less than 0");
        }
        arr = new Integer[initSize];
        size = 0;
    }

    public Integer peek() {
        if (size == 0) {
            return null;
        }
        return arr[size - 1];
    }

    public void push(int obj) {
        if (size == arr.length) {
            throw new ArrayIndexOutOfBoundsException("The queue is full");
        }

        arr[size++] = obj;
    }

    public Integer pop() {
        if (size == 0) {
            throw new ArrayIndexOutOfBoundsException("The queue is empty");
        }
        return arr[--size];
    }


}
