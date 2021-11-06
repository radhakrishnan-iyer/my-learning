package com.learning.extra;

public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(countAndSay(4));
    }

    public static String countAndSay(int n) {
        if(n<1)
            return "";
        if(n==1)
        {
            return "1";
        }

        String temp = countAndSay(n-1);
        int count = 1;
        char prev = temp.charAt(0);
        StringBuilder sb = new StringBuilder();
        for(int i=1;i<temp.length();i++) {
            if(temp.charAt(i)==prev) {
                count++;
            } else {
                sb.append(count).append(prev);
                prev = temp.charAt(i);
                count = 1;
            }
        }
        sb.append(count).append(prev);
        return sb.toString();
    }
}
