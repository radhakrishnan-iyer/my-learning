package com.learning.extra;

public class KMP {
    static int[] lps;

    public static void main(String[] args) {
        String pat = "abcabcabc";
        String text = "ABABDABACDABABCABAB";
        kmp(pat, text);
    }

    private static void kmp(String pat, String text) {
        lps = new int[pat.length()];
        computeLPS(pat);
        for(int i =0 ;i <lps.length;i++)
            System.out.print(lps[i]+" ");
        System.out.println();
        int i = 0;
        int j = 0;
        while(i<text.length()) {
            if(text.charAt(i)==pat.charAt(j)) {
                i++;
                j++;
            }
            if(j==pat.length()) {
                System.out.println("Pattern found at : " + (i-j));
                j = lps[j-1];
            }
            else if(i<text.length() && text.charAt(i) != pat.charAt(j)) {
                if(j!=0) {
                    j = lps[j-1];
                }
                else {
                    i++;
                }
            }
        }
    }

    private static void computeLPS(String s) {
        lps[0] = 0;
        int len = 0;
        int j = 1;
        while(j<s.length()) {
            if(s.charAt(j)==s.charAt(len)) {
                len++;
                lps[j] = len;
                j++;
            }
            else {
                if(len!=0) {
                    len = lps[len-1];
                }
                else {
                    lps[j] = len;
                    j++;
                }
            }
        }
    }
}
