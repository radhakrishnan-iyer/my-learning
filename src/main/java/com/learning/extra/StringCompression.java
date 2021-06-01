package com.learning.extra;

public class StringCompression {

    public static void main(String[] args) {
        System.out.println(compress(new char[]{'a','a','b','b','c','c','c'}));
    }

    private static int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
        int start=0;
        int end=0;
        while(start<chars.length && end<chars.length) {
            char c = chars[start];
            int count = 0;
            while(end<chars.length && chars[end]==c) {
                count++;
                end++;
            }
            sb.append(c+"");
            sb.append(count+"");
            start=end;
        }
        return sb.toString().length();
    }
}
