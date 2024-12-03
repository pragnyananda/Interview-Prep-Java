package com.example.demo.algorithms.dynamicProgramming;

public class Climbing_Stairs_leetcode_70 {
    public static int climbStairs(int n) {
        if(n==0) return 1;
        if(n==1) return 1;

        int first =1;
        int second=1;
        int total=0;

        for(int i=2;i<=n;i++){
            total = first+second;
            first=second;
            second=total;
        }
        return total;
    }

    public static void main(String[] args) {
        int n=4;
        System.out.println(climbStairs(n));
    }
}
