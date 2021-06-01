package com.learning.extra;

import java.util.HashMap;
import java.util.Map;

public class StringReplacement {
    public static void main(String[] args) {
        System.out.println(solve("00101001010" , 2));
    }

    private static int solve(String s , int k) {
        Map<Character,Integer> countMap = new HashMap<>();
        int maxLen = 0;
        int maxRepeat = 0;
        int start = 0;
        int end = 0;
        while (end < s.length()){
            countMap.put(s.charAt(end), countMap.getOrDefault(s.charAt(end), 0) + 1);
            maxRepeat = Math.max(maxRepeat, countMap.get(s.charAt(end)));
            while (end - start + 1 - maxRepeat > k) {
                countMap.put(s.charAt(start), countMap.get(s.charAt(start) - 1));
                if(countMap.get(s.charAt(start))==null)
                    countMap.put(s.charAt(start) , 0);
                start++;
            }
            maxLen = Math.max(maxLen, end - start + 1);
            end++;
        }
        return maxLen;
    }
}
