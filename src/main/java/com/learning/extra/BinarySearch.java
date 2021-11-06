package com.learning.extra;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = new int[]{0,0,0,0,0,0,0,0,0,1};
        System.out.println(solve(arr));
    }

    private static int solve(int[] arr) {
        int key = 1;
        int low = 0;
        int high = 1;
        while (high <= arr.length-1 && arr[high] < key) {
            low = high;
            high = 2 * high;
        }

        return binarySearch(arr, low, high, 1);
    }
       static int binarySearch(int[] arr, int low, int high, int key) {
           int result = Integer.MAX_VALUE;
           while(low<=high) {
                int mid = low + (high-low)/2;
                if(mid > arr.length-1)
                    return -1;
                if(arr[mid]==key) {
                    result = mid;
                    high = mid-1;
                }
                else if(arr[mid]<key) {
                    low = mid + 1;
                }
                else {
                    high = mid-1;
                }
            }
            return result==Integer.MAX_VALUE ? -1 : result;
        }
    }
