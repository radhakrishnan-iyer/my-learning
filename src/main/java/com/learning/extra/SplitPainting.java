package com.learning.extra;

import java.util.*;

public class SplitPainting {

    public static void main(String[] args) {
        int[][] segment = new int[][]{
                {4,16,12},{9,10,15},{18,19,13},{3,13,20},{12,16,3},{2,10,10},{3,11,4},{13,16,6}       };
        System.out.println(splitPainting(segment));
    }

    private static List<List<Long>> splitPainting(int[][] segment) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0;i<segment.length;i++) {
            min = Math.min(min, segment[i][0]);
            max = Math.max(max, segment[i][1]);
        }
        long[] ans = new long[max+1];
        boolean[] end = new boolean[max+1];
        for(int i=0;i<segment.length;i++) {
            int[] current = segment[i];
            for(int j=current[0];j<current[1];j++) {
                ans[j] += current[2];
            }
            end[current[1]] = true;
        }
        int i = min;
        int j = min;
        List<List<Long>> result = new ArrayList<>();
        while(j<max) {
            while(j<max && ans[i]==ans[j] && !end[j])
                j++;
            if(ans[j-1]>0) {
                List<Long> temp = new ArrayList<>();
                temp.add((long)i);
                temp.add((long)j);
                temp.add(ans[j-1]);
                result.add(temp);
            }
            if(j<max && ans[i]==ans[j]) {
                i=j;
                j++;
            } else {
                i=j;
            }
        }
        return result;
    }
}
