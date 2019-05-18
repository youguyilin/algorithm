package com.coder.yingen.MingQiAlgorithm;

import java.util.Stack;

/**
 * PackageName: com.coder.yingen.MingQiAlgorithm
 * ClassName: MyStack2
 * Author: chuyingen
 * Date: 2019-05-08 16:15
 * Description:
 */
public class MyStack2 {
    private Stack<Integer> mStackData;
    private Stack<Integer> mStackMin;

    public MyStack2() {
        this.mStackData = new Stack<>();
        this.mStackMin = new Stack<>();
    }

    public void push(int num){
        if (this.mStackMin.isEmpty() || num < this.mStackMin.peek()){
            this.mStackMin.push(num);
        }else {
            int minData = this.mStackMin.peek();
            this.mStackMin.push(minData);
        }
        this.mStackData.push(num);
    }

    public int pop(){
        if (this.mStackData.isEmpty()){
            throw new RuntimeException("Your stack is empty!");
        }
        this.mStackMin.pop();
        return this.mStackData.pop();
    }

    public int getMin(){
        if (this.mStackMin.isEmpty()) {
            throw new RuntimeException("Your stack is empty");
        }
        return this.mStackMin.peek();
    }


}
