package com.learning.extra;

public class JumpGameV {
    public static void main(String[] args) {
        System.out.println(maxJumps(new int[]{6,4,14,6,8,13,9,7,10,6,12} , 2));
    }

    static public int maxJumps(int[] arr, int d) {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++) {
            max = Math.max(max, maxJumpsRecursion(arr,d,  i));
        }
        return max;
    }

    static int maxJumpsRecursion(int[] arr, int d,  int pos) {
        if(pos<0 || pos>arr.length-1)
            return 0;

        int max = 1;
        for(int i=pos+1;i<=Math.min(pos+d,arr.length-1);i++) {
            if(arr[pos]<=arr[i]) {
                break;
            }
            max = Math.max(max, 1+maxJumpsRecursion(arr,d,i));
        }
        for(int i=pos-1;i>=Math.max(pos-d,0);i--) {
            if(arr[pos]<=arr[i]) {
                break;
            }
            max = Math.max(max, 1+maxJumpsRecursion(arr,d,i));
        }
        return max;
    }
}
