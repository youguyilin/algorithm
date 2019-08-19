package com.coder.yingen.algorithm;

import android.media.midi.MidiDevice;

/**
 * 类描述：归并排序
 * 创建人：ChuYinGen
 * 创建时间：2019-08-19
 * 修改人：
 * 修改时间：
 */
public class MergeSort {
    public static void main(String args[]){
        int[] my= new int[]{4,2,7,5,8,9,0,1,3};
        for (int e:my
             ) {
            System.out.print(e + " ");
        }
        System.out.println(" ");

        mergeSort(my);
        for (int i=0;i < my.length; i++){
            System.out.print(my[i] + " ");
        }
    }

    public static void mergeSort(int[] arr) {
        sortArr(arr, 0, arr.length - 1);
    }

    private static void sortArr(int[] mArr, int L, int R) {
        if (L == R) return;
        int mid = (L + R) / 2;
        sortArr(mArr, L, mid);
        sortArr(mArr, mid + 1, R);
        merge(mArr, L, mid, R);
    }

    private static void merge(int[] mArr, int mL, int mMid, int mR) {
        int[] temp = new int[mR - mL + 1];
        int i = 0;
        int p1 = mL;
        int p2 = mMid + 1;
        //比较左右两个部分元素的值，哪个小，把它加入temp数组中
        while (p1 <= mMid && p2 <= mR) {
            temp[i++] = mArr[p1] < mArr[p2] ? mArr[p1++] : mArr[p2++];
        }
        //上面的循环退出后，把剩余的元素依次填入到temp中
        //以下只有一个会执行
        while (p1 <= mMid) {
            temp[i++] = mArr[p1++];
        }
        while (p2 <= mR) {
            temp[i++] = mArr[p2++];
        }
        //把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            mArr[mL + i] = temp[i];
        }
    }
}
