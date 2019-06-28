package com.coder.yingen.algorithm.link;

import java.util.Stack;

/**
 * PackageName: com.coder.yingen.algorithm.link
 * ClassName: PrintLinkListFromEnd
 * Author: chuyingen
 * Date: 2019-06-27 09:26
 * Description:
 * 输入一个链表的头节点，从尾到头反过来打印出每个节点的值
 * 不改变原来的数据结构
 */
public class PrintLinkListFromEnd {
    /**
     * 也就是说，第一个遍历到的节点最后一个输出，而最后一个遍历到的节点第一个输出。典型的后进先出，用栈，或者递归
     */


    public static void printListInverselyUseStack(ListNode head){
        if (head == null)
            return;
        Stack<Integer> stack = new Stack<>();
        while (head != null){
            stack.push(head.value);
            head = head.next;
        }

        while (!stack.isEmpty()){
            System.out.println(stack.pop() + "");
        }
    }

    public static void printListInverseUseRecursion(ListNode head){
        if (head == null){
            return;
        }
        printListInverseUseRecursion(head.next);
        System.out.println(head.value);
    }

}
