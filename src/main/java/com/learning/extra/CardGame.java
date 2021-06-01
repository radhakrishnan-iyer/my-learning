package com.learning.extra;

public class CardGame {
    public static void main(String[] args) {
        System.out.println(pickCard(new int[] {1, 1, 1, 1, 100}));
        System.out.println(pickCardWithoutDp(new int[] {1, 1, 1, 1, 100}));

        System.out.println(pickCard(new int[] {1, 2, -3, 8}));
        System.out.println(pickCardWithoutDp(new int[] {1, 2, -3, 8}));
    }

    public static int pickCard(int[] cards){
        int n = cards.length;
        if(n == 0) return 0;

        int dp[] = new int[n+4];
        // dp[i]: the max point can get if I start from index i first
        // init conditions
        dp[n-1] = cards[n-1];

        for(int i = n - 2 ; i >= 0 ; i--){
            for(int x:dp) {
                System.out.print(x + " ");
            }
            System.out.println();
            int choose_1 = cards[i] + MY_MIN(dp[i+2], dp[i+3], dp[i+4]);  // skip i+1 (opponent pick 1) or i+1~i+2 (opponent pick 2) or i+1~i+3 (opponent pick 3)
            int choose_2 = cards[i] + cards[i + 1] + MY_MIN(dp[i+3],dp[i+4],dp[i+5]);
            int choose_3 = i < n - 2 ? cards[i] + cards[i + 1] + cards[i + 2] + MY_MIN(dp[i+4],dp[i+5],dp[i+6]) : Integer.MIN_VALUE;
            dp[i] = MY_MAX(choose_1, choose_2, choose_3);
        }
        return dp[0];
    }

    public static int pickCardWithoutDp(int[] cards){
        int n = cards.length;
        if(n == 0) return 0;

        // dp[i]: the max point can get if I start from index i first
        // init conditions
        int dp1,dp2,dp3,dp4,dp5,dp6;
        dp6 = cards[n-1];
        dp2=dp3=dp4=dp1=dp5=0;
        int ans = 0;
        for(int i = n - 2 ; i >= 0 ; i--){
            System.out.print(dp1+" " + dp2 + " " + dp3 +" " + dp4 +" " + dp5);
            int choose_1 = cards[i] + MY_MIN(dp1, dp2, dp3);  // skip i+1 (opponent pick 1) or i+1~i+2 (opponent pick 2) or i+1~i+3 (opponent pick 3)

            int choose_2 = cards[i] + cards[i + 1] + MY_MIN(dp2,dp3,dp4);

            int choose_3 = i < n - 2 ? cards[i] + cards[i + 1] + cards[i + 2] + MY_MIN(dp3,dp4,dp5) : Integer.MIN_VALUE;
            ans = MY_MAX(choose_1, choose_2, choose_3);
            if(dp4 == 0) {
                dp4=ans;
            }
            else if(dp3==0) {
                dp3=ans;
            }
            else if(dp2==0) {
                dp2 = ans;
            }
            else if(dp1==0) {
                dp1 = ans;
            }
            else {
                dp1=dp2;
                dp2=dp3;
                dp3=dp4;
                dp4=dp5;
                dp5=ans;
            }
            System.out.println();
        }
        return ans;
    }

    private static int MY_MIN(int a, int b, int c) {
        return Math.min(a, Math.min(b,c));
    }

    private static int MY_MAX(int a, int b, int c) {
        return Math.max(a, Math.max(b,c));
    }
}
