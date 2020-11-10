package com.coder.yingen.algorithm.link;

import org.w3c.dom.Node;

/**
 * Create by Alex Chu on 2020-09-07
 */
public class LinkOperation {

    public static ListNode reverseLink(ListNode head) {
        if (head == null || getLength(head) == 0) {
            return head;
        }
        //前一个节点指针
        ListNode preNode = null;
        //当前节点指针
        ListNode curNode = head;
        //后一个节点
        ListNode nextNode = null;

        while (curNode != null) {
            nextNode = curNode.next;
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return preNode;
    }

    public static int getLength(ListNode head){
        int n =0 ;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }
        return n;

    }
}
