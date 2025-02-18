package com.example.demo.algorithms.twoPointers;

public class ContainerWithMostWater {
    /*
        https://www.hellointerview.com/learn/code/two-pointers/container-with-most-water
        
        Given an integer input array heights representing the heights of vertical lines,
        write a function that returns the maximum area of water that can be contained by two of the lines (and the x-axis).
        The function should take in an array of integers and return an integer.


     */
    
    public static int findContainerWithMostWater(int[] heights){
        int maxArea=0;
        int left=0;
        int right = heights.length-1;
        
        while(left < right){
            int minHeight = Math.min(heights[left],heights[right]);
            maxArea = Math.max(maxArea,minHeight*(right-left));
            if(heights[left]>=heights[right]){
                right--;
            } else {
                left++;
            }
        }
        return maxArea;
    }
    
    public static void main(String[] args) {
        System.out.println(findContainerWithMostWater(new int[] {3,4,1,2,2,4,1,3,2})); //21
        System.out.println(findContainerWithMostWater(new int[] {1, 5, 4, 3})); //6
    }
    
}
