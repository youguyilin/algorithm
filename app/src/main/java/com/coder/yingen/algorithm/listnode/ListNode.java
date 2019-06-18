package com.coder.yingen.algorithm.listnode;

/**
 * PackageName: com.coder.yingen.algorithm.listnode
 * ClassName: ListNode
 * Author: chuyingen
 * Date: 2019-06-05 10:58
 * Description:
 */
public class ListNode {
    ListNode pre;
    ListNode next;
    int value;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode getPre() {
        return pre;
    }

    public void setPre(ListNode pre) {
        this.pre = pre;
    }

    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }
}
