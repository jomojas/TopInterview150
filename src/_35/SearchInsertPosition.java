package _35;

public class SearchInsertPosition {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        int target = 5;
        System.out.println(solution.searchInsert(nums, target)); // Output: 2

        target = 2;
        System.out.println(solution.searchInsert(nums, target)); // Output: 1

        target = 7;
        System.out.println(solution.searchInsert(nums, target)); // Output: 4

        target = 0;
        System.out.println(solution.searchInsert(nums, target)); // Output: 0
    }
}

/* My method */
// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         if(target > nums[nums.length -1]) return nums.length;
//         if(target < nums[0]) return 0;
//         return findTarget(nums, 0, nums.length - 1, target);
//     }

//     private int findTarget(int[] nums, int left, int right, int target) {
//         int middle = left + (right - left) / 2;

//         if(nums[middle] == target) {
//             return middle;
//         } 
//         if(left == middle) return left + 1;

//         if(nums[middle] < target) {
//             return findTarget(nums, middle, right, target);
//         } else {
//             return findTarget(nums, left, middle, target);
//         }
//     }
// }

/* Modified by AI */
// class Solution {
//     public int searchInsert(int[] nums, int target) {
//         return findTarget(nums, 0, nums.length - 1, target);
//     }

//     private int findTarget(int[] nums, int left, int right, int target) {
//         if (left > right) {
//             return left; // This is where we would insert the target
//         }
        
//         int middle = left + (right - left) / 2;
        
//         if (nums[middle] == target) {
//             return middle;
//         } else if (nums[middle] < target) {
//             return findTarget(nums, middle + 1, right, target);
//         } else {
//             return findTarget(nums, left, middle - 1, target);
//         }
//     }
// }

/* Solution (iteration) */
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while(left <= right) {
            mid = left + (right - left) / 2;
            if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return left;
    }
}