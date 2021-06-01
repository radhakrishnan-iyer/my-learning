package com.learning.extra;

import java.util.*;

public class Generated16Digit {
    static List<int[]> result = new ArrayList<>();
    static int[] primeArray = new int[]{2,3,5,7};
    static int[] evenArray = new int[]{0,2,4,6,8};
    static int size = 4; // this should be 16 for testing I'm setting it to 4

    public static void main(String[] args) {
        generateAll();
        System.out.println(result.size());
    }

    static void  generateAll() {
        int[] arr = new int[size];
        for(int j=0;j<size;j++)
            arr[j] = Integer.MAX_VALUE;
        solve(0,arr);
    }

    static void solve(int pos ,  int[] list) {
        if(isValid(list)) {
            int[] x = new int[list.length];
            for(int i=0;i<list.length;i++)
                x[i] = list[i];
            result.add(x);
            return;
        }

        if (pos % 2 == 0) {
            for(int i=0;i<evenArray.length;i++) {
                int temp = list[pos];
                list[pos] = evenArray[i];
                solve(pos+1,  list);
                list[pos] = temp;
            }
        } else {
            for(int i=0;i<primeArray.length;i++) {
                int temp = list[pos];
                list[pos] = primeArray[i];
                solve(pos+1, list);
                list[pos] = temp;
            }
        }

    }

    private static boolean isValid(int[] list) {
        for(int i=0;i<list.length;i++) {
            if(list[i]==Integer.MAX_VALUE)
                return false;
        }
        return true;
    }
}
