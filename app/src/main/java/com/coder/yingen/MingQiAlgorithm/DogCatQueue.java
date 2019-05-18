package com.coder.yingen.MingQiAlgorithm;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * PackageName: com.coder.yingen.MingQiAlgorithm
 * ClassName: DogCatQueue
 * Author: chuyingen
 * Date: 2019-05-09 15:37
 * Description:
 */
public class DogCatQueue {
    private Queue<PetQueue> dogQ;
    private Queue<PetQueue> catQ;
    private long count;

    public DogCatQueue() {
        this.dogQ = new LinkedList<>();
        this.catQ = new LinkedList<>();
        this.count = 0;
    }

    public void add(Pet pet) {
        if (pet.getType().equals("dog")) {
            this.dogQ.add(new PetQueue(pet, count++));
        } else if (pet.getType().equals("cat")) {
            this.catQ.add(new PetQueue(pet, count++));
        } else {
            throw new RuntimeException("error,no pet type!");
        }
    }

    public Pet pollAll() {
        if (!this.dogQ.isEmpty() && !this.catQ.isEmpty()) {
            if (this.dogQ.peek().getCount() < this.catQ.peek().getCount()) {
                return this.catQ.poll().getPet();
            } else {
                return this.dogQ.poll().getPet();
            }
        } else if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("err,queue is empty!");
        }
    }

    public Pet pollDog() {
        if (!this.dogQ.isEmpty()) {
            return this.dogQ.poll().getPet();
        } else {
            throw new RuntimeException("dog queue is empty");
        }
    }

    public Pet pollCat() {
        if (!this.catQ.isEmpty()) {
            return this.catQ.poll().getPet();
        } else {
            throw new RuntimeException("cat queue is empty!");
        }
    }

    public boolean isEmpty() {
        return this.dogQ.isEmpty() && this.catQ.isEmpty();
    }

    public boolean isDogEmpty() {
        return this.dogQ.isEmpty();
    }

    public boolean isCatEmpty() {
        return this.catQ.isEmpty();
    }

    //用一个栈 给另一个栈排序
    public static void sortStackByStack(Stack<Integer> stack) {
        Stack<Integer> help = new Stack<>();
        while (!stack.isEmpty()) {
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() > cur) {
                stack.push(help.pop());
            }
            help.push(cur);
        }
        while (!help.isEmpty()) {
            stack.push(help.pop());
        }
    }
}
