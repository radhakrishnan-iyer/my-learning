package com.learning.extra;

import java.util.ArrayList;
import java.util.List;

public class CycleInDirectedGraph {
    public static void main(String[] args) {
        List<Integer> adjList[] = new ArrayList[4];
        for(int i = 0;i<4;i++)
            adjList[i] = new ArrayList<>();
        adjList[0].add(1);
        adjList[0].add(2);
        adjList[1].add(2);
        adjList[2].add(0);
        adjList[2].add(3);
        adjList[3].add(3);
        System.out.println(hasCycle(adjList, 4)); // true
    }

    static boolean hasCycle(List<Integer> adjList[], int V) {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) {
            if(isCyclicUtil(adjList, visited, i)) {
                return true;
            }
        }
        return false;
    }

    static boolean isCyclicUtil(List<Integer> adjList[], boolean[] visited , int curr) {
        if(visited[curr])
            return true;
        visited[curr] = true;
        List<Integer> neighbors = adjList[curr];
        for(Integer n : neighbors) {
            if(isCyclicUtil(adjList, visited,n))
                return true;
        }
        visited[curr] = false;
        return false;
    }
}
