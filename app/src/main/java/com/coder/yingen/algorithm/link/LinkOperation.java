package com.coder.yingen.algorithm.link;

import org.w3c.dom.Node;

/**
 * Create by Alex Chu on 2020-09-07
 */
public class LinkOperation {

    /**
     * 链表翻转
     *
     * @param head
     * @return
     */
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

    public static int getLength(ListNode head) {
        int n = 0;
        ListNode node = head;
        while (node != null) {
            node = node.next;
            n++;
        }
        return n;
    }

    /**************************************************K 个一组 翻转链表************************************************/
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        ListNode end = dummy;
        while (end.next != null) {
            for (int i = 0; i < k && end != null; i++) {
                end = end.next;
            }
            if (end == null) break;
            ListNode start = pre.next;
            ListNode next = end.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode start) {
        if (start == null || start.next == null){
            return start;
        }
        ListNode pre = null;
        ListNode curr = start;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }
}
