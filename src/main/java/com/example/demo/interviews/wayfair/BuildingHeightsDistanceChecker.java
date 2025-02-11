package com.example.demo.interviews.wayfair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Problem Statement

there is an array, like 1,2,3,1, k=4, array contains building heights.
A program should return true if distance between building heights are same and less than or equals to K, try all the possible combinations possible.
If nothing is there than return false. array 1,2,3,1, maxDistance k=4,In this example distance between 1 by index is 4, which is less than or equals to 4.

1,2,3,4, k=4,There is no two building is same. hence returns false.
1,0,1,1, k=3,In this example
distance between index 0 and index 2, hence 2-0 = 2, which is less or equals than maxDistance K = 3
distance between index 3 and index 2, hence 3-2 = 1, which is less or equals than maxDistance K = 3
distance between index 4 and index 3, hence 4-3 = 1, which is less or equals than maxDistance K = 3
 */
public class BuildingHeightsDistanceChecker {
    public static boolean containsNearByBuildings(List<Integer> buildingHeights, int k){
        Map<Integer,Integer> map = new HashMap<>();

        for(int i =0; i<buildingHeights.size();i++){
            if(map.containsKey(buildingHeights.get(i))){
                int prevIndex =  map.get(buildingHeights.get(i));
                if(i-prevIndex <= k) {
                    return true;
                }

            }
            map.put(buildingHeights.get(i),i );
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(containsNearByBuildings(List.of(1,2,3,4),4));

        System.out.println(containsNearByBuildings(List.of(1,2,3,1),4));

        System.out.println(containsNearByBuildings(List.of(1,0,1,1),3));

    }
}
