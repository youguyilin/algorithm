package com.coder.yingen.algorithm.tree;

import android.text.BoringLayout;

import java.util.List;

/**
 * Created by Alex Chu on 2021/5/27.
 */
public class DBFSDemo {
    boolean[] vis;
    int num;

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        num = 0;
        vis = new boolean[n];
        dfs(rooms, 0);
        return num == n;
    }

    private void dfs(List<List<Integer>> rooms, int i) {
        vis[i] = true;
        num++;
        for (int it: rooms.get(i)) {
            if (!vis[i]) {
                dfs(rooms,i);
            }
        }
    }
}
