package com.coder.yingen.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Alex Chu on 2021/5/18.
 */
public class LongestSubString {

    public int lengthofLongestSubString(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.keySet().contains(alpha)) {
                start = Math.max(map.get(alpha), start);
            }

            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}
