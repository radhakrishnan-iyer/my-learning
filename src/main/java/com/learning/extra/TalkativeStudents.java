package com.learning.extra;

import java.util.*;

public class TalkativeStudents {

    public static void main(String[] args) {
        System.out.println(solve(new String[]{"S1", "S2", "S3", "S4", "S5"} , new String[]{"L1", "L1", "L2", "L2", "L3"})); // S1 S3 S2 S4 S5
      //  System.out.println(solve(new String[]{"S1", "S2", "S3"} , new String[]{"L1", "L1", "L2"})); // S1 S3 S2 S4 S5
    }

    static private List<String> solve(String[] students, String[] language) {
        Map<String, Queue<String>> map = new HashMap<>();
        for(int i=0;i<students.length;i++) {
            String currentLang = language[i];
            String currentStudent = students[i];
            if(map.containsKey(currentLang)) {
                Queue<String> temp = map.get(currentLang);
                temp.offer(currentStudent);
            } else {
                Queue<String> temp = new LinkedList<>();
                temp.offer(currentStudent);
                map.put(currentLang, temp);
            }
        }

        PriorityQueue<Map.Entry<String,Queue<String>>> pq = new PriorityQueue<>(new Comparator<Map.Entry<String, Queue<String>>>() {
            @Override
            public int compare(Map.Entry<String, Queue<String>> a, Map.Entry<String, Queue<String>> b) {
                if(a.getValue().size()==b.getValue().size()) {
                    return a.getKey().compareTo(b.getKey());
                }
                return b.getValue().size()-a.getValue().size();
            }
        });

        pq.addAll(map.entrySet());
        int k = 2;
        Queue<Map.Entry<String,Queue<String>>> waitQ = new LinkedList<>();
        List<String> result = new ArrayList<>();
        while (!pq.isEmpty()) {
            Map.Entry<String,Queue<String>> firstEntry = pq.poll();
            Queue<String> q = firstEntry.getValue();
            String student = q.poll();
            result.add(student);

            Map.Entry<String, Queue<String>> temp = new AbstractMap.SimpleEntry<>(firstEntry.getKey(), q);

            waitQ.offer(temp);
            if(waitQ.size()<k) {
                continue;
            }
            temp = waitQ.poll();
            if(temp.getValue().size()>0)
                pq.offer(temp);
        }
        return result.size()==students.length ? result : new ArrayList<>();
    }
}
