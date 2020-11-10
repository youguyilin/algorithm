package com.coder.yingen.algorithm.stack;

import android.text.method.HideReturnsTransformationMethod;

import java.util.Stack;

/**
 * Created by alex Chu on 2020-03-25.
 */
public class SortStackByStack {

    private static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur){
                stack.push(help.pop());
            }

            while (!help.isEmpty()){
                stack.push(help.pop());
            }
        }
    }
}
