package _100;

import java.util.LinkedList;
import java.util.Queue;

public class SameTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        TreeNode p = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode q = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        System.out.println(solution.isSameTree(p, q)); // Output: true
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        /* My method (BFS Learned) */
        Queue<TreeNode> queueP = new LinkedList<>();
        Queue<TreeNode> queueQ = new LinkedList<>();
        queueP.add(p);
        queueQ.add(q);
        while(!queueP.isEmpty() && !queueQ.isEmpty()) {
            TreeNode nodeP = queueP.poll();
            TreeNode nodeQ = queueQ.poll();
            if(nodeP == null && nodeQ == null) continue;
            if(nodeP == null || nodeQ == null) return false;
            if(nodeP.val != nodeQ.val) return false;
            queueP.add(nodeP.left);
            queueP.add(nodeP.right);
            queueQ.add(nodeQ.left);
            queueQ.add(nodeQ.right);
        }
        return true;

        /* Solution */
        // if(p == null && q == null) return true;
        // if(p == null || q == null) return false;
        // if(p.val != q.val) return false;
        // return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}