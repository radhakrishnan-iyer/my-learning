package com.learning.extra;

public class ValidCoupon {

    public static void main(String[] args) {
        System.out.println(isValid("aabb"));
    }

    static boolean isValid(String s) {
        if(s.length()==0)
            return true;
        return isValid(s, 0 , s.length()-1);
    }

    static boolean isValid(String s, int i, int j) {
        if(i>=j)
            return false;
        if(isPalindrome(s, i, j))
            return true;

        for(int k=i;k<j;k++) {
            if(isValid(s, i , k) && isValid(s, k+1 , j))
                return true;
        }
        return false;
    }

    static boolean isPalindrome(String s, int i, int j) {
        while(i<j) {
            if(s.charAt(i)!=s.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}
