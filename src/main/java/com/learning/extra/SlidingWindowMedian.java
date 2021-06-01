package com.learning.extra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class SlidingWindowMedian {

    public static void main(String[] args) {
        medianSlidingWindow(new int[]{2147483647,2147483647} ,2);
    }

    public static double[] medianSlidingWindow(int[] nums, int k) {
        double[] result = new double[nums.length-k+1];
        int index = 0;
        MedianFinder medianFinder = new MedianFinder();
        for(int i=0;i<=nums.length-k;i++) {
            for(int j=i;j<i+k;j++) {
                medianFinder.addNum(nums[j]);
            }
            result[index++] = medianFinder.findMedian();
            medianFinder.removeAll();
        }
        return result;
    }

    static class MedianFinder {

        /** initialize your data structure here. */

        PriorityQueue<Long> lo = new PriorityQueue<Long>(new Comparator<Long>() {
            @Override
            public int compare(Long i1 , Long i2) {
                return i2.intValue()-i1.intValue();
            }
        });

        PriorityQueue<Long> hi = new PriorityQueue<Long>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            lo.add(new Long(num));
            hi.add(lo.peek());
            lo.poll();

            if(hi.size() > lo.size()) {
                lo.add(hi.peek());
                hi.poll();
            }
        }

        public double findMedian() {
            if(lo.size() > hi.size()) {
                return lo.peek();
            }
            return (lo.peek() + hi.peek())/2.0;
        }

        public void removeAll() {
            lo.clear();
            hi.clear();
        }
    }

}
