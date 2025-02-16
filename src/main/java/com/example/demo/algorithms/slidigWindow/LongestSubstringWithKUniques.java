package com.example.demo.algorithms.slidigWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithKUniques {
    public static int longestKSubStr(String s, int k) {
        if (s == null || s.isEmpty() || k == 0) return -1;

        int maxLength = -1;
        int left=0;
        Map<Character, Integer> map = new HashMap<>();
        
        for(int right=0 ; right < s.length(); right++){
            map.put(s.charAt(right), map.getOrDefault(s.charAt(right),0)+1);
            while(map.size()>k){
                char leftChar = s.charAt(left);
                map.put(leftChar,map.get(leftChar)-1);
                if(map.get(leftChar)==0){
                    map.remove(leftChar);
                }
                left++;
            }
            if(map.size()==k){
                maxLength = Math.max(maxLength,right-left+1);
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(longestKSubStr("aabacbebebe", 3)); // Output: 7
        System.out.println(longestKSubStr("aaaa", 2));       // Output: -1
        System.out.println(longestKSubStr("aabaaab", 2));    // Output: 7
    }
}
