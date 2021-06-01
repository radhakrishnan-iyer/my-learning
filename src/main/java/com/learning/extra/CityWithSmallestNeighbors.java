package com.learning.extra;

import java.util.*;
public class CityWithSmallestNeighbors {

    public static void main(String[] args) {
         System.out.println(findTheCity(5, new int[][]{{0,1,2},{0,4,8},{1,2,3},{1,4,2},{2,3,1},{3,4,1}},2));
    }

    public static int findTheCity(int n, int[][] edges, int distanceThreshold) {
        Queue<int[]> q = new PriorityQueue(new Comparator<int[]>(){
            @Override
            public int compare(int[] e1, int[] e2) {
                return e1[1]==e2[1] ? e2[0]-e1[0] : e1[1]-e2[1];
            }
        });

        List<Item> adjList[] = new ArrayList[n];
        for(int i=0;i<n;i++)
            adjList[i] = new ArrayList();

        for(int i=0;i<edges.length;i++) {
            int[] currentElement = edges[i];
            adjList[currentElement[0]].add(new Item(currentElement[1] , currentElement[2]));
            adjList[currentElement[1]].add(new Item(currentElement[0] , currentElement[2]));
        }

        for(int i=0;i<n;i++) {
            int count = bfs(i, adjList,distanceThreshold);
            System.out.println(i+" : " + count);
            q.offer(new int[]{i,count});
        }
        return q.poll()[0];
    }

    private static int bfs(int start , List<Item> adjList[], int distanceThreshold) {
        Queue<int[]> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.offer(new int[]{start,0});
        seen.add(start);
        int count = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            for(int j=0;j<size;j++) {
                int[] currentElement = q.poll();
                //System.out.println(currentElement[0]+ " : " + currentElement[1]);
                List<Item> neighbors = adjList[currentElement[0]];
                System.out.println(neighbors);
                for(Item i : neighbors) {
                    if(seen.contains(i.dest) || i.wt+currentElement[1] > distanceThreshold)
                        continue;
                    q.offer(new int[]{i.dest,i.wt+currentElement[1]});
                    seen.add(i.dest);
                    count++;
                }
            }
        }
        return count;
    }

    static class Item {
        int dest;
        int wt;
        Item(int dest,int wt) {
            this.dest = dest;
            this.wt = wt;
        }
        public String toString() {
            return this.dest+ " : " + this.wt;
        }
    }
}
