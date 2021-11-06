package com.learning.extra;

import java.util.Arrays;
import java.util.Comparator;

public class EventScheduling {

    public static void main(String[] args) {
        //System.out.println(scheduleEvents(new int[]{1,3,3,5,7} , new int[] {2,2,1,2,1}));
        //System.out.println(scheduleEvents(new int[]{1,3,5} , new int[] {2,2,2}));
        System.out.println(scheduleEvents(new int[]{1,3,3,3,5,7} , new int[] {2,2,1,3,2,1}));
    }

    static int scheduleEvents(int[] arrival, int[] duration) {
        int[][] intervals = new int[duration.length][2];
        for(int i=0;i<arrival.length;i++) {
            intervals[i] = new int[]{arrival[i] , arrival[i]+duration[i]};
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[1]-b[1];
            }
        });
        int count = 1;
        int[] previous = intervals[0];
        for(int i=1;i<intervals.length;i++) {
            if(previous[1]>intervals[i][0])
                continue;
            count++;
            previous = intervals[i];
        }
        return count;
    }
}
