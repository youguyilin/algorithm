package com.coder.yingen.algorithm;

import java.time.chrono.HijrahEra;

/**
 * Create by Alex Chu on
 */
public class ContainerWithMostWater {


    public int maxArea(int[] height) {
        int maxArea = 0;
        for (int i = 0; i < height.length; i++)
            for(int j = i; j < height.length; j++) {
                maxArea = Math.max(maxArea, Math.min(height[i],height[j]) * (j - i));
            }

        return maxArea;
    }


    public int maxAreaS(int[] height) {
        int maxArea = 0, l = 0, r = height.length -1;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l],height[r]) * (r- l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
