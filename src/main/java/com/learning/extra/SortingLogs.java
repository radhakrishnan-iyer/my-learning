package com.learning.extra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class SortingLogs {

    public static void main(String[] args) {
        String[][] logs = new String[][] {
                {"Jacob" , "56002"},
                {"Mark" , "1002"},
                {"Jacob" , "56002"},
                {"Jacob" , "1001"},
                {"Mark" , "1002"}
        };
        List<LogEntry> logEntryList = sortLog(logs);
        logEntryList.forEach(
                e-> System.out.println(e)
        );
    }

    public static  List<LogEntry> sortLog(String[][] logs) {
        if(logs==null || logs.length == 0)
            return new ArrayList<>();
        PriorityQueue<LogEntry> priorityQueue = new PriorityQueue<>(
                new Comparator<LogEntry>() {
                    @Override
                    public int compare(LogEntry o1, LogEntry o2) {
                        if(o1.name.compareTo(o2.name) == 0 )
                        {
                            return o1.number - o2.number ;
                        }
                        return o1.name.compareTo(o2.name);
                    }
                }
        );
        for(int i = 0;i<logs.length ; i++) {
            LogEntry e = new LogEntry(logs[i][0] , Integer.parseInt(logs[i][1]));
            priorityQueue.add(e);
        }

        List<LogEntry> result = new ArrayList<>();
        while(!priorityQueue.isEmpty()) {
            LogEntry entry = priorityQueue.poll();
            if(result.isEmpty()) {
                result.add(entry);
            } else {
                if(!result.get(result.size()-1).equals(entry)) {
                    result.add(entry);
                }
                else {
                    System.out.println("Skipping entry : " + entry);
                }
            }
        }
        return result;
    }

    static class LogEntry {
        String name;
        int number;
        LogEntry(String name , int number) {
            this.name = name;
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if(o instanceof  LogEntry) {
                return  this.name.equals(((LogEntry) o).name) && this.number == ((LogEntry) o).number;
            }
            return false;
        }

        public String toString() {
            return "\"" + name + "\"" + ":" + number;
        }
    }
}
