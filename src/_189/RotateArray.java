package _189;

public class RotateArray {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        solution.rotate(nums, 3);
        printArray(nums);
    }

    public static void printArray(int[] nums) {
        for(int e : nums) {
            System.out.print(e);
        }
    }
}

/* My method */
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        if(k == 0) return;
        int[] temp = new int[nums.length - k];
        for(int i = 0; i < nums.length - k; i++) {
            temp[i] = nums[i];
        }
        int index = 0;
        int i = 0;
        int j = nums.length - k;
        while(index != nums.length) {
            if(j < nums.length) {
                nums[index++] = nums[j++];
            } else {
                nums[index++] = temp[i++];
            }
        }
    }
}


/* Solution (space complexity: O(1)) */
// class Solution {
//     public void rotate(int[] nums, int k) {
//         k = k % nums.length;

//         reverse(nums, 0, nums.length - 1);
//         reverse(nums, 0, k - 1);
//         reverse(nums, k, nums.length - 1);
//     }

//     private void reverse(int[] nums, int left, int right) {
//         while(left < right) {
//             int temp = nums[left];
//             nums[left] = nums[right];
//             nums[right] = temp;
//             left++;
//             right--;
//         }
//     }   
// }


/* Solution (Not understand yet) */
// class Solution {
//     public void rotate(int[] nums, int k) {
//         RotateFrom(nums, k, 0);
//     }

//     public void RotateFrom(int[] nums, int k, int startIndex) {
//         k = k % (nums.length - startIndex);
//         if ( k == 0) return;

//         for(int j = 0; j < k; j++) {
//             Swap(nums, startIndex+j, nums.length - k + j);
//         }

//         RotateFrom(nums, k, startIndex + k);
//     }

//     public void Swap(int[] nums, int i, int j) {
//         int temp = nums[j];
//         nums[j] = nums[i];
//         nums[i] = temp;
//     }
// } 