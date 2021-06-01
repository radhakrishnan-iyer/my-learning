package com.learning.extra;

import java.util.*;
public class WordBreak {
    public static void main(String[] args) {
        System.out.println(solve("rosesarered" , new String[]{"ro","roses","rosesar","ere","e","r","d"}));
    }
    private static boolean solve(String s, String[] wordlist) {
        Set<String> dict = new HashSet<>();
        for(int i=0;i<wordlist.length;i++) {
            dict.add(wordlist[i]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        while(!q.isEmpty()) {
            int currentIdx = q.poll();
            if(currentIdx==s.length())
                return true;
            for(int i=currentIdx+1;i<=s.length();i++) {
                if(visited.contains(i))
                continue;
                if(dict.contains(s.substring(currentIdx,i))) {
                    q.offer(i);
                    visited.add(i);
                }
            }
        }
        return false;
    }

}
