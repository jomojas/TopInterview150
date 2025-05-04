package _530;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class MinimumAbsoluteDifferenceinBST {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int result = solution.getMinimumDifference(root);
        System.out.println("Minimum absolute difference: " + result); // Output: 1
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

/* My method (In-Order traverse)(learned) */
class Solution {
    public int getMinimumDifference(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        TreeNode node = root;
        while(node != null || !stack.isEmpty()) {
            if(node != null) {
                stack.push(node);
                node = node.left;
            } else {
                node = stack.pop();
                arr.add(node.val);
                node = node.right;
            }
        }
        int res = arr.get(1) - arr.get(0);
        for(int i = 0; i < arr.size() - 1; i++) {
            if(arr.get(i + 1) - arr.get(i) < res) {
                res = arr.get(i + 1) - arr.get(i);
            }
        }
        return res;
    }
}

/* Modified (No Array) */
// class Solution {
//     public int getMinimumDifference(TreeNode root) {
//         Stack<TreeNode> stack = new Stack<>();
//         TreeNode node = root;
//         int prev = -1;
//         int res = Integer.MAX_VALUE;
//         while(node != null || !stack.isEmpty()) {
//             while(node != null) {
//                 stack.push(node);
//                 node = node.left;
//             }

//             node = stack.pop();
//             if(prev != -1) {    
//                 res = node.val - prev < res ? node.val - prev : res;
//             }
//             prev = node.val;
//             node = node.right;
//         }
//         return res;
//     }
// }

/* Solution (Recursion Traverse) */
// class Solution {
//     private int prev = -1;
//     private int minDiff = Integer.MAX_VALUE;

//     public int getMinimumDifference(TreeNode root) {
//         inOrder(root);
//         return minDiff;
//     }

//     private void inOrder(TreeNode node) {
//         if (node == null) return;

//         inOrder(node.left);  // Traverse left

//         if (prev != -1) {
//             minDiff = Math.min(minDiff, node.val - prev);
//         }
//         prev = node.val;     // Update previous value

//         inOrder(node.right); // Traverse right
//     }
// }