package com.example.demo.algorithms.slidigWindow;

public class SmallestSubArrayWithSumGreaterThanX {
    /*
    Question: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
     */
    
    public static int smallestSubWithSum(int x, int[] arr) {
        // Your code goes here
        int minLength = Integer.MAX_VALUE;
        int sum=0,left = 0;
        for(int right = 0;right<arr.length;right++){
         sum += arr[right];
         while (sum > x){
             minLength = Math.min(minLength,right-left+1);
             sum -= arr[left];
             left++;
         }
        }
       return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }
    
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 45, 6, 0, 19};
        int x1 = 51;
        System.out.println(smallestSubWithSum(x1, arr1)); // Output: 3

        int[] arr2 = {1, 10, 5, 2, 7};
        int x2 = 100;
        System.out.println(smallestSubWithSum(x2, arr2)); // Output: 0
    }
    
}
