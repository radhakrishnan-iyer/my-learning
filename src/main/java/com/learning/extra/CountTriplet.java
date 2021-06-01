package com.learning.extra;

public class CountTriplet {
    static int count = 0;
    public static void main(String[] args) {
        boolean[][] visited = new boolean[5][5];
        countTriplets(0,4,new int[]{1,2,3,4,5} , visited);
        System.out.println(count);
    }

    private static void countTriplets(int i, int j, int[] arr, boolean[][] visited) {
        if(j-i <2)
            return;
        if(visited[i][j])
            return;
        visited[i][j] = true;
        if(arr[i] < arr[j]) {
            count += find(arr,i+1,j-1,true);
        }
        else if(arr[i] > arr[j]) {
            count += find(arr,i+1,j-1 , false);
        }
        countTriplets(i+1, j, arr,visited);
        countTriplets(i,j-1,arr,visited);
    }

    static int find(int[] arr, int start, int end, boolean dir) {
        int x = 0;
        if(dir) {
            // asc
            for(int i=start;i<=end;i++) {
                if(arr[i] > arr[start-1] && arr[i] < arr[end+1])
                    x++;
            }
        } else {
            //desc
            for(int i=start;i<=end;i++) {
                if(arr[i] < arr[start-1] && arr[i] > arr[end+1])
                    x++;
            }
        }
        return x;
    }
}
