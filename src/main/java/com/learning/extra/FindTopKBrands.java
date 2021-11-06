package com.learning.extra;

import java.util.*;

public class FindTopKBrands {


    public static void main(String[] args) {

        List<int[]> list = new ArrayList<>();
        list.add(new int[]{ 3,0,14});
        list.add(new int[]{0, -1, 10});
        list.add(new int[]{4,0,44});
        list.add(new int[]{6, -1, 7});
        list.add(new int[]{10, 6, 13});
        list.add(new int[]{7, 6, 17});
        list.add(new int[]{2, -1, 2});
        list.add(new int[]{14, 2, 9});
        list.add(new int[]{25, 14, 10});
        list.add(new int[]{12, 2, 10});
        list.add(new int[]{13, 0, 1});

        findKMaxHotels(list, 3); // {0=69, 2=31, 3=14, 4=44, 6=37, 7=17, 25=10, 10=13, 12=10, 13=1, 14=19}
    }

    public static void findKMaxHotels(List<int[]> list, int k){
        Map<Integer,List<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> weightMap = new HashMap<>();
        for(int i=0;i<list.size();i++) {
            int[] current = list.get(i);
            int parent = current[1];
            int hotel = current[0];
            weightMap.put(hotel , current[2]);
            if(graph.containsKey(parent)) {
                List<Integer> temp = graph.get(parent);
                temp.add(hotel);
                graph.put(parent, temp);
            }
            else {
                List<Integer> temp = new ArrayList<>();
                temp.add(hotel);
                graph.put(parent, temp);
            }
        }

        Set<Integer> visited = new HashSet<>();
        for(int i=0;i<list.size();i++) {
            int[] current = list.get(i);
            int hotel = current[0];
            if(visited.contains(hotel)) {
                continue;
            }
            dfs(graph, visited, hotel , weightMap);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return Integer.compare(o1.getValue(),o2.getValue());
            }
        });

        for(Map.Entry<Integer,Integer> e : weightMap.entrySet()) {
            pq.offer(e);
            if(pq.size()>k) {
                pq.poll();
            }
        }

        while(!pq.isEmpty()) {
            Map.Entry<Integer,Integer> temp = pq.poll();
            System.out.println("Brand Id : " + temp.getKey() + " with capacity -->" + temp.getValue() );
        }

    }

    private static int dfs(Map<Integer,List<Integer>> graph, Set<Integer> visited, int hotel, Map<Integer,Integer> weightMap) {
        if(!graph.containsKey(hotel))
            return weightMap.get(hotel);

        visited.add(hotel);
        List<Integer> neighbors = graph.get(hotel);
        for(Integer n : neighbors) {
            if(visited.contains(n))
                continue;
            weightMap.put(hotel, weightMap.get(hotel) + dfs(graph , visited, n , weightMap));
        }
        return weightMap.get(hotel);
    }
}
