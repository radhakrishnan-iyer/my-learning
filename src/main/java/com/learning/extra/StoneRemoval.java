package com.learning.extra;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class StoneRemoval {
    public static void main(String[] args) {
        //int[] piles = new int[] {8011,8387,6007,1235,5595,138,3136,1740,963,9412,802,4475,9695,3713,1742,8559,2237,4356,4012,3449,990,6930,523,931,5937,5902,2817,4088,385,1359,1888,1106,416,670,347,6113,4190,2094,2575,3011,8571,32,6318,9658,708,4061,2481,595,69};
        //int k = 93;
        //Map<String,Integer> dp = new HashMap<>();
        //System.out.println(solveWithMemo(piles , k , dp));
        String s = "[[]][]";
        System.out.println(s.substring(1,s.length()-1));
    }

    static int solveWithMemo(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o2, o1);
            }
        });
        for(int i : piles) {
            pq.offer(i);
        }
        while(k>0) {
            int x = pq.poll();
            int y = x&1;
            if(y==1) {
                //odd
                pq.offer(x/2 + 1);
            }
            else {
                pq.offer(x/2);
            }
        }
        int count = 0;
        while(!pq.isEmpty()) {
            count += pq.poll();
        }
        return count;
    }
}
