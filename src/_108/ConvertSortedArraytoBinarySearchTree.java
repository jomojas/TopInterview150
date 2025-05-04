package _108;

public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        int[] nums = {-10, -3, 0, 5, 9};
        TreeNode root = solution.sortedArrayToBST(nums);
        PinrtTree(root);
    }

    public static void PinrtTree(TreeNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        PinrtTree(root.left);
        PinrtTree(root.right);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return findRoot(nums, 0, nums.length - 1);
    }

    private TreeNode findRoot(int[] nums, int left, int right) {
        if(left == right) return new TreeNode(nums[left]);
        if(left > right) return null;
        int middle = left + (right - left) / 2; // over-flow safe
        // int middle = (left + right) / 2;     // not safe for large numbers (left + right > Integer.MAX_VALUE)
        TreeNode leftNode = findRoot(nums, left, middle - 1);
        TreeNode rightNode = findRoot(nums, middle + 1, right);
        return new TreeNode(nums[middle], leftNode, rightNode);
    }
}