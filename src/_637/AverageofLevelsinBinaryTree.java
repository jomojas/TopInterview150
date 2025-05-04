package _637;

import java.util.ArrayList;
import java.util.LinkedList;   
import java.util.List;
import java.util.Queue;

public class AverageofLevelsinBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<Double> averages = solution.averageOfLevels(root);
        for (double avg : averages) {
            System.out.print(avg + " ");
        }
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

/* My method */
class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int count = queue.size();
            double sum = 0;
            for(int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                sum += node.val;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            ans.add(sum / count);
        }
        return ans;
    }
}

/* Solution (Recursion) */
// class Solution {
//     public List<Double> averageOfLevels(TreeNode root) {
//         List<Double> ans = new ArrayList<>();
//         List<Integer> levelCount = new ArrayList<>();
//         levelAverages(root, 0, ans, levelCount);
//         for(int i = 0; i < ans.size(); i++) {
//             ans.set(i, ans.get(i) / levelCount.get(i));
//         }
//         return ans;
//     }

//     private void levelAverages(TreeNode node, int levelIndex, List<Double> ans, List<Integer> levelCount) {
//         if(node == null) return;

//         // Current node is the left most node of current level
//         if(ans.size() == levelIndex) {
//             ans.add(Double.valueOf(node.val));
//             levelCount.add(1);
//         } else {
//             ans.set(levelIndex, ans.get(levelIndex) + Double.valueOf(node.val));
//             levelCount.set(levelIndex, levelCount.get(levelIndex) + 1);
//         }

//         levelAverages(node.left, levelIndex + 1, ans, levelCount);
//         levelAverages(node.right, levelIndex + 1, ans, levelCount);
//     }
// }