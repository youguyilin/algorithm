package com.coder.yingen.algorithm.tree;

/**
 * PackageName: com.coder.yingen.algorithm.tree
 * ClassName: BinaryTreeNode
 * Author: chuyingen
 * Date: 2019-06-27 10:20
 * Description:
 */
public class BinaryTreeNode {
    int  value;
    BinaryTreeNode leftNode;
    BinaryTreeNode rightNode;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value, BinaryTreeNode leftNode, BinaryTreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }
}
