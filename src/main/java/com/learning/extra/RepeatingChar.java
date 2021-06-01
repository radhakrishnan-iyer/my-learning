package com.learning.extra;

import java.util.HashMap;
import java.util.Map;

public class RepeatingChar {

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABBB" , 2));
    }

    public static int characterReplacement(String s, int k) {
        Map<Character , Integer> countMap = new HashMap<>();
        int start = 0;
        int end = 0;
        int maxLen = 0;
        int maxRepeat = 0;
        for(end = 0 ; end < s.length() ; end++) {
            countMap.put(s.charAt(end) , countMap.getOrDefault( s.charAt(end), 0) + 1);
            maxRepeat = Math.max(maxRepeat , countMap.get(s.charAt(end)));
            if(end - start + 1 - maxRepeat > k) {
                countMap.put(s.charAt(start) , countMap.get(start) - 1);
            }
            maxLen = Math.max(maxLen , end - start + 1);
        }
        return maxLen;
    }
}
