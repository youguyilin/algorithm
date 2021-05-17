package com.coder.yingen.algorithm;

/**
 * 类描述：Straight Insertion Sort 基本思想是：；把N个待排序的元素看成为一个有序表和一个无序表。开始时有序表中只包含一个元素，无序表中包含有n-1元素，排序过程中
 * 每次从无序表中取出第一个元素，将它插入到有序表中适当的位置，使之成为新的有序表，重复n-1次可完成排序过程。
 * 创建人：ChuYinGen
 * 创建时间：2019-08-20
 * 修改人：
 * 修改时间：
 */
public class InsertSort {

    public static void insertSort(int[] a, int n) {
        int i, j, k;
        for (i = 1; i < n; i++) {
            for (j = i - 1; j >= 0; j--) {
                if (a[j] < a[i]) break;
            }


            if (j != i - 1) {
                int temp = a[i];
                for (k = i - 1; k > j; k--) {
                    a[k + 1] = a[k];
                }
                a[k + 1] = temp;
            }
        }
    }
}
