package com.learning.extra;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DoubleBasePalindrome {

    public static void main(String[] args) {
        Pattern p = Pattern.compile("[a-z]*[A-Z]*[,!?.]*");
        Matcher m = p.matcher("hello");
        System.out.println(m.matches());
    }

    public static int solve(int n) {
        int res = 0;
        for(int i=1;i<n;i++)
        {
            if(isPallindrome(String.valueOf(i)) && isPallindrome(getNumberInGivenBase(i, 2)))
                res+=i;
        }
        return res;
    }

    private static boolean isPallindrome(String s) {
        Pattern p = Pattern.compile("[a-z]*[A-Z]*[,!?.]");
        Matcher m = p.matcher("hello?");
        System.out.println(m.matches());
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    private static String getNumberInGivenBase(int n, int k) {
        Stack<Integer> s = new Stack<>();
        while(n!=0)
        {
            s.push(n%k);
            n/=k;
        }
        StringBuffer sb = new StringBuffer();
        while(!s.isEmpty())
        {
            sb.append(s.pop());
        }
        return new String(sb);
    }

}
