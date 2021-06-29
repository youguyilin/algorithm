package com.coder.yingen.algorithm.listnode;

import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * Created by Alex Chu on 2021/6/28.
 *
 * 给定一个链表，每个节点包含一个额外增加的随机指针，该指针可以指向链表中的任何节点，或者空节点
 * 要求返回这个链表的深拷贝 （深拷贝应该正好由n个 全新节点组成，其中每个新节点的值都设置为其对应的原节点的值）
 */
public class CopyRandomNode {

    private HashMap<RandomNode, RandomNode> mMap = new HashMap<>();

    public RandomNode copyRandomList(RandomNode node) {
        if (node == null) return null;
        if (mMap.containsKey(node)) return mMap.get(node);
        RandomNode root = new RandomNode(node.val);
        mMap.put(node, root);
        root.next = copyRandomList(node.next);
        root.random = copyRandomList(node.random);
        return root;
    }

    public RandomNode cpRandomNode(RandomNode head) {
        if (head == null) return head;
        RandomNode node  = head;

        //clone node (复用 head)
        while (node != null) {
            RandomNode cloneNode =  new RandomNode(node.val, node.next, null);
            RandomNode tep = node.next;
            node.next = cloneNode;
            node = tep;
        }

        //处理 randomNode
        node = head;
        while (node != null) {
            node.next.random = node.random == null ? null : node.random.next;
            node = node.next.next;
        }
        node = head;
        RandomNode cloneHead = node.next;
        while (node.next != null) {
            RandomNode temp= node.next;
            node.next = node.next.next;
            node = temp;
        }
        return cloneHead;
    }

}
