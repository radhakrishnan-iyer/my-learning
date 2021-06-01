package com.learning.extra;

import java.util.Arrays;

public class MeetingRoom {
    public static void main(String[] args) {
        boolean[] result = meetingRoom(new int[][]{{1, 3}, {4, 6}, {6, 8}, {9, 11}, {6, 9}, {1, 3}, {4, 10}} , 3 , new int[][] {{1, 9}, {2, 6}, {7, 9}, {3, 5}, {3, 9}, {2, 4}, {7, 10}, {5, 9}, {3, 10}, {9, 10}});
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
    }

    private static boolean[] meetingRoom(int[][] calendar , int k , int[][] query) {
        Arrays.sort(calendar , (a,b) -> a[0] - b[0]);
        int n = calendar[calendar.length-1][1];
        int dp[] = new int[n+1];
        for(int i=0;i<calendar.length;i++) {
            int start = calendar[i][0];
            int end = calendar[i][1];
            while(start<end) {
                dp[start]++;
                start++;
            }
        }

        boolean[] result = new boolean[query.length];

        for(int i=0;i<query.length;i++) {
            int start = query[i][0];
            int end = query[i][1];

            while (start < end) {
                if (dp[start] >= k) {
                    result[i] = false;
                    break;
                }
                if (start == end-1)
                    result[i] = true;
                start++;
            }
        }
        return result;
    }
}
