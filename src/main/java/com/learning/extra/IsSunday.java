package com.learning.extra;

import java.util.LinkedHashMap;
import java.util.Map;

public class IsSunday {

    public static void main(String[] args) {
        System.out.print(solve(2119));
    }

    public static int solve(int year) {
        boolean isLeapYear = isLeapYear(year);
        Map<String,Integer> map = new LinkedHashMap<>();
        map.put("Jan",1);
        map.put("Feb", 31);
        map.put("Mar", isLeapYear ? 29 : 28);
        map.put("Apr", 31);
        map.put("May", 30);
        map.put("Jun", 31);
        map.put("Jul", 30);
        map.put("Aug", 31);
        map.put("Sep", 31);
        map.put("Oct", 30);
        map.put("Nov", 31);
        map.put("Dec", 30);

        long noOfDays = 0;
        for(int i=1900;i<year;i++) {
            boolean isCurrentYearLeap = isLeapYear(i);
            noOfDays += isCurrentYearLeap ? 366 : 365;
        }

        int count = 0;
        for(Map.Entry<String,Integer> entry : map.entrySet()) {
            noOfDays = noOfDays + entry.getValue();
            if(noOfDays%7==0) {
                System.out.println(entry.getKey());
                count++;
            }
        }

        return count;
    }

    private static boolean isLeapYear(int year) {
        if(year%100==0 && year%400== 0)
            return true;
        if(year%100!=0 && year%4==0)
            return true;
        return false;
    }
}
