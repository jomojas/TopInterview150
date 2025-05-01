package _104;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthofBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        System.out.println(solution.maxDepth(root)); // Output: 3
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

/* My method (BFS) */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                TreeNode top = queue.poll();
                if(top.left != null) queue.add(top.left);
                if(top.right != null) queue.add(top.right);
            }
            depth++;
        }
        return depth;
    }
}

/* Solution (DFS) */
// class Solution {
//     public int maxDepth(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }
//         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));        
//     }
// }