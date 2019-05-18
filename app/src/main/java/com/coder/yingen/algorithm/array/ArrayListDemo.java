package com.coder.yingen.algorithm.array;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * PackageName: com.coder.yingen.algorithm.array
 * ClassName: ArrayListDemo
 * Author: chuyingen
 * Date: 2019-04-28 10:20
 * Description:
 */
public class ArrayListDemo {
    public static void main(String args[]){

    }

    /**
     *这个是不使用remove（object ob）的方法
     *
     *动态删除arraylist 元素
     */
    public void delectElementFromArray(ArrayList<Integer> list,int i){
        for (int k = 0 ,len = list.size();k < len; k++){
            if (list.get(k) == i){
                list.remove(k);
                --k;
                --len;
            }
        }

        Iterator<Integer> integers = list.iterator();
        while (integers.hasNext()){
            if (integers.next() == i){
                integers.remove();
            }
        }

    }


}
