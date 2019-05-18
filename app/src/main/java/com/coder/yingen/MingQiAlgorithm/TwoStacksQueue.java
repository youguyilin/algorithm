package com.coder.yingen.MingQiAlgorithm;

import java.util.Stack;

/**
 * PackageName: com.coder.yingen.MingQiAlgorithm
 * ClassName: TwoStacksQueue
 * Author: chuyingen
 * Date: 2019-05-08 16:31
 * Description:
 */
public class TwoStacksQueue {
    private Stack<Integer> mStackPush;
    private Stack<Integer> mStackPop;

    public static void main(String args[]){
        Stack<Integer> stack = new Stack<>();
        for (int i= 0;i <4;i++){
            stack.push(i);
        }
        reverse(stack);
    }

    public TwoStacksQueue() {
        this. mStackPop = new Stack<>();
        this.mStackPush = new Stack<>();
    }

    public void add(int num){
       this.mStackPush.push(num);
    }

    public int poll(){
        if (this.mStackPush.isEmpty() && mStackPop.isEmpty()){
            throw new RuntimeException("Your stack is empty!");
        } else if (this.mStackPop.isEmpty()){
            while (!mStackPush.isEmpty()){
                mStackPop.push(mStackPush.pop());
            }
        }
        return mStackPop.pop();
    }

    public int peek(){
        if (this.mStackPush.isEmpty() && mStackPop.isEmpty()){
            throw new RuntimeException("Queue is empty");
        }else if (mStackPop.isEmpty()){
            while (!mStackPush.isEmpty()){
                mStackPop.push(mStackPush.pop());
            }
        }
        return mStackPop.peek();
    }

    //使用递归函数和栈操作逆序操作
    public static int getAndRemoveLastEelement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty()) {
            return result;
        }else {
            int last = getAndRemoveLastEelement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack){
        if (stack.isEmpty()){
            return;
        }
        int i  = getAndRemoveLastEelement(stack);
        reverse(stack);
        stack.push(i);
    }

}
