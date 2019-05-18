package com.coder.yingen.algorithm.bst;

/**
 * PackageName: com.coder.yingen.algorithm.bst
 * ClassName: BSTNode
 * Author: chuyingen
 * Date: 2019/4/15 3:01 PM
 * Description:主要包含节点值，左子叶子节点引用，右子叶子节点引用
 */
public class BSTNode {
    //节点值
    int val;
    //左子引用节点
    BSTNode leftChild;
    //右子叶子节点
    BSTNode rightChild;

    public void printVal(){
        System.out.println(val);
    }
}
