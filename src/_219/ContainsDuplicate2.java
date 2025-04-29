package _219;

import java.util.HashMap;
import java.util.Map;
// import java.util.Set;

public class ContainsDuplicate2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 1};
        int k = 3;
        System.out.println(solution.containsNearbyDuplicate(nums, k)); // Output: true
    }
}

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        /* My stupid method (Time limit exceeded) */
        Map<Integer, Integer> map = new HashMap<>();
        int smallerNum = (k >= nums.length) ? nums.length - 1 : k;
        for(int i = 0; i <= smallerNum; i++) {
            if(map.containsKey(nums[i]))    return true;
            map.put(nums[i], i);
        }
        for(int j = k + 1; j < nums.length; j++) {
            // int smallestValue = Collections.min(map.values());
            // map.entrySet().removeIf(entry -> entry.getValue() == smallestValue);
            map.remove(nums[j - k - 1]);
            if(map.containsKey(nums[j]))    return true;
            map.put(nums[j], j);
        }
        return false;

        /* Solution 1 */
        // Map<Integer, Integer> map = new HashMap<>();
        // for(int i = 0; i < nums.length; i++) {
        //     if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
        //         System.gc();
        //         return true;
        //     }
        //     map.put(nums[i], i);
        // }
        // System.gc();
        // return false;

        /* Solution 2 */
        // Set<Integer> set = new HashSet<>();
        // for(int i = 0; i < nums.length; i++) {
        //     if(i > k) {
        //         set.remove(nums[i - k -1]);
        //     }
        //     if(!set.add(nums[i])) {
        //         System.gc();
        //         return true;
        //     }
        // }
        // System.gc();
        // return false;
    }
}