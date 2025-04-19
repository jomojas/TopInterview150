package _26;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2};
        Solution solution = new Solution();
        int length = solution.removeDuplicates(nums);
        System.out.println("Length of the array after removing duplicates: " + length);
        System.out.print("Array after removing duplicates: ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        // nums is empty
        if (length == 0) {
            return 0;
        }
        // nums contains one element 
        if (length == 1) {
            return 1;
        }

        int index = 1;
        int lastNum = nums[0];
        int i = 1;
        while (i != length) {
            if (lastNum != nums[i]) {
                nums[index] = nums[i];
                index++;
            }
            lastNum = nums[i];
            i++;
        }
        return index;
    }
}
