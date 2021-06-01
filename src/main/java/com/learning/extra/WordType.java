package com.learning.extra;

import org.apache.commons.lang3.tuple.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordType {
    public static void main(String[] args) {
        char[][] arr = new char[][] {{'a' , 'b' , 'c' , 'd' , 'e'},
                {'f' , 'g' , 'h' , 'i' , 'j'},
                {'k' , 'l' , 'm' , 'n' , 'o'},
                {'p' , 'q' , 'r' , 's' , 't'},
                {'u' , 'v' , 'w' , 'x' , 'y'},
                {'z' , '*' , '*' , '*' , '*'}};
        int[][] nums = new int[][] {{1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25},
                {26,27,28,29,30}};
        List<String> result = new ArrayList<>();
        Map<Character, MyPair> map = new HashMap<>();
        boolean[][] visited = new boolean[nums.length][nums.length];
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                MyPair p = new MyPair(i,j);
                map.put(arr[i][j] , p);
                visited[i][j] = false;
            }
        }
        dfs(0,0,result,0,arr , nums, "carz", map, visited);
        System.out.println(result);
    }

    private static void dfs(int r , int c, List<String> stringList , int index , char[][]arr , int[][] nums ,  String s , Map<Character, MyPair> map, boolean[][] visited) {
        if(!isValid(r,c,arr, visited)) {
            return;
        }
        System.out.println("Index : " + index + " : Length : " + s.length());
        if(index == s.length()) {
            return;
        }
        int k = index;
        if(s.charAt(index) == arr[r][c]) {
            stringList.add("TYPE");
            index++;
            for(int i=0;i<visited.length;i++) {
                for(int j=0;j<visited[0].length;j++)
                    visited[i][j] = false;
            }
            if(index==s.length())
                return;
        }
        visited[r][c] = true;
        MyPair myPair = map.get(arr[r][c]);
        MyPair newPair = map.get(s.charAt(k));
        int next = nums[newPair.i][newPair.j];
        int curr = nums[myPair.i][myPair.j];
        int absUp = Integer.MAX_VALUE;
        int absDown = Integer.MAX_VALUE;
        int absLeft = Integer.MAX_VALUE;
        int absRight = Integer.MAX_VALUE;

        if(isValid(r+1,c,arr,visited)) {
            absDown = Math.abs((curr + arr[0].length) - next );
        }
        if(isValid(r-1,c,arr, visited)) {
            absUp = Math.abs((curr - arr[0].length) - next);
        }
        if(isValid(r, c+1, arr, visited)) {
            absRight = Math.abs((curr + 1)  - next);
        }
        if(isValid(r, c-1 , arr, visited)) {
            absLeft = Math.abs((curr - 1) - next);
        }
        int min = Math.min(absDown,Math.min(absUp,Math.min(absLeft,absRight)));
        if(min == absDown) {
            stringList.add("DOWN");
            dfs(r+1,c,stringList, index, arr, nums, s, map,visited);
        }
        else if(min == absUp) {
            stringList.add("UP");
            dfs(r-1,c,stringList,index,arr,nums,s,map,visited);
        } else if(min == absLeft) {
            stringList.add("LEFT");
            dfs(r,c-1, stringList, index, arr, nums, s, map,visited);
        } else {
            System.out.println(min + " : " + arr[r][c]);
            stringList.add("RIGHT");
            dfs(r, c+1, stringList, index, arr, nums, s, map,visited);
        }
    }

    static class MyPair {
        int i,j;
        MyPair(int i,int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static boolean isValid(int r, int c , char[][]arr, boolean[][] visited) {
        if(r<0 || r>=arr.length || c<0 || c>=arr[0].length || arr[r][c] == '*' || visited[r][c]) {
            return false;
        }
        return true;
    }
}
