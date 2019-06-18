package com.coder.yingen.algorithm.listnode;

import java.util.ArrayList;

/**
 * PackageName: com.coder.yingen.algorithm.listnode
 * ClassName: FindKthToTail
 * Author: chuyingen
 * Date: 2019-06-05 11:03
 * Description:
 */
public class FindKthToTail {

    /**
     * 两次遍历实现，但是arrylist 使用很大空间
     *
     * @param node
     * @param k
     * @return
     */
    public static ListNode findKthToTail(ListNode node, int k) {
        ArrayList<ListNode> arrayList = new ArrayList<>();
        while (node != null) {
            arrayList.add(node);
            node = node.next;
        }
        int length = arrayList.size();
        if (k <= 0 || k > arrayList.size()) {
            return null;
        }
        return arrayList.get(length - k);

    }

    /**
     * 双指针遍历法，只遍历一次；
     * @param node
     * @param k
     * @return
     */
    public static ListNode findKthToTailByTwoIndicator(ListNode node, int k) {
        if (k <= 0 || node == null) {
            return null;
        }
        ListNode pre = node;
        ListNode last = node;
        for (int i = 0; i < k; i++) {
            if (last.next != null) {
                last = last.next;
            } else {
                return  null;
            }
        }

        while (last.next != null){
            pre = pre.next;
            last = last.next;
        }
        return pre;
    }


}
