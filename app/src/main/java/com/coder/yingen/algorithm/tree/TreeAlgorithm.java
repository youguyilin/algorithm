package com.coder.yingen.algorithm.tree;

import android.provider.DocumentsContract;
import android.support.v4.view.animation.FastOutLinearInInterpolator;
import android.view.animation.BounceInterpolator;

import com.coder.yingen.algorithm.ProductAndConsumerRL;

import org.w3c.dom.ls.LSException;

import java.net.BindException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

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
        return Math.min(getmin(treeNode.leftNode), getmin(treeNode.rightNode)) + 1;
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

    /**
     * 判断二叉树是否为完全二叉树
     * @param node
     * @return
     */
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

    /**
     * 两个二叉树是否完全相等
     *
     */
    public boolean isSameTreeNode(BinaryTreeNode node, BinaryTreeNode no2) {
        if (no2 == null && node == null) {
            return true;
        } else if (no2 == null || node == null){
            return false;
        }
        if (no2.value != node.value) {
            return false;
        }
        boolean left = isSameTreeNode(node.leftNode, no2.leftNode);
        boolean right = isSameTreeNode(node.rightNode, no2.rightNode);
        return left&&right;
    }

    /**
     * 两个二叉树是否互为镜像
     *
     */
    public boolean isMirror(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.value != t2.value) {
            return false;
        }
        return isMirror(t1.leftNode,t2.rightNode) && isMirror(t1.rightNode,t2.leftNode);
    }

    /**
     * 翻转二叉树，镜像二叉树
     */
    public BinaryTreeNode mirrorTreeNode(BinaryTreeNode node) {
        if (node == null) {
            return null;
        }
        BinaryTreeNode left = mirrorTreeNode(node.leftNode);
        BinaryTreeNode right= mirrorTreeNode(node.rightNode);
        node.leftNode = right;
        node.rightNode = left;
        return node;
    }

    /**
     * 栈实现翻转二叉树 DFS
     */
    public BinaryTreeNode invertTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }
        Stack<BinaryTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node  = stack.pop();
            BinaryTreeNode left = node.leftNode;
            node.leftNode = node.rightNode;
            node.rightNode = left;
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
            if (node.rightNode != null){
                stack.push(node.rightNode);
            }
        }
        return root;
    }

    /**
     * 队列实现翻转二叉树
     */
    public BinaryTreeNode invertTreeByQueue(BinaryTreeNode root){
        if (root == null) {
            return null;
        }
        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            BinaryTreeNode left = node.leftNode;
            node.leftNode = node.rightNode;
            node.rightNode = left;
            if (node.leftNode != null) {
                queue.offer(node.leftNode);
            }
            if (node.rightNode != null) {
                queue.offer(node.rightNode);
            }
        }
        return root;
    }

    /**
     * 二叉树前序遍历迭代解法
     * @param root
     * @return
     */
    public ArrayList<Integer> preOrder(BinaryTreeNode root) {
        Stack<BinaryTreeNode> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            list.add(node.value);
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
        return list;
    }

    /**
     * 二叉树前序遍历递归算法
     * @param root
     * @return
     */
    public ArrayList<Integer> preOrderIteration(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        preOrder2(root,result);
        return result;
    }

    private void preOrder2(BinaryTreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.value);
        preOrder2(root.leftNode,result);
        preOrder2(root.rightNode,result);
    }

    public ArrayList<Integer> inOrder(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        BinaryTreeNode currentNode = root;
        while (currentNode != null || !stack.isEmpty()){
            while (currentNode != null) {
                stack.add(currentNode);
                currentNode = currentNode.leftNode;
            }
            currentNode = stack.pop();
            result.add(currentNode.value);
            currentNode = currentNode.rightNode;
        }
        return result;
    }

    /**
     * 后续遍历递归
     * @param root
     * @return
     */
    public ArrayList<Integer> postOrder(BinaryTreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        result.addAll(postOrder(root.leftNode));
        result.addAll(postOrder(root.rightNode));
        result.add(root.value);
        return result;
    }

    public ArrayList<Integer> postOrderNoIterator(BinaryTreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<BinaryTreeNode> stack = new Stack<>();
        if (root == null) {
            return result;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            BinaryTreeNode node = stack.pop();
            result.add(node.value);
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
        }
        Collections.reverse(result);
        return result;
    }

}
