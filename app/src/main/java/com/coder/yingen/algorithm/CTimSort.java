package com.coder.yingen.algorithm;

/**
 * Created by Alex Chu on 2021/5/12.
 */
public class CTimSort {
    /**
     * Collection.sort 方法调用的是List.sort方法
     * Array#sort方法使用了3种排序算法：
     * 归并排序
     * 不实用自定义比较器的TimSort
     * 使用自定义比较器的TimSort
     *
     * TimeSort算法是结合了归并排序和插入排序而得出的排序算法，
     * 主要步骤：
     * 1。 判断数组大小，小于32使用二分插入排序
     * 2，长度大于32，先算出合适的大小，再将输入按其升序和降序特点进行了分区。每一个分区叫做一个run，并且每一个run已经排好序，按规则合并至只剩一个，便是排好序的结果。
     * 最坏O(nlogn) O(nlogn)O(nlogn)，最好O(n) O(n)O(n）
     */

}
