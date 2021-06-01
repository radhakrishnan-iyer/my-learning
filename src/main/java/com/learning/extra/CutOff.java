package com.learning.extra;

import java.util.*;

public class CutOff {

    public static void main(String[] args) {
        System.out.print(cutOffRank(4, 5, new int[] {2,2,3,4,5}));
    }

    public static int cutOffRank(int cutOffRank, int num, int[] scores) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i2-i1;
            }
        });
        for(int i : scores) {
            pq.offer(i);
        }
        LinkedHashMap<Integer,int[]> map = new LinkedHashMap<>();
        int score = 1;
        while(!pq.isEmpty()) {
            Integer i = pq.poll();
            int[] arr = new int[2];
            if(map.size()>0) {
                Map.Entry<Integer,int[]> e = (Map.Entry<Integer,int[]>)map.entrySet().toArray()[map.size()-1];
                if(e.getKey()==i) {
                    arr = e.getValue();
                    arr[1]++;
                    map.put(i,arr);
                }
                else {
                    arr = new int[] {score , 1};
                    map.put(i,arr);
                }
            } else {
                arr = new int[] {score , 1};
                map.put(i , arr);
            }
            score++;
        }
        int res = 0;
        for(Map.Entry<Integer,int[]> e : map.entrySet()) {
            if(e.getValue()[0] <= cutOffRank)
                res += e.getValue()[1];
        }
        return res;
    }
}
