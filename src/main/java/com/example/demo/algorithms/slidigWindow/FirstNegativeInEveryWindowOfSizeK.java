package com.example.demo.algorithms.slidigWindow;

import java.util.*;

public class FirstNegativeInEveryWindowOfSizeK {
    
    /*
    https://www.geeksforgeeks.org/problems/first-negative-integer-in-every-window-of-size-k3345/1
     */
    
    public static List<Integer> findFirstNegativeInEveryWindowOfSizeK(int arr[], int k) {
        List<Integer> list = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        int index = 0;
        
        while(index < k){
            if(arr[index]<0){
                queue.offer(arr[index]);
            }
            index++;
        }
        list.add(queue.isEmpty() ? 0 : queue.peek());
        for(int i =1;i<arr.length-k+1;i++){
            if(arr[i-1]<0){
                queue.poll();
            }if(arr[i+k-1]<0){
                queue.offer(arr[i+k-1]);
            }
            list.add(queue.isEmpty() ? 0 : queue.peek());
        }
        return list;
    }
    
    public static void main(String[] args) {
    
    }
}
