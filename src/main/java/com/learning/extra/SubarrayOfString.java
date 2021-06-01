package com.learning.extra;

import java.util.*;
import java.util.stream.Collectors;

public class SubarrayOfString {
    public static void main(String[] args) {
        String s = "abcsac";
        System.out.println(subsetsWithDup(s.toCharArray()));
    }

    public static int subsetsWithDup(char[] nums) {
//        Arrays.sort(nums);
        Set<String> result = new HashSet<>();
        List<Test> temp = new ArrayList<>();
        test(result,temp,nums,0);
        return result.size();
    }

    static void test(Set<String> result,List<Test> temp,char[] nums,int start) {
        result.addAll(temp.stream().map(e -> e.s).collect(Collectors.toSet()));
        for(int i = start ; i<nums.length; i++) {
            if(i > start && start!=temp.get(temp.size()-1).index+1) {
                continue;
            }
            String x = temp.toString();
            Test t = new Test(Character.toString(nums[start]) , start);
            temp.add(t);
            test(result,temp,nums,i+1);
            temp.remove(temp.size()-1);
        }
    }

    static class Test {
        String s;
        int index;
        Test(String s, int index) {
            this.s = s;
            this.index = index;
        }
    }
}
