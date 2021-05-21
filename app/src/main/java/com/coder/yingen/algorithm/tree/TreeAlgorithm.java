package com.coder.yingen.algorithm.tree;

import com.coder.yingen.algorithm.ProductAndConsumerRL;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Alex Chu on 2021/5/20.
 */
public class TreeAlgorithm {

    public int getMaxDepth(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int left = getMaxDepth(treeNode.leftNode);
        int right = getMaxDepth(treeNode.rightNode);
        return Math.max(left, right) + 1;
    }


    public int getMinDepth(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return getmin(treeNode);
    }

    private int getmin(BinaryTreeNode treeNode) {
        if (treeNode == null) {
            return Integer.MAX_VALUE;
        }
        if (treeNode.leftNode == null && treeNode.rightNode == null) {
            return 1;
        }
        return Math.min(getmin(treeNode.leftNode), getmin(treeNode.rightNode));
    }

    /**
     * 二叉树中节点个数
     * @param node
     * @return
     */
    public int numOfTreeNode(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = numOfTreeNode(node.leftNode);
        int right = numOfTreeNode(node.rightNode);
        return left + right + 1;
    }

    /**
     * 二叉树中叶子节点个数
     * @param node
     * @return
     */
    public int numsOfChildNode(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.leftNode == null && node.rightNode == null) {
            return 1;
        }
        return numsOfChildNode(node.leftNode) + numsOfChildNode(node.rightNode);
    }

    /**
     * 二叉树第k层节点个数
     * @param node
     * @return
     */
    public int numsOfKLevelTreeNode(BinaryTreeNode node, int k) {
        if (node == null || k<1) {
            return 0;
        }
        if (k ==1) {
            return 1;
        }
        int munsLeft = numsOfKLevelTreeNode(node.leftNode, k -1);
        int numsRight = numsOfKLevelTreeNode(node.rightNode, k-1);
        return munsLeft + numsRight;
    }

    public boolean isBalanced(BinaryTreeNode node) {
        return maxDepth2(node) != -1;
    }

    private int maxDepth2(BinaryTreeNode node) {
        if (node == null){
            return 0;
        }
        int left = maxDepth2(node.leftNode);
        int right = maxDepth2(node.rightNode);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1){
            return  -1;
        }
        return Math.max(left,right) + 1;
    }

    private boolean isCompleteTreeNode(BinaryTreeNode node) {
        if (node == null) {
            return false;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<BinaryTreeNode>();
        queue.add(node);
        boolean result = true;
        boolean hasNoChild = false;
        while (!queue.isEmpty()) {
            BinaryTreeNode treeNode = queue.remove();
            if (hasNoChild) {
                if (treeNode.leftNode != null || treeNode.rightNode != null){
                    result = false;
                    break;
                }
            } else {
                if (treeNode.leftNode != null && treeNode.rightNode != null) {
                    queue.add(treeNode.leftNode);
                    queue.add(treeNode.rightNode);
                } else if (treeNode.leftNode!= null && treeNode.rightNode == null){
                    queue.add(treeNode.leftNode);
                    hasNoChild = true;
                } else if (treeNode.leftNode == null && treeNode.rightNode != null) {
                    result = false;
                    break;
                } else {
                    hasNoChild = true;
                }
            }
        }
        return result;
    }
}
