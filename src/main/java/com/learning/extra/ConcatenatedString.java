package com.learning.extra;
import java.util.*;

public class ConcatenatedString {

    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = new String[] {"word","good","best","good"};
        System.out.println(findSubstring(s,words));
    }

    public static List<Integer> findSubstring(String s, String[] words) {
        if(words==null || words.length==0)
            return new ArrayList<>();
        int len = words[0].length();
        int n = words.length;
        int i = 0;
        List<Integer> result = new ArrayList<>();
        boolean[] visited = new boolean[n];
        while(i<s.length()) {
            int count = 0;
            int start = i;
            visited = new boolean[n];
            while(count<n) {
                String current = s.substring(i,i+len<=s.length()?i+len:s.length());
                if(isPresent(current,words,visited)) {
                    count++;
                    i=i+len;
                    if(i>s.length()-len)
                        break;
                }
                else {
                    break;
                }
            }
            if(start+n*len==i) {
                result.add(start);
            }
            i=start+1;
        }
        return result;
    }

    static boolean isPresent(String current, String[] words, boolean[] visited) {
        for(int i=0;i<words.length;i++) {
            if(!visited[i]) {
                if(current.equals(words[i])) {
                    visited[i]=true;
                    return true;
                }
            }
        }
        return false;
    }
}
