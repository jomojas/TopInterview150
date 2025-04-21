package _169;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        Solution solution = new Solution();
        int majorityElement = solution.majorityElement(nums);
        System.out.println("Majority Element: " + majorityElement);
    }
}

class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = 0;
        for (int elem : nums) {
            /* My method(Learned) */
            if (elem == candidate) {
                count++;
            } else {
                if (count == 0) {
                    candidate = elem;
                } else {
                    count--;
                }
            }
            /* Solution */
            // if (count == 0) {
            //     candidate = elem;
            // }
            // count += (elem == candidate) ? 1 : -1;
        }
         return candidate;
    }
}