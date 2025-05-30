package _26;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 3, 3, 4, 5, 5, 6};
        Solution solution = new Solution();
        int length = solution.removeDuplicates(nums);
        System.out.println("Length of the array after removing duplicates: " + length);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

/* My Method */
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        // nums is empty
        if (length == 0) {
            return 0;
        }

        int index = 1;
        // int lastNum = nums[0];
        int i = 1;
        while (i != length) {
            if (nums[i - 1] != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
            // nums[i - 1] = nums[i];
            i++;
        }
        return index;
    }
}

/* From Solution */
// class Solution {
//     public int removeDuplicates(int[] nums) {
//         int j = 1;
//         for (int i = 1; i < nums.length; i++) {
//             if (nums[i] != nums[i - 1]) {
//                 nums[j] = nums[i];
//                 j++;
//             }
//         }
//         return j;
//     }
// }
