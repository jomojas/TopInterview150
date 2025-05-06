package _136;

import java.util.HashSet;
import java.util.Set;
// import java.util.Arrays;

public class SingleNumber {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(solution.singleNumber(nums)); // Output: 4
    }
}

/* My method (Using Set (Not constant space) space complexity: O(n/2)) */
class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                set.add(nums[i]);
            }
        }
        return set.iterator().next();
    }
}

/* Solution (XOR ^ ) */
// class Solution {
//     public int singleNumber(int[] nums) {
//         int res = nums[0];
//         for(int i = 1; i < nums.length; i++) {
//             res ^= nums[i];
//         }
//         return res;
//     }
// }

/* Solution (Sort) */
// class Solution {
//     // This method returns an array of integers.
//     public int singleNumber(int[] nums) {
//         Arrays.sort(nums);
//         for(int i=0;i<nums.length-1;i+=2){
//             if(nums[i]!=nums[i+1]){
//                 return nums[i];

//             }
//         }
//         return nums[nums.length-1];
//     }
// }