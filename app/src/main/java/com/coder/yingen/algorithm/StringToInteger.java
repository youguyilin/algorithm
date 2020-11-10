package com.coder.yingen.algorithm;

import android.text.method.SingleLineTransformationMethod;

/**
 * Create by Alex Chu on
 */
public class StringToInteger {

    public static void main(String[] args) {

        System.out.println("--" + myAtoi("  4193"));
    }

    public static int myAtoi(String str) {
        int i = 0;
        int sign = 1;
        int result = 0;
        if (str.length() == 0) return 0;
        while (i < str.length() && str.charAt(i) == ' ') i++;

        if (i < str.length() && (str.charAt(i) == '+' || str.charAt(i) == '-'))
            sign = (str.charAt(i++) == '-') ? -1 : 1;

        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && str.charAt(i) - '0' > Integer.MAX_VALUE % 10)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + (str.charAt(i++) - '0');
        }
        return result * sign;
    }
}
