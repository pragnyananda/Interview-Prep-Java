package com.example.demo.algorithms.dynamicProgramming;

public class Fibonacci_Series {
    public static int getFibonacciSeriesRecursion(int num){
        if (num< 2){
            return num;
        }
        return getFibonacciSeriesRecursion(num-1)+getFibonacciSeriesRecursion(num-2);
    }

    public static int getFibonacciSeries(int num){
        if (num==0){
            return 0;
        }
        if (num==1){
            return 1;
        }
        int first=0;
        int second=1;
        int total=0;

        for(int i=2;i<=num;i++){
            total=first+second;
            first=second;
            second=total;
        }
        return total;
    }

    public static void main(String[] args) {
        int n=10;

        for(int i=0;i<n;i++){
            System.out.println(getFibonacciSeries(i));
        }

        for(int i=0;i<n;i++){
            System.out.println(getFibonacciSeriesRecursion(i));
        }
    }
}
