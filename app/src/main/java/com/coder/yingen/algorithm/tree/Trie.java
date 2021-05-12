package com.coder.yingen.algorithm.tree;

/**
 * Created by Alex Chu on 2021/4/14.
 */
public class Trie {
    /**
     * 前缀树 是一种树型数据结构，用于高效地检索字符串数据集中的键值。入自动补充完和拼写检查
     * Trie() 初始化前缀对象
     * void insert(String word) 向前缀树中插入字符串 word。
     * boolean search(String word) 如果字符串word 在前缀树中，返回true （即，在检索之前已经插入）否则返回false
     * <p>
     * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为prefix，返回true， 否则返回false
     */

    int N = 100009;//直接设置为十万级
    int[][] trie;
    int[] count;
    int index;

    public Trie() {
        trie = new int[N][26];
        count = new int[N];
        index = 0;
    }

    public void insert(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) trie[p][u] = ++index;
            p = trie[p][u];
        }
        count[p]++;
    }

    public boolean search(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) return false;
            p = trie[p][u];
        }

        return count[p] != 0;
    }

    public boolean startWith(String s) {
        int p = 0;
        for (int i = 0; i < s.length(); i++) {
            int u = s.charAt(i) - 'a';
            if (trie[p][u] == 0) return false;
            p = trie[p][u];
        }
        return true;
    }

}
