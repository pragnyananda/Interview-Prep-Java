package com.example.demo.algorithms.slidigWindow;

import java.util.*;

public class ChocolateDistributionProblem {
    /*
    Question: https://www.geeksforgeeks.org/problems/chocolate-distribution-problem3825/1
    Explanation: https://www.youtube.com/watch?v=oYNU1TD9W5Y&list=PLQ7ZAf76c0ZPAnTKbEMAvGYaQWBvpLCf7&index=4&ab_channel=shashCode
     */
    
     public static int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
         if(arr.isEmpty()) return 0;
         Collections.sort(arr);
         int maxDiff=Integer.MAX_VALUE;
         for(int i=0;i<arr.size()-m+1;i++){
             int diff = arr.get(i+m-1)-arr.get(i);
             maxDiff = Math.min(diff,maxDiff);
         }
         return maxDiff;
    }
    
    public static void main(String[] args) {
        System.out.println(findMinDiff(new ArrayList<>(List.of(3, 4, 1, 9, 56, 7, 9, 12)), 5));
    }
}
