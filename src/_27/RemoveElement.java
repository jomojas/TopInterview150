package _27;

public class RemoveElement {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        Solution solution = new Solution();
        int length = solution.removeElement(nums, val);
        System.out.println("Length of the array after removing " + val + ": " + length);
        System.out.print("Array after removing " + val + ": ");
        for (int i = 0; i < length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}

class Solution {
    public int removeElement(int[] nums, int val) {
        int length = nums.length;
        // nums is empty
        if (length == 0) {
            return 0;
        }
        // the only number in nums is equal to val
        if (length == 1 && nums[0] == val) {
            return 0;
        }
        int i = 0;
        int j = length - 1;
        int valNum = 0;
        while (i != j) {
            if (nums[i] == val) {
                valNum++;
                nums[i] = nums[j];
                j--;
                if (i == j && nums[i] == val) {
                    valNum++;
                }
                continue;
            }
            i++;
            if (i == j && nums[i] == val) {
                    valNum++;
            }
        }
        return length - valNum;
    }
}
