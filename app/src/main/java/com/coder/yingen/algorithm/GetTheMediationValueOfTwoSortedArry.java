package com.coder.yingen.algorithm;

/**
 * Create by Alex Chu on
 */
public class GetTheMediationValueOfTwoSortedArry {

    public static void main(String[] args) {

    }

    public double findMediationValOfSortedArrays(int[] nums1, int[] num2) {
        int m = nums1.length;
        int n = num2.length;
        if (m > n) {//ensure m <= n
            int[] temp = nums1;
            nums1 = num2;
            num2 = temp;
            int tem = m;
            m = n;
            n = m;
        }
        int imin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (imin <= iMax) {
            int i = (imin + iMax) / 2;
            int j = halfLen - i;
            if (i < iMax && num2[j - 1] > nums1[i]) {
                imin = i + 1; //i is too samll
            } else if (i > imin && nums1[i - 1] > num2[j]) {
                iMax = i - 1;// i is too big
            } else {//i is perfect
                int maxleft = 0;
                if (i == 0) {
                    maxleft = num2[j - 1];
                } else if (j == 0) {
                    maxleft = nums1[i - 1];
                } else {
                    maxleft = Math.max(nums1[i - 1], num2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxleft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = num2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight = Math.min(num2[j], nums1[i]);
                }

                return (maxleft + minRight) / 2.0;

            }
        }
        return 0.0;
    }
}
