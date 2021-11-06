package com.learning.extra;

import java.util.*;

public class FlightLandProblem {

    public static void main(String[] args) {
        System.out.println(foo(90, Arrays.asList(1,10,25,35,60)));
    }

    private static List<Integer> getList(int a, int b) {
        List<Integer> dList = new ArrayList<Integer>(2);
        dList.add(a < b ? a : b);
        dList.add(a < b ? b : a);
        return dList;
    }

    private static List<Integer> getStrList(int a, int b) {
        List<Integer> dList = new ArrayList<Integer>(2);
        dList.add(a);
        dList.add(b);
        return dList;
    }

    public static List<Integer> foo(int flightDuration, List<Integer> movieDuration) {
        // Write your code here
        int targetDuration = flightDuration - 30;
        if (targetDuration < 0) {
            return getList(-1, -1);
        }

        List<List<Integer>> sorted = new ArrayList<>(movieDuration.size());
        for(int i=0; i<movieDuration.size(); i++) {
            sorted.add(getStrList(movieDuration.get(i), i));
        }

        //Sort the list because we want the largest movie, but smallest index
        sorted.sort(new Comparator<List<Integer>>() {
            public int compare(List<Integer> a, List<Integer> b) {
                return a.get(0).equals(b.get(0)) ? a.get(1).compareTo(b.get(1)) : b.get(0).compareTo(a.get(0));
            }
        });

        for(int j=0; j<sorted.size(); j++) {
            int curr = sorted.get(j).get(0);
            int currIndex = sorted.get(j).get(1);
            for(int k = 0; k<movieDuration.size(); k++) {
                if(movieDuration.get(k) == targetDuration - curr && k!=currIndex) {
                    return getList(currIndex, k);
                }
            }
        }

        return getList(-1, -1);
    }
}
