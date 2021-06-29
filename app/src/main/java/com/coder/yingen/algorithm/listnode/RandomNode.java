package com.coder.yingen.algorithm.listnode;

/**
 * Created by Alex Chu on 2021/6/28.
 */
public class RandomNode {

    int val;
    RandomNode next;
    RandomNode random;
    public RandomNode(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public RandomNode(int val, RandomNode next, RandomNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
