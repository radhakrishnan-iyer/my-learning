package com.learning.extra;

import java.util.*;

public class OrgStructure {
    static Map<String,String> parentMap = new HashMap<>();
    public static void main(String[] args) {
        Map<String,List<String>> map = new HashMap<>();
        Map<String,Integer> countMap = new HashMap<>();
        map.put("e1", Arrays.asList("e2","e3","e5"));
        map.put("e2" , Arrays.asList("e7"));
        map.put("e3", Arrays.asList("e4","e6"));
        dfs(map,countMap,"e1", null);
        System.out.println(countMap);

        map.put("e8", Arrays.asList("e7,e8"));
        recalc(countMap, "e8");
        System.out.println("After modification");
        System.out.println(countMap);
    }

    private static void recalc(Map<String,Integer> countMap, String curr) {
        if(curr==null)
            return;
        countMap.put(curr , countMap.getOrDefault(curr,0)+1);
        recalc(countMap,parentMap.get(curr));
    }

    private static void dfs(Map<String,List<String>> map, Map<String,Integer> countMap, String curr, String parent) {
        parentMap.put(curr, parent);
        if(!map.containsKey(curr)) {
            countMap.put(curr, 1);
            return;
        }
        List<String> reportees = map.get(curr);
        int count = 1;
        for(int i=0;i<reportees.size();i++) {
            dfs(map,countMap,reportees.get(i) , curr);
            count += countMap.get(reportees.get(i));
        }
        countMap.put(curr, count);
    }
}
