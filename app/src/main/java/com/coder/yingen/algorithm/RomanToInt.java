package com.coder.yingen.algorithm;

import java.lang.invoke.MethodHandles;

/**
 * Create by Alex Chu on 2020-09-03
 */
public class RomanToInt {
    public static void main(String[] args) {
        System.out.println(new RomanToInt().romanToInt("LVIII"));
    }

    public RomanToInt() {
        lookUp['I'] = 1;
        lookUp['V'] = 5;
        lookUp['X'] = 10;
        lookUp['L'] = 50;
        lookUp['C'] = 100;
        lookUp['D'] = 500;
        lookUp['M'] = 1000;
    }

    private int[] lookUp = new int[255];


    public  int romanToInt(String s){
        int value = 0;
        int result = 0;
        char next;
        char current;
        int length = s.length();
        for (int i =0; i < length; i++) {
            current = s.charAt(i);
            next = i < length -1 ? s.charAt(i+1) : '?';
            if ((current == 'I' && (next == 'V' || next == 'X')) ||
                    (current == 'X' && (next == 'L' || next == 'C')) ||
                    (current == 'C' && (next == 'D' || next == 'M'))
            ) {
                value = lookUp[next] - lookUp[current];
                i++;
            } else {
                value = lookUp[current];
            }
            result += value;
        }
        return result;
    }
}
