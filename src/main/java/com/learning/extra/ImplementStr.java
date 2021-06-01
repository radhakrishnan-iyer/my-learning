package com.learning.extra;

public class ImplementStr {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi" , "issip"));
    }

    private static int strStr(String haystack, String needle) {
        if(needle==null || needle.length()==0)
            return 0;
        int start = 0;
        int i=0;
        for(i=0;i<haystack.length();) {
            if(start >0 && haystack.charAt(i) != needle.charAt(start)) {
                start = 0;
                if(i>0) {
                    i--;
                } else {
                    i++;
                }
                continue;
            }
            else if(haystack.charAt(i) == needle.charAt(start)) {
                start++;
                i++;
                System.out.println("i:" + i + " Start " + start);
            }
            if(start==needle.length())
                break;
        }
        if(start==needle.length())
            return i-needle.length()+1;
        return -1;
    }
}
