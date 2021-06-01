package com.learning.extra;

import java.util.*;

public class SlidingWindowFirstNegative {
    public static void main(String[] args) {
        System.out.println(solve(new int[] {5 , -1 , -7, 3 , 4 , 1 , -2 , 1}, 3)); // [-1 , -1 , -7 , 0 , -2 , -2]
    }

    private static List<Integer> solve(int[] arr, int k) {
        int start = 0;
        int end = 0;
        List<Integer> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        while (end < arr.length) {
            // calculation
            if(arr[end] < 0) {
                temp.add(arr[end]);
            }
            if(end-start < k) {
                //end++
                end++;
            }
            if(end-start == k) {
                //ans
                if(temp.size() > 0)
                    ans.add(temp.get(0));
                else
                    ans.add(0);
                //slide
                if(arr[start] < 0) {
                    temp.remove(0);
                }
                start++;
            }
            /*while (end < arr.length && end-start+1 <= k) {
                if(arr[end] < 0) {
                    temp.add(arr[end]);
                }
                end++;
            }
            if(temp.size() > 0)
                ans.add(temp.get(0));
            else
                ans.add(0);
            if(end-start+1 > k) {
                if(arr[start] < 0) {
                    temp.remove(0);
                }
                start++;
            }*/
        }
        return ans;
    }
}
