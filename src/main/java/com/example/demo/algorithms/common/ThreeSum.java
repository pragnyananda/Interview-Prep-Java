package com.example.demo.algorithms.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); // Sort the array to simplify the process

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for the first number
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    // Add the triplet to the result
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
// Skip duplicates for the second number
                    while (left < right && nums[left] == nums[left + 1]) left++;

                    // Skip duplicates for the third number
                    while (left < right && nums[right] == nums[right - 1]) right--;

                    // Move both pointers
                    left++;
                    right--;
                } else if (sum < 0) {
                    // Move the left pointer to increase the sum
                    left++;
                } else {
                    // Move the right pointer to decrease the sum
                    right--;
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> triplets = threeSum(nums);

        // Print the result
        for (List<Integer> triplet : triplets) {
            System.out.println(triplet);
        }
    }
}
