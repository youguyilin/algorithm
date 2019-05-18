package com.coder.yingen.algorithm.bst;

/**
 * PackageName: com.coder.yingen.algorithm.bst
 * ClassName: Main
 * Author: chuyingen
 * Date: 2019/4/15 4:28 PM
 * Description:
 */
public class Main {
    public static void main(String args[]){
        int[] str = {50,25,14,35,65,55,70,16};
        BinaryBST binaryBST = new BinaryBST();
        for (int s:str){
            binaryBST.insert(s);
        }
//        binaryBST.deleteNode(14);
        binaryBST.posErgodic(binaryBST.getRoot());
        System.out.println();
        binaryBST.preErgodic(binaryBST.getRoot());
        System.out.println();
        binaryBST.inErgodic(binaryBST.getRoot());
        System.out.println();

        System.out.println(binaryBST.getMin());
        System.out.println(binaryBST.getMax());
        System.out.println();

        binaryBST.printTree(binaryBST.getRoot());
    }
}
