package com.learning.extra;

public class NStepsWithKLeaps {
    public static void main(String[] args) {
        int n = 29;
        int k = 5;
        System.out.println(numberOfWays(n , k));
    }

    private static int numberOfWays(int n , int k) {
        int table[] = new int[n+1];
        for(int i=0;i<=n;i++)
            table[i] = 1;

        for(int i=2;i<=k;i++) {
            for(int j=i;j<=n;j++) {
                table[j] += table[j-i];
            }
        }
        return table[n];
    }
}
