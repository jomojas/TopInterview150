package _88;

public class MergeSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1};
        int n = 1;
        Solution solution = new Solution();
        solution.merge(nums1, m, nums2, n);
        for (int num : nums1) {
            System.out.print(num + " ");
        }
    }
}


class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        /* Method learned from solution */
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1; // postion where the larger number will be put
        // Iterate nums2
        while (j >= 0) {
            // If i is out of bounds, or nums2[j] is larger than nums1[i], put nums2[j] in nums1[k]
            // Else, put nums1[i] in nums1[k]
            // When i is out of bounds, since i >= 0 is executed first, nums1[i] will be ignored
            if (i >= 0 && nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                i--;
            } else {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
    }
}