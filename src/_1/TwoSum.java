package _1; 

import java.util.*;

public class TwoSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 7, 11, 15};
        int[] result = solution.twoSum(nums, 9);
        for(int elem : result) {
            System.out.println(elem);
        }
    }
}

class Solution {
    public int[] twoSum(int[] nums, int target) {
        /* My method */
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return new int[]{};

        /* Solution */
        // Map<Integer, Integer> numMap = new HashMap<>();
        
        // for(int i = 0; i < nums.length; i++) {
        //     int complement = target - nums[i];
        //     if(numMap.containsKey(complement) && numMap.get(complement) != i) {
        //         return new int[]{i, numMap.get(complement)};
        //     }
        //     numMap.put(nums[i], i);
        // }
        // return new int[]{};
    }
}

