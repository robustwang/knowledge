package com.robustwang.example.algorithm.leecode;

import java.util.ArrayList;
import java.util.List;

public class Reroute {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] e = new List[n];
        for (int i = 0; i < n; i++) {
            e[i] = new ArrayList<int[]>();
        }
        for (int[] edge : connections) {
            e[edge[0]].add(new int[]{edge[1], 1});
            e[edge[1]].add(new int[]{edge[0], 0});
        }
        return dfs(0, -1, e);
    }

    public int dfs(int x, int parent, List<int[]>[] e) {
        int res = 0;
        for (int[] edge : e[x]) {
            if (edge[0] == parent) {
                continue;
            }
            res += edge[1] + dfs(edge[0], x, e);
        }
        return res;
    }

    public static void main(String[] args) {
        Reroute rr = new Reroute();
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        int result =  rr.minReorder(6, connections);
        System.out.println(result);
    }
}