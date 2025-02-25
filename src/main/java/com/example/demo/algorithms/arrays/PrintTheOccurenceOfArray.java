package com.example.demo.algorithms.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrintTheOccurenceOfArray {
    
    public static void getTheOccurance(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        Arrays.stream(arr).forEach(s->map.put(s,map.getOrDefault(s,0)+1));
        System.out.println(map);
        
        for(var mp: map.entrySet()){
            System.out.println(mp.getKey()+":"+ mp.getValue());
        }
    }
    
    public static void main(String[] args) {
        getTheOccurance(new int[] {1,2,2});
    }
}
