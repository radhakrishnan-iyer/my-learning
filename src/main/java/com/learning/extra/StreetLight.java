package com.learning.extra;

import java.util.*;

public class StreetLight {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{0, 5}, {1, 3}, {5, 4}, {8, 3}};
        int n = 10;
        System.out.println(findValidStreetLights(arr, n));
        arr = new int[][]{{2,3},{8,2}};
         n = 8;
        System.out.println(findValidStreetLights(arr, n));
    }

    static int findValidStreetLights(int[][] arr, int n) {
        List<int[]> list = new ArrayList<>();

        for(int i = 0;i<arr.length;i++) {
            int x = arr[i][0] - arr[i][1];
            int y = arr[i][0] + arr[i][1];
            x = x<0 ? 0 : x;
            y = y>10 ? n : y;
            list.add(new int[]{x,y});
        }
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0]-b[0];
            }
        });
        for(int i=1;i<list.size();i++) {
            if(list.get(i)[0] > list.get(i-1)[1]) {
                // remove ith element as it is not overlapping and hence cannot be candidate. Candidates are always overlapping
                list.remove(i);
            }
        }

        return solve(list, n, 0, 0 , 0);
    }

    static int solve(List<int[]> list, int n, int depth, int start, int coverage) {
        if(n == coverage) {
            return depth;
        }
        if( coverage > n) {
            return Integer.MAX_VALUE;
        }
        if(start >= list.size()) {
            return Integer.MAX_VALUE;
        }
        return Math.min(solve(list, n , depth+1 , start+1, coverage + list.get(start)[1] - Math.max(coverage , list.get(start)[0]))  , solve(list, n , depth , start+1, coverage));
    }

}
