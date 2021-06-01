package com.learning.extra;

import java.util.ArrayList;
import java.util.List;

public class CycleInUnDirectedGraph {
    public static void main(String[] args) {
        List<Integer> adjList[] = new ArrayList[5];
        for(int i = 0;i<5;i++)
            adjList[i] = new ArrayList<>();
        adjList[0].add(1);
        //adjList[0].add(2);
        //adjList[0].add(3);
        adjList[1].add(0);
        adjList[1].add(2);
        //adjList[2].add(0);
        adjList[2].add(1);
        //adjList[2].add(0);
        //adjList[2].add(3);
        //adjList[3].add(0);
        //adjList[3].add(2);
        adjList[3].add(4);
        adjList[4].add(3);
        System.out.println(hasCycle(adjList, 5)); // true
    }

    static boolean hasCycle(List<Integer> adjList[], int V) {
        boolean[] visited = new boolean[V];
        for(int i=0;i<V;i++) {
            if(!visited[i])
                if(isCyclicUtil(adjList, visited, i, -1)) {
                    return true;
                }
        }
        return false;
    }

    static boolean isCyclicUtil(List<Integer> adjList[], boolean[] visited , int curr, int parent) {
        visited[curr] = true;
        List<Integer> neighbors = adjList[curr];
        for(Integer n : neighbors) {
            if(!visited[n]) {
                if (isCyclicUtil(adjList, visited, n, curr))
                    return true;
            }
            else if(parent!=n)
                return true;
        }
        return false;
    }
}
