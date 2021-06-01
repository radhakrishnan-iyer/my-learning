package com.learning.extra;

public class Prims {
    static int v = 5;

    public static void main(String[] args) {
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        prims(graph);
    }
    private static void prims(int[][] graph) {
        boolean[] mstSet = new boolean[v];
        int[] wt = new int[v];
        int[] parent = new int[v];
        for(int i =0;i<v;i++) {
            wt[i]  = Integer.MAX_VALUE;
            parent[i] = -1;
        }
        wt[0] = 0;
        int count = 0;
        while (count < v-1) {
            int u = minWt(wt,mstSet);
            mstSet[u] = true;
            updateWt(u,wt,mstSet,graph, parent);
            count++;
        }

        printMST(parent, graph);
    }

    private static int minWt(int[] wt, boolean[] mstSet) {
        int min = Integer.MAX_VALUE;
        int minIndx = 0;
        for(int i=0;i<wt.length;i++) {
            if(!mstSet[i] && wt[i] < min) {
                min = wt[i];
                minIndx = i;
            }
        }
        return minIndx;
    }

    private static void updateWt(int src, int[] wt, boolean[] mstSet, int[][] graph, int[] parent) {
        int[] neighbors = graph[src];
        for(int i=0;i<neighbors.length;i++) {
            if(!mstSet[i] && neighbors[i]>0 && neighbors[i] < wt[i]) {
                parent[i] = src;
                wt[i] = neighbors[i];
            }
        }
    }

    private static void printMST(int[] parent, int[][] graph) {
        for(int i=1;i<v;i++) {
            System.out.println(parent[i] + " to " + i + " : " + graph[parent[i]][i]);
        }
    }
}
