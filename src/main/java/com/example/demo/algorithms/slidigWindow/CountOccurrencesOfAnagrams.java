package com.example.demo.algorithms.slidigWindow;

import java.util.HashMap;
import java.util.Map;

public class CountOccurrencesOfAnagrams {
    public static int search(String pat, String txt) {
        // code here
        int count = 0;
        Map<Character,Integer> patMap = new HashMap<>();
        Map<Character,Integer> txtMap = new HashMap<>();
        int index = 0;
        while (index < pat.length()){
            patMap.put(pat.charAt(index), patMap.getOrDefault(pat.charAt(index),0)+1);
            txtMap.put(txt.charAt(index), txtMap.getOrDefault(txt.charAt(index),0)+1);
            index++;
        }
        if(patMap.equals(txtMap)){
            count++;
        }
        System.out.println(patMap);
        for(int i=1;i<txt.length()-pat.length()+1;i++){
            char charLeft = txt.charAt(i-1);
            char charRight = txt.charAt(i+pat.length()-1);
            txtMap.put(charLeft, txtMap.getOrDefault(charLeft,0)-1);
            txtMap.put(charRight, txtMap.getOrDefault(charRight,0)+1);
            if(txtMap.get(charLeft) ==0){
                txtMap.remove(charLeft);
            }
            
            if(patMap.equals(txtMap)) count++;
        }

        return count;
    }
    public static void main(String[] args) {
        System.out.println(search("for","forxxorfxdofr"));
        System.out.println(search("aaba","aabaabaa"));
    }
}
