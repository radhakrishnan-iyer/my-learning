package com.learning.extra;

public class ContainerProblem {

    public static void main(String[] args) {
        String s = "|**|*|*";
        System.out.println(count(0,4,s));
        System.out.println(count(0,5,s));

        s = "*|*|*|";
        System.out.println(count(0,5,s));
    }

    private static int count(int start , int end, String str) {
        String tmp = str.substring(start , end + 1);
        int startIdx = tmp.indexOf('|');
        int i = startIdx;
        int j = startIdx;
        int res = 0;
        while(i<=j && j<=end) {
            if(i!=j && str.charAt(j)=='|') {
                res += (j-1) - i;
                i=j;
                j++;
            } else
                j++;
        }
        return res;
    }
}
