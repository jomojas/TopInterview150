package _80;

public class RemoveDuplicatesfromSortedArray2 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        int[] nums1 = {1};
        int k1 = solution.removeDuplicates(nums1);
        System.out.println(k1); // Output: 1
        int[] nums2 = {1, 1, 1, 2, 2, 3};
        int k2 = solution.removeDuplicates(nums2);
        System.out.println(k2); // Output: 5
        // for (int i = 0; i < k1; i++) {
        //     System.out.print(nums1[i] + " "); // Output: 1 1 2 2 3
        // }
    }
}

/* My method */
class Solution {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            // count = (i != 0 && nums[i] == nums[i - 1]) ? count + 1 : 1;

            if(i != 0 && nums[i] == nums[i - 1]) {
                count++;
            } else {
                count = 1;
            }

            if(count < 3) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}

/* Modified by Chatgpt */
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int count = 1;
//         int index = 1; // start from 1 because we always keep the first element

//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] == nums[i - 1]) {
//                 count++;
//             } else {
//                 count = 1;
//             }

//             if (count <= 2) {
//                 nums[index++] = nums[i];
//             }
//         }

//         return index;
//     }
// }


/* Solution (concise) */
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int k = (nums.length < 2) ? nums.length : 2; // At least two elements are allowed

//         for (int i = 2; i < nums.length; i++) {
//             if (nums[i] != nums[k - 2]) {
//                 nums[k] = nums[i];
//                 k++;
//             }
//         }

//         return k;        
//     }
// }