package com.learning.extra;

public class OptimalScore {

    static int topAnsForFirst = 0;
    static int topAnsForSecond = 0;
    public static void main(String[] args) {
        solve(new int[]{100,1,1,1,1,5,100} , 0 , true);
        System.out.println(topAnsForFirst);
        System.out.println(topAnsForSecond);
    }

    /*static void solve(int[] arr, int m, boolean flag) {
        if(m>=arr.length)
            return;
        int ansWhenFirstElementIsPicked = arr[m];
        int ansWhenSecondElementIsPicked = 0;
        int ansWhenThirdElementIsPicked = 0;
        if(m+1<=arr.length-1) {
            ansWhenSecondElementIsPicked = arr[m] + arr[m+1];
        }
        if(m+2<=arr.length-1) {
            ansWhenThirdElementIsPicked = arr[m] + arr[m+1] + arr[m+2];
        }
        if(flag) {
            topAnsForFirst = Math.max(Math.max(topAnsForFirst+ansWhenFirstElementIsPicked, topAnsForFirst+ansWhenSecondElementIsPicked),topAnsForFirst+ansWhenThirdElementIsPicked);
        } else {
            topAnsForSecond = Math.max(Math.max(topAnsForSecond+ansWhenFirstElementIsPicked, topAnsForSecond+ansWhenSecondElementIsPicked),topAnsForSecond+ansWhenThirdElementIsPicked);
        }

        if(ansWhenFirstElementIsPicked > ansWhenSecondElementIsPicked && ansWhenFirstElementIsPicked > ansWhenThirdElementIsPicked) {
            solve(arr, m + 1, !flag);
        }
        else if(ansWhenSecondElementIsPicked >  ansWhenFirstElementIsPicked && ansWhenSecondElementIsPicked > ansWhenThirdElementIsPicked) {
            solve(arr, m + 2, !flag);
        } else {
            solve(arr, m + 3, !flag);
        }
    }*/

    static int solve(int[] arr, int idx, boolean turn) {
        if(idx >= arr.length)
            return 0;
        int sum = 0;
        for(int i=idx;i<arr.length;i++)
            sum += arr[i];
        if(turn) {
            int first = 0;
            int temp = 0;
            for(int i=0;i<3 && idx+i<arr.length ; i++) {
                temp += arr[idx+i];
                first = Math.max(first, temp + solve(arr, idx+i+1, !turn));
                topAnsForFirst = Math.max(topAnsForFirst , first);
                int second = sum - first;
                topAnsForSecond = Math.max(topAnsForSecond, second);
                //System.out.println(first + " : " + second);
            }
            return first;
        } else {
            int second = 0;
            int temp = 0;
            for(int i=0;i<3 && idx+i<arr.length ; i++) {
                temp += arr[idx+i];
                second = Math.max(second, temp + solve(arr, idx+i+1, !turn));
                int first = sum - second;
                topAnsForFirst = Math.max(topAnsForFirst , first);
                topAnsForSecond = Math.max(topAnsForSecond, second);
                //System.out.println(first + " : " + second);
            }
            return sum-second;
        }
    }
}
