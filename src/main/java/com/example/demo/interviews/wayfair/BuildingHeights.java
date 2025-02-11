package com.example.demo.interviews.wayfair;

import java.util.HashMap;
import java.util.Map;

public class BuildingHeights {
    public static boolean getBuildingHeights(int[] arr, int k){
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int previousKey = map.get(arr[i]);
                if(i-previousKey<=3) {
                    return true;
                }
            }
            map.put(arr[i],i);
        }

        return false;
    }


    public static void main(String[] args) {
        System.out.println(getBuildingHeights(new int[] {1,0,1,1},3));

        System.out.println(getBuildingHeights(new int[] {1,2,3,4},3));

        System.out.println(getBuildingHeights(new int[] {1,2,3,4,5,3},4));

    }
}
