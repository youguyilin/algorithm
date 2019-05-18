package com.coder.yingen.algorithm;

/**
 * Created by chuyingen on 2018/4/13.
 * email youguyilin@126.com.
 */

public class algorithm {
    public algorithm() {
    }

    /**
     * 冒泡排序：比较两个相邻的元素，将较大或者较小的值交换至右端。
     * 最优O（n）,最差O（n2）
     */
    public int[] sortPop(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        boolean flag = true;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    flag = false;//未完成排序
                }
            }
            if (flag = true) {//若一趟下来没有交换
                break;
            }
        }
        return arr;
    }

    public void swap(int[] arr, int start, int end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    /**
     * 快速排序：快速排序是对冒泡排序的一种改进
     * 首先在数组中任选一个数作为key，然后将所有比他小的数放到它的前面，比它大的数放到后面，
     * 但是这个不是一种稳定的算法，多个相同的值的相对位置会在算法结束的时候发生变动
     * <p>
     * 时间复杂度 具有最好的平均性能，最坏时间复杂度和冒泡排序一样O（n2）;
     **/
    public void sortASC(int[] arr, int low, int heigh) {
        if (arr == null || arr.length == 0 || low <= 0 || heigh > arr.length - 1) {
            return;
        }
        int start = low;
        int end = heigh;
        int standardVal = arr[start];
        while (end > start) {
            while (end > start && arr[end] > standardVal) {
                end--;
            }
            if (arr[end] < standardVal) {
                swap(arr, end, start);
            }
            while (end > start && arr[start] < standardVal) {
                start++;
            }
            if (arr[start] > standardVal) {
                swap(arr, end, start);
            }
        }

        //采用递归的形式完成
        //只要头部移动，就说明还有数据发生排序，未完成排序
        if (start > low) {
            sortASC(arr, low, start - 1);
        }
        if (end < heigh) {
            sortASC(arr, end + 1, heigh);
        }

    }


    /**
     * 二分查找法
     * 时间复杂度为O（log（n））
     *
     * @param key
     * @param nums
     * @return
     */
    public int binarySearch(int key, int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > key) {
                high = mid - 1;
            } else if (nums[mid] < key) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    //递归 2分查找法
    public static int search(int num, int low, int high, int a[]) {
        int middle = (high + low) / 2;
        while (low <= high) {
            if (a[middle] > num) {
                return search(num, low, middle - 1, a);
            } else if (a[middle] < num) {
                return search(num, middle + 1, high, a);
            } else {
                return middle;
            }
        }
        return -1;
    }

}
