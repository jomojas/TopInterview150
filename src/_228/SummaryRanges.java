package _228;

import java.util.*;

public class SummaryRanges {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // SummaryRanges sr = new SummaryRanges();
        int[] nums = {0, 2, 3, 4, 6, 8, 9};
        System.out.println(solution.summaryRanges(nums)); // Output: ["0->2","4->5","7"]
    }
}

/* My method */
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for(int i = 0; i < nums.length; i++) {
            if(str.length() != 0) {
                if(i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {
                    str.append(nums[i]);
                    summary.add(str.toString());
                    str.setLength(0);
                }
            } else {
                str.append(nums[i]);
                if(i == nums.length - 1 || nums[i + 1] != nums[i] + 1) {
                    summary.add(str.toString());
                    str.setLength(0);
                } else if(nums[i + 1] == nums[i] + 1) {
                    str.append("->");
                }
            }
        }
        return summary;
    }
}

/* Solution */
// class Solution {
//     public List<String> summaryRanges(int[] nums) {
//         List<String> list = new ArrayList<>();
//         int i = 0;
//         while (i < nums.length) {
//             int start = nums[i];
//             while (i + 1 < nums.length && nums[i] + 1 == nums[i+1]) {
//                 i++;
//             }
//             if (start == nums[i]) {
//                 list.add("" + start);
//             } else {
//                 list.add(start + "->" + nums[i]);
//             }
//             i++;
//         }
//         return list;
//     }
// }