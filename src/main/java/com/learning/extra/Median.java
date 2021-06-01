package com.learning.extra;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Median {
    class MedianFinder {

        /** initialize your data structure here. */

        PriorityQueue<Integer> lo = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer i1 , Integer i2) {
                return i2-i1;
            }
        });

        PriorityQueue<Integer> hi = new PriorityQueue<Integer>();

        public MedianFinder() {

        }

        public void addNum(int num) {
            lo.add(num);
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
    }
}
