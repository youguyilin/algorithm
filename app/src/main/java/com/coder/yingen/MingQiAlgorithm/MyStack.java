package com.coder.yingen.MingQiAlgorithm;

import java.util.Stack;

/**
 * PackageName: com.coder.yingen.MingQiAlgorithm
 * ClassName: MyStack
 * Author: chuyingen
 * Date: 2019-05-08 16:06
 * Description:
 */
public class MyStack {
    private Stack<Integer> stackData;
    private Stack<Integer> stackMin;

    public MyStack() {
        this.stackData = new Stack<>();
        this.stackMin = new Stack<>();

    }

    public void push(int num) {
        if (this.stackMin.isEmpty() || num <= this.stackMin.peek()) {
            this.stackMin.push(num);
        }

        this.stackData.push(num);

    }

    public int pop() {
        if (this.stackData.isEmpty()){
            throw  new RuntimeException("Your stack is empty!");
        }
        int value = this.stackData.pop();
        if (value == getMin()){
            this.stackMin.pop();
        }
        return value;
    }

    public int  getMin() {
        if (this.stackMin.isEmpty()){
            throw new RuntimeException("Your stack is empty");
        }
        return this.stackMin.peek();
    }
}
