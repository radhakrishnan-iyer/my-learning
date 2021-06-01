package com.learning.extra;

import java.util.Comparator;
import java.util.concurrent.ConcurrentSkipListMap;

public class Concurrency {
    public static void main(String[] args) {
        ConcurrentSkipListMap<Integer,String> concurrentSkipListMap = new ConcurrentSkipListMap<Integer, String>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        });
    }
}
