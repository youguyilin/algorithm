package com.coder.yingen.algorithm;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.coder.yingen.algorithm.listnode.ListNode;
import com.coder.yingen.algorithm.tree.ConstructTreeFromBV;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

import javax.crypto.Cipher;

/**
 * Created by chuyingen on 2018/4/13.
 * email youguyilin@126.com.
 */

public class algorithm {
    public algorithm() {
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1, 3, 5, 6, 9, 0, 8, 7};
        sortASC(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.println(i);
        }

        String str = longestPalindrome("aacabdkacaa");
        System.out.println(str + "----");
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

    public static void swap(int[] arr, int start, int end) {
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
     * 平均调用栈高度为O(logn),最差高度为O（n）,不管那种每一层的处理时间都是O（n）
     **/
    public static void sortASC(int[] arr, int low, int heigh) {
        if (arr == null || arr.length == 0 || low < 0 || heigh > arr.length - 1) {
            return;
        }
        int start = low;
        int end = heigh;
        int standardVal = arr[start];
        while (end > start) {
            while (end > start && arr[end] >= standardVal) {
                end--;
            }
            while (end > start && arr[start] <= standardVal) {
                start++;
            }
            if (end > start) {
                swap(arr, end, start);
            }
        }

        swap(arr, low, start);

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
    public int leftAndRightindicator(int[] arr, int left, int right) {
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
        return left;

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
     * 利用栈保存左右存储空间
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
     * 在一个二维数组中，每一列从上到下递增，没一行从左到右递增，输入一个数，判断数组中是否有该数
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
            slow = slow.getNext();
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

    /*******************************************************最长公共子序列问题**************************************************************/
    public static String longestCommonSubSequence(String text1, String text2) {
        int M = text1.length();
        int N = text2.length();
        int maxLen = 0, maxEnd = 0;
        int[][] dp = new int[M][N];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    }
                } else {
                    dp[i][j] = 0;
                }

                if (dp[i][j] > maxLen) {
                    maxLen = dp[i][j];
                    maxEnd = i;
                }
            }
        }
        return text1.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /*******************************************************最长公共子序列问题（回文问题）**************************************************************/
    public static String longestPalindrome(String s) {
        if (s.equals("")) {
            return "";
        }
        String origin = s;
        String reverse = new StringBuffer(s).reverse().toString();
        int length = s.length();
        int[] arr = new int[length];
        int maxLen = 0;
        int maxEnd = 0;
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (origin.charAt(i) == reverse.charAt(j)) {
                    if (i == 0 || j == 0) {
                        arr[j] = 1;
                    } else {
                        arr[j] = arr[j - 1] + 1;
                    }
                } else {
                    arr[j] = 0;
                }
                if (arr[j] > maxLen) {
                    int beforeRev = length - 1 - j;
                    if (arr[j] - 1 + beforeRev == i) {
                        maxLen = arr[j];
                        maxEnd = i;
                    }
                }
            }
        }
        return s.substring(maxEnd - maxLen + 1, maxEnd + 1);
    }

    /*******************************************************合并链表**************************************************************/

    /**
     * 递归合并有序单链表
     *
     * @param node1
     * @param node2
     * @return
     */
    public static ListNode mergeTwoList(ListNode node1, ListNode node2) {
        if (node1 == null && node2 == null) {
            return null;
        }
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode node = null;
        if (node1.getValue() > node2.getValue()) {
            //把head 较小的结点给头结点
            node = node2;
            node.setNext(mergeTwoList(node1, node2.getNext()));
        } else {
            node = node1;
            node.setNext(mergeTwoList(node1.getNext(), node2));
        }
        return node;
    }

    public static ListNode mergeTwoListNode2(ListNode node1, ListNode node2) {
        if (node1 == null || node2 == null) {
            return node1 != null ? node1 : node2;
        }
        ListNode node = node1.getValue() < node2.getValue() ? node1 : node2;
        ListNode cur1 = node1 == node ? node1 : node2;
        ListNode cur2 = node1 == node ? node2 : node1;

        ListNode pre = null; //cur1 前一个元素
        ListNode next = null;//cur2 的后一个元素

        while (cur1 != null && cur2 != null) {
            //第一次进if里
            if (cur1.getValue() <= cur2.getValue()) {
                pre = cur1;
                cur1 = cur1.getNext();
            } else {
                next = cur2.getNext();
                pre.setNext(cur2);
                cur2.setNext(cur1);
                pre = cur2;
                cur2 = next;
            }
        }

        pre.setNext(cur1 == null ? cur2 : cur1);
        return next;

    }
    /*******************************************************螺旋矩阵**************************************************************/
    /**
     * 给你一个正整数，生成一个1到n2所有元素，且元素按顺时针顺序螺旋排列的n * n正方形矩阵matrix
     *
     * @param n
     * @return
     */
    public static int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int tar = n * n;
        int num = 1;
        while (num <= tar) {
            for (int i = 1; i <= r; i++) mat[t][i] = num++;
            t++;
            for (int i = t; i <= b; i++) mat[i][r] = num++;
            r--;
            for (int i = r; i >= l; i--) mat[b][i] = num++;
            b--;
            for (int i = b; i >= t; i--) mat[i][l] = num++;
            l++;
        }
        return mat;
    }

    /*******************************************************Z 字形变换**************************************************************/
    public static String ConvertStringToZ(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRows = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRows).append(c);
            if (curRows == 0 || curRows == numRows - 1) {
                goingDown = !goingDown;
            }
            curRows += goingDown ? 1 : -1;
        }

        StringBuilder str = new StringBuilder();
        for (StringBuilder builder : rows) str.append(builder);
        return str.toString();
    }

    /*******************************************************删除链表的倒数第N个节点，一次遍历**************************************************************/
    public com.coder.yingen.algorithm.link.ListNode removeNthFromEnd(com.coder.yingen.algorithm.link.ListNode head, int n) {
        com.coder.yingen.algorithm.link.ListNode dummyHead = new com.coder.yingen.algorithm.link.ListNode(0);
        dummyHead.next = head;
        com.coder.yingen.algorithm.link.ListNode p = dummyHead;
        com.coder.yingen.algorithm.link.ListNode q = dummyHead;
        for (int i = 0; i < n + 1; i++) {
            q = q.next;
        }
        while (q != null) {
            p = p.next;
            q = q.next;
        }
        com.coder.yingen.algorithm.link.ListNode deletNode = p.next;
        p.next = deletNode.next;
        return dummyHead.next;
    }

    /*******************************************************二分查找 有序数组 返回位置下标**************************************************************/
    public int[] searchRange(int[] nums, int target) {
        int leftIdx = binarySearchC(nums, target, true);
        int rightIdx = binarySearchC(nums, target, false) - 1;
        if (leftIdx <= rightIdx && rightIdx < nums.length && nums[leftIdx] == target
                && nums[rightIdx] == target) {
            return new int[]{leftIdx, rightIdx};
        }
        return new int[]{-1, -1};
    }

    private int binarySearchC(int[] nums, int target, boolean lower) {
        int left = 0, right = nums.length - 1, ans = nums.length;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target || (lower && nums[mid] >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    /*******************************************************最小的k个数**************************************************************/
    //保持堆的大小位k，然后遍历数组中的数字，遍历的时候做如下的判断：
    //1。 若目前堆的大小(空间)小于k，将当前数字放入堆中，
    //2。 否则判端当前数字和大根堆堆顶元素的大小关系，如果比当前堆顶打，这个数跳过，
    // 如果小，poll堆顶元素，再将该数字放入堆中。
    //使用大根堆，时间复杂度是 O(NlogK)O(NlogK)
    //使用小根堆，需要将所有的元素入堆，时间复杂堆是O(NlogN)O(NlogN)
    @RequiresApi(api = Build.VERSION_CODES.N)
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0)
            return new int[0];
        //默认是小根堆，实现大根堆，需要重写一下比较器
        Queue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer v1, Integer v2) {
                return v2 - v1;
            }

        });
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (pq.peek() > num) {
                pq.peek();
                pq.offer(num);
            }
        }
        int[] result = new int[pq.size()];
        int idx = 0;
        for (int n : pq) {
            result[idx++] = n;
        }
        return result;
    }

    /*******************************************************滑动窗口最大值**************************************************************/
    //最大堆（优先队列）
    //可以使用最大堆的数据结构来保存元素，堆顶元素即为当前堆的最大值，并判断当前堆顶元素是否在窗口中，在则直接返回，不在则删除堆顶元素并调整堆
    @RequiresApi(api = Build.VERSION_CODES.N)
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        //这里传入一个比较器，当两者值相同时，比较下标的位置，下标大的在前面
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] != p2[0] ? p2[0] - p1[0] : p2[1] - p1[1];
            }
        });
        //初始化 前k的元素到堆中
        for (int i = 0; i < k; i++) {
            queue.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        //将第一次答案加入数据
        ans[0] = queue.peek()[0];
        for (int i = k; i < n; i++) {
            //将新元素加入优先队列
            queue.offer(new int[]{nums[i], i});
            //循环判断当前队列是否在窗口中，窗口左边界为i-k
            while (queue.peek()[1] <= i - k) {
                queue.poll();
            }
            //在窗口中直接赋值
            ans[i - k + 1] = queue.peek()[0];
        }
        return ans;
    }
}

