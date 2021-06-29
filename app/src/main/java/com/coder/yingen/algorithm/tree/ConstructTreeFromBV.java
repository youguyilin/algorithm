package com.coder.yingen.algorithm.tree;

import android.drm.DrmStore;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex Chu on 2021/6/29.
 * 从中序遍历和后序遍历序列 构造二叉树
 */
public class ConstructTreeFromBV {
    //后序遍历最后一个元素代表根结点，在中序遍历序列中找到root下标，将序列分为左子树和右子树，在分而治之
    //使用哈希表来寻址中序序列元素的下标
    //定义递归函数 helper(in_left, in_right) 表示当前递归到中序序列中当前子树的左右边界，
    //递归入口为helper(0, n-1)
    //如果in_left > in_right 说明子树为空，返回空结点
    //选择后序遍历的最后一个节点作为根节点
    int post_idx;
    int[] postOrder;
    int[] inOrder;

    Map<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public BinaryTreeNode helper(int in_left, int in_right) {
        if (in_left > in_right) {
            return null;
        }
        int rootVal = postOrder[post_idx];
        BinaryTreeNode node = new BinaryTreeNode(rootVal);
        int index = idx_map.get(node);
        post_idx--;
        node.rightNode = helper(index+1,in_right);
        node.leftNode = helper(in_left, index-1);
        return node;
    }

    public BinaryTreeNode buildTree(int[] in, int[] post) {
        this.postOrder = post;
        this.inOrder = in;

        post_idx = postOrder.length -1;
        int idx=0;
        for (Integer val: inOrder) {
            idx_map.put(val, idx++);
        }
        return helper(0, in.length-1);
    }

}
