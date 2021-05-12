package com.coder.yingen.algorithm.tree;

import java.util.HashMap;
import java.util.Stack;

/**
 * PackageName: com.coder.yingen.algorithm.tree
 * ClassName: ReConstruct
 * Author: chuyingen
 * Date: 2019-06-27 10:24
 * Description:
 */
public class ReConstruct {
    private static BinaryTreeNode constructBinaryTree(int[] pre,int[] in){
        if (pre == null || in == null ||pre.length != in.length || in.length <= 0){
            return null;
        }
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < in.length; i++){
            map.put(in[i],i);
        }

        return construct(pre,0,pre.length-1,in,0,in.length-1,map);

    }

    /**
     *
     * @param pre 前序遍历数组
     * @param ps  前序遍历开始
     * @param pe  前序遍历结束
     * @param in  中序遍历数组
     * @param is  中序遍历开始
     * @param ie  中序遍历结束
     * @param map 中序数组
     * @return
     */
    private static BinaryTreeNode construct(int[] pre,int ps,int pe,int[] in,int is,int ie, HashMap<Integer,Integer> map){
        if (ps > pe) {
            //开始位置大于结束位置，说明已经没有需要处理的元素了
            return null;
        }
        int value = pre[ps];//取前序遍历的第一个参数。就是当前树的根节点
        int i = 0;
        try{
            i = map.get(pre[ps]);
        }catch (Exception e){
            throw new IllegalArgumentException("Invalid args: 前序/中序数组有问题");
        }
        //创建当前根节点
        BinaryTreeNode head = new BinaryTreeNode(value);
        //递归
        head.leftNode = construct(pre,ps + 1,ps + i - is,in,is,i -1,map);
        head.rightNode = construct(pre,ps+1+i-is,pe,in ,i+1,ie,map);
        return head;
    }

    public static void main(String args[]){
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        BinaryTreeNode root = constructBinaryTree(pre,in);
        printTree(root);
    }


    public static void printTree(BinaryTreeNode head) {
        System.out.println("-----------------\r\nBinary Tree:");
        printInOrder(head, 0, "Root-", 8);
        System.out.println();
    }

    public static void printInOrder(BinaryTreeNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.rightNode, height + 1, "R-", len);
        String val = to + head.value;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val;// + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.leftNode, height + 1, "L-", len);
    }

    public static String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }
}
