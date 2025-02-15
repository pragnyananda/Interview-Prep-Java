package com.example.demo.algorithms.slidigWindow;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class MaxSumSubArrayOfSizeK {
    /*
    Given an array of integers arr[]  and a number k. Return the maximum sum of a subarray of size k.

    Note: A subarray is a contiguous part of any given array.
    
    Examples:
  
    Input: arr[] = [100, 200, 300, 400] , k = 2
    Output: 700
    Explanation: arr3  + arr4 = 700, which is maximum.
    
    Input: arr[] = [100, 200, 300, 400] , k = 4
    Output: 1000
    Explanation: arr1 + arr2 + arr3 + arr4 = 1000, which is maximum.
    
    Input: arr[] = [100, 200, 300, 400] , k = 1
    Output: 400
    Explanation: arr4 = 400, which is maximum.
    
    
    Rule:
    1. Fist create a sum and maxSum.
    2. Iterate and create the first slide and assign the same to maxSum. Slide of 0 to K
    3. Then in the for loop start from 1 index till length-K+1
    4. Define previousElement by arr[i-1] and next element by arr[i+k-1]
    5. Subtract preElement and add nextElement, compare with MaxSum and return the maxSum
     */
    
    
    public static int maxSubArrayOfSizeK(int[] arr, int k){
        int maxSum=0,sum=0, index=0;
        while(index<arr.length && index < k){
            sum += arr[index];
            index++;
        }
        maxSum = sum;
        for(int i=1;i<arr.length-k+1;i++){
            int prevElement = arr[i-1];
            int nextElement = arr[i+k-1];
            sum = sum - prevElement + nextElement;
            maxSum = Math.max(sum,maxSum);
        }
        return maxSum;
    }
    
    static List<Integer> FirstNegativeInteger(int arr[], int k) {
            // write code here
            
            List<Long> list = new ArrayList<>();
            Queue<Long> queue = new PriorityQueue<>();
            int index=0;
            
            while(index<arr.length && index< k){
                if(arr[index] < 0){
                    list.add(arr[index]);
                    break;
                }
                index++;
            }
            if(list.size() == 0){
                list.add(0);
            }
            for(int i=1;i< arr.length-k+1;i++){
                if(arr[i] < 0){
                    list.add(arr[i]);
                    continue;
                }
                // if(list.size()<i+1){
                //     list.add(0);
                // }
            }
            
            
            
            return list;
        }
    
    public static void main(String[] args) {
        System.out.println(maxSubArrayOfSizeK(new int[] {100, 200, 300, 400}, 2));
        
        System.out.println(maxSubArrayOfSizeK(new int[] {100, 200, 300, 400}, 4));
        
        System.out.println(maxSubArrayOfSizeK(new int[] {100, 200, 300, 400}, 1));
    }
}
