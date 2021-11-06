package com.learning.extra;
import java.util.*;

public class CostEstimationOfWarehouse {

    public static void main(String[] args) {
        int[][] connected = new int[][]{
                {2,6},{3,5},{0,1},{2,9},{5,6}
        };
        int n = 10;
        /*int[][] connected = new int[][] {
                {0,2},{1,2}
        };
        int n = 4;*/
        System.out.println(solve(n , connected));
    }

    public static int solve(int n , int[][] connected) {
        int[] parent = new int[n];
        for(int i=0;i<n;i++)
            parent[i] = i;

        for(int j=0;j<2;j++) {
            for (int i = 0; i < connected.length; i++) {
                int[] current = connected[i];
                int x = find(current[0], parent);
                int y = find(current[1], parent);
                if (x != y) {
                    union(x, y, parent);
                }
            }
        }
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < parent.length; i++) {
            countMap.put(parent[i], countMap.getOrDefault(parent[i], 0) + 1);
        }
        int ans = 0;
        System.out.println(countMap);
        for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
            if (entry.getValue() > 1) {
                ans += Math.ceil(Math.sqrt(entry.getValue()));
            } else {
                ans += entry.getValue();
            }
        }

        return ans;
    }

    static int find(int x, int[] parent) {
        if(parent[x]!=x) {
            parent[x] = find(parent[x] , parent);
        }
        return parent[x];
    }

    static void union(int x, int y, int[] parent) {
        int xroot = find(x, parent);
        int yroot = find(y, parent);
        parent[xroot] = yroot;
    }
}
