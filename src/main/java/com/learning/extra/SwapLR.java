package com.learning.extra;

import java.util.*;
public class SwapLR {
    public static void main(String[] args) {
        System.out.println(canTransform("XXXXXXRXXLXRXXXXXRXXXXXRXXXXXLXXXLXLXXRXXXXXLXXXXX" , "XXRXXXXLXXRXXXRXXXXRXXXXXLXXLXXXXXXLXXXXRXXXXLXXXX"));
    }
    public static boolean canTransform(String s, String t) {
        if(s==null && t==null)
            return true;
        if(s==null || t==null)
            return false;
        if(s.length()!=t.length())
            return false;
        Set<String> visited = new HashSet<>();
        return dfs(s.toCharArray(),t,visited);
    }

    static boolean  dfs(char[] s, String t, Set<String> visited) {
        if(visited.contains(String.valueOf(s)))
            return false;
        if((String.valueOf(s)).equals(t))
            return true;
        visited.add(String.valueOf(s));
        for(int i=0;i<s.length-1;i++) {
            if((s[i]=='R' && s[i+1]=='X') || (s[i]=='X' && s[i+1]=='L')) {
                swap(s,i,i+1);
                if(dfs(s,t,visited))
                    return true;
                swap(s,i,i+1);
            }
        }
        return false;
    }

    static private void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j]=temp;
    }
}
