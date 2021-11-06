package com.learning.extra;

public class BinaryQuestion {

    private static int solve(int n) {
        return solve(n-1, 0) + solve(n-1 , 1);
    }

    // this can be memoized to improve time complexity
    private static int solve(int n , int i) {
        if(n==0)
            return 1;

        if(i==0) {
            return solve(n-1,1);
        }

        return solve(n-1, 0) + solve(n-1, 1);
    }

    public static void main(String args[]) {
        System.out.println(solve(4)); // ans = 8
        // combinations when n = 4
        /*
        1110
        1111
        1011
        1010
        1110
        0110
        0101
        0111*/

        System.out.println(solve(3)); // ans = 8

    }
}
