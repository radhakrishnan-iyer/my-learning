package com.learning.extra;

public class RightRotateArray {
    public static void main(String[] args) {
        int arr[] = new int[] {5 , 4 , 6 , 1 , 3 , 7 , 9};
        arr = rotateArray( arr, 3);
        for(int x : arr) {
            System.out.print(x +" ");
        }
    }

    private static int[] rotateArray(int[] arr , int k) {
        int n = arr.length;

        // If we want to rotate left then move this method to last
        rotate(arr , 0 , n-1);
        rotate(arr , 0 , k-1);
        rotate(arr , k , n-1);
        return arr;
    }

    private static void rotate(int[] arr , int start , int end) {
        while(start <= end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start ++ ;
            end --;
        }
    }
}
