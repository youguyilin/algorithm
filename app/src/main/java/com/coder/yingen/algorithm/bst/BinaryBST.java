package com.coder.yingen.algorithm.bst;

/**
 * PackageName: com.coder.yingen.algorithm.bst
 * ClassName: BinaryBST
 * Author: chuyingen
 * Date: 2019/4/15 3:05 PM
 * Description:创建搜索二叉树，主要包含二叉树 根节点 以及相关方法（增删改查）
 */
public class BinaryBST {
    private BSTNode root;


    public BSTNode getRoot() {
        return root;
    }

    public void setRoot(BSTNode root) {
        this.root = root;
    }

    /**
     * 插入节点
     * <p>
     * 从根节点开始比较，比它小再与其左子树比较，直至最后一个叶子节点，比它小放其左子树，比它大放其右子树
     */
    public void insert(int data) {
        BSTNode newNode = new BSTNode();
        newNode.val = data;

        if (root == null) {
            root = newNode;//如果是第一个节点为null，直接创建一个新的节点即可
        } else {
            BSTNode current = root;
            //current 节点的父节点
            BSTNode parent;
            while (true) {
                parent = current;
                if (data < current.val) {
                    current = current.leftChild;
                    if (current == null) {
                        //直到当前节点为空，设置当前节点左子树为新创建的节点
                        parent.leftChild = newNode;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        //设置当前节点的右子树为新创建的节点
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    /**
     * 查找节点
     * <p>
     * 也是根据其特点进行查找，某个节点的值总比其左子树的值大，比其右子树的值小
     */
    public BSTNode queryNode(int val) {
        BSTNode current = root;
        if (current == null) return null;
        while (current.val != val) {
            if (val < current.val) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) return null;
        }

        return current;
    }


    /**
     * 删除节点
     * <p>
     * 逻辑比较复杂，需要知道是删除左子树节点还是右子树节点，删除的节点是否存在以及是否有左右子树
     */
    public boolean deleteNode(int val) {
        BSTNode current = root;
        BSTNode parent = root;
        boolean isLeftChild = false;
        boolean isRightChild = false;
        if (current == null) return false;//当前树不存在

        //判断是左子节点还是右子节点
        while (current.val != val) {
            parent = current;
            isLeftChild = false;
            isRightChild = false;
            if (val < current.val) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isRightChild = true;
                current = current.rightChild;
            }

            if (current == null) {
                break;
            }

        }
        //不存在该节点
        if (current == null) {
            return false;
        }
        //不存在子节点
        if ((current.leftChild) == null && (current.rightChild == null)) {
            System.out.print("是叶子节点不存在子节点");
            if (isLeftChild) {
                parent.leftChild = null;
            } else if (isRightChild) {
                parent.rightChild = null;
            }
            current = null;
            return true;
        } else if ((current.leftChild != null) && (current.rightChild == null)) {
            //存在左子节点
            System.out.print("不是叶子节点只存在左子节点");
            if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else if (isRightChild) {
                parent.rightChild = current.leftChild;
            }
            current = null;
            return true;
        } else if ((current.leftChild == null) && (current.rightChild != null)) {
            System.out.print("不是叶子节点只存在右子节点");
            if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else if (isRightChild) {
                parent.leftChild = current.rightChild;
            }
            current = null;
            return true;

        } else {
            //左右节点都存在
            if (isLeftChild) {
                parent.leftChild = current.rightChild;
                BSTNode currentLeft = current.rightChild;
                BSTNode parentLeft = currentLeft;
                while (currentLeft != null) {
                    parentLeft = currentLeft;
                    currentLeft = currentLeft.leftChild;
                }
                parentLeft.leftChild = current.leftChild;
            } else if (isRightChild) {
                parent.rightChild = current.rightChild;
                BSTNode currentLeft = current.rightChild;
                BSTNode parentLeft = currentLeft;
                while (currentLeft != null) {
                    parentLeft = currentLeft;
                    currentLeft = currentLeft.leftChild;
                }
                parentLeft.leftChild = current.leftChild;
            }
            current = null;
            return true;
        }
    }

    public void printTree(BSTNode head) {
        System.out.println("-----------------\r\nBinary Tree:");
        printInOrder(head, 0, "Root-", 8);
        System.out.println();
    }

    public void printInOrder(BSTNode head, int height, String to, int len) {
        if (head == null) {
            return;
        }
        printInOrder(head.rightChild, height + 1, "R-", len);
        String val = to + head.val;
        int lenM = val.length();
        int lenL = (len - lenM) / 2;
        int lenR = len - lenM - lenL;
        val = getSpace(lenL) + val;// + getSpace(lenR);
        System.out.println(getSpace(height * len) + val);
        printInOrder(head.leftChild, height + 1, "L-", len);
    }

    public String getSpace(int num) {
        String space = " ";
        StringBuffer buf = new StringBuffer("");
        for (int i = 0; i < num; i++) {
            buf.append(space);
        }
        return buf.toString();
    }

    /**
     * 前序遍历，先根后左右
     */
    public void preErgodic(BSTNode node) {
        if (node != null) {
            System.out.print(node.val + "---");
            preErgodic(node.leftChild);
            preErgodic(node.rightChild);
        }

    }

    /**
     * 中序遍历
     * 先左
     */
    public void inErgodic(BSTNode node) {
        if (node != null) {
            inErgodic(node.leftChild);
            System.out.print(node.val + "---");
            inErgodic(node.rightChild);
        }

    }

    /**
     * 后序遍历
     */
    public void posErgodic(BSTNode node){
        if (node != null){
            posErgodic(node.leftChild);
            posErgodic(node.rightChild);
            System.out.print(node.val + "---");
        }
    }

    /**
     * 选择最小值，最小值一定在最左子树
     */
    public int getMin(){
        BSTNode current = root;
        BSTNode currentParent = current;
        if (current == null) return -1;
        while (current != null){
            currentParent = current;
            current = current.leftChild;
        }
        return currentParent.val;
    }

    /**
     * 查找最大值
     */
    public int  getMax(){
        BSTNode current = root;
        BSTNode currentParent = current;
        if (current == null) return -1;
        while (current != null){
            currentParent = current;
            current = current.rightChild;
        }
        return currentParent.val;
    }

}
