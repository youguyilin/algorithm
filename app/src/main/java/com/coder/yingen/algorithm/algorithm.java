package com.coder.yingen.algorithm;

import com.coder.yingen.algorithm.listnode.ListNode;

import java.util.PriorityQueue;
import java.util.Stack;

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
     * 左右指针法
     *
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int[] leftAndRightindicator(int[] arr, int left, int right) {
        int key = getMid(arr, left, right);
        while (left < right) {
            while (left < right && arr[left] <= arr[key]) {
                ++left;
            }
            while (left < right && arr[right] >= arr[key]) {
                --right;
            }
            swap(arr, left, right);
        }
        swap(arr, left, key);
        return arr;

    }

    //前后指针法
    public void QuickSort(int[] arr, int left, int right) {
        if (left >= right) return;
        int index = Parsort(arr, left, right);
        QuickSort(arr, left, index - 1);
        QuickSort(arr, index + 1, right);
    }

    private int Parsort(int[] arr, int left, int right) {
        int key = arr[getMid(arr, left, right)];
        int cur = left;
        int pre = left - 1;
        while (cur < right) {
            while (arr[cur] < key && ++pre != cur) {
                swap(arr, cur, pre);
            }
            ++cur;
        }
        swap(arr, ++pre, right);
        return pre;
    }

    /***
     * 快速排序的优化
     * @param arr
     * @param left
     * @param right
     * @return
     */
    public int getMid(int[] arr, int left, int right) {
        int mid = left + ((right - left) >> 1);
        if (arr[left] <= arr[right]) {
            if (arr[mid] < arr[right]) {
                return left;
            } else if (arr[mid] > arr[right]) {
                return right;
            } else
                return mid;
        } else {
            if (arr[mid] < arr[right]) {
                return right;
            } else if (arr[mid] > arr[left]) {
                return left;
            } else return mid;
        }

    }

    /**
     * 非递归排序
     *
     * @param arr
     * @param left
     * @param right
     */
    public void QuickSortNotR(int[] arr, int left, int right) {
        Stack<Integer> s = new Stack<>();
        s.push(left);
        s.push(right);
        while (!s.isEmpty()) {
            int r = s.pop();
            int l = s.pop();
            int index = Parsort(arr, l, r);
            if ((index - 1) < l) {
                s.push(l);
                s.push(index - 1);
            }
            if ((index + 1) < r) {
                s.push(index + 1);
                s.push(r);
            }
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

    /**
     * 在一个二维数组中，每一列从上到下递增，没一行从左到右递增，输入一个数，判断数组中是否右该数
     *
     * @param a
     * @param target
     * @return
     */
    public static boolean finTargetIntegerInTwoBindTable(int[][] a, int target) {
        if (target > 2174783648.00 || target < -2147483648) {
            return false;
        }
        if (a == null) {
            return false;
        }

        int rows = a.length;
        int columns = a[0].length;

        if (rows > 0 && columns > 0) {
            int r = 0;
            int c = columns - 1;
            while (r < rows && c >= 0) {
                if (a[r][c] == target) {
                    return true;
                } else if (a[r][c] > target) {
                    --c;
                } else {
                    r++;
                }
            }
        }
        return false;
    }

    /**
     * 自然想法，遇到空格就替换成'20%'长度是n的字符串，遇到一个空格，就需要向后移动n个字符，所以时间复杂度为O（N^2）
     * <p>
     * 替换空格
     * 思路：使用双指针法
     * p1:指向字符串末尾（需要提前遍历一边str，数一下共有多少个空格）
     * p2:指向替换之后的字符串末尾
     * 然后指针一起向前跑，复制字符串，p1遇到空格，p2串添加'20%'，然后p1-1 p2-3继续向前跑
     *
     * @param str
     * @param size
     */
    public static String repalceBlankPlace(char[] str, int size) {
        if (str == null || size < 1) {
            return null;
        }

        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (str[i] == ' ') {
                cnt++;
            }
        }
        int p1 = size - 1;
        int p2 = size + 2 * cnt - 1;
        if (p2 > str.length) {
            throw new RuntimeException("Invalid args:str 有点小，不够装！");
        }
        while (p1 >= 0) {
            if (str[p1] == ' ') {
                str[p2--] = '0';
                str[p2--] = '2';
                str[p2--] = '%';
            } else {
                str[p2--] = str[p1];
            }
            p1--;
        }
        return new String(str);
    }


    /*******************************************************斐波那契数列**************************************************************/
    /**
     * 递归方法：有严重的效率问题，需要有很多的重复计算，重复求解子问题
     *
     * @param n
     * @return
     */
    public static long fib(int n) {
        return n < 2 ? (n < 1 ? 0 : 1) : fib(n - 1) + fib(n - 2);
    }

    /**
     * 循环算法
     * 线性时间求解子问题，避免重复求解
     *
     * @param n
     * @return
     */
    public static long fibonacci(int n) {
        if (n <= 0) return 0;
        if (n <= 1) return 1;
        long fibOne = 0, fibTwo = 1, fibN = 0;
        for (int i = 2; i <= n; i++) {
            fibN = fibOne + fibTwo;
            fibOne = fibTwo;
            fibTwo = fibN;
        }
        return fibN;
    }

    /*******************************************************海量数据中找出第K大数据**************************************************************/
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minQueue = new PriorityQueue<>();
        for (int num : nums) {
            if (minQueue.size() < k || num > minQueue.peek()) {
                minQueue.offer(num);
            }
            if (minQueue.size() > k) {
                minQueue.poll();
            }

        }
        return -1;
    }

    /*******************************************************单链表是否有环**************************************************************/
    /**
     * 不允许修改链表结构
     * 时间复杂度O(n),空间复杂度O（1）
     * 如果链表有环，那么在遍历链表时会陷入死循环，利用这个特征，我们可以设计使用一个slow指针，一个fast指针
     * slow指针一次往后遍历一个节点，fast指针一次往后遍历2个节点，
     * 如果fast指针在遍历过程中，遍历到了null节点，说明链表没有环
     * 否则当slow和fast指针相同，说明节点有环
     * <p>
     * 假定链表头到入口的距离为len，环入口到slow和fast的交汇点距离为x，环的长度为R，slow和fast相遇时slow走的长度为：d = len + x，fast走的长度为2d = len + nR + x;(n >= 1)
     * 2len + 2x = len +nR + x;(n >= 1)
     * len = nR -x;(n >= 1)
     * 因此使用一个cur指针指向链表头，一个inter节点指向第一次交汇点。
     * cur指针和inter指针一起往后遍历
     * cur指针和inter指针相等时，cur和inter指针指向的就是环的入口节点
     */
    public static ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = head.getNext();
            fast = fast.getNext().getNext();
            if (slow == fast) {
                ListNode cur = head;
                while (slow != cur) {
                    slow = slow.getNext();
                    cur = cur.getNext();
                }
                return cur;
            }
        }
        return null;
    }

}

