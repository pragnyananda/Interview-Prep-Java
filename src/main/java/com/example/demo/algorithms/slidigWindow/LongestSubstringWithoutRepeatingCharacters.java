package com.example.demo.algorithms.slidigWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters  {
    /*
    https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
     */
   
    private static int lengthOfLongestSubstring(String s) {
        int left=0;
        int maxLength=0;
        Set<Character> set = new HashSet<>();

        for(int right=0;right < s.length(); right++){
            while(set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
    
      public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // Output: 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // Output: 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // Output: 3
    }
    
}
