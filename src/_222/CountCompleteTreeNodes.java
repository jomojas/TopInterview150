package _222;

// import java.util.LinkedList;
// import java.util.Queue;

public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage:
        // Creating a complete binary tree with 7 nodes
        TreeNode root = new TreeNode(1);   
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.println(solution.countNodes(root));
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
// class Solution {
//     public int countNodes(TreeNode root) {
//         if(root == null) return 0;
//         Queue<TreeNode> queue = new LinkedList<>();
//         queue.add(root);
//         int num = 1;
//         while(true) {
//             TreeNode tempNode = queue.poll();
//             if(tempNode.left == null) return num;
//             else{
//                 queue.add(tempNode.left);
//                 num++;
//             }
//             if(tempNode.right == null) return num;
//             else {
//                 queue.add(tempNode.right);
//                 num++;
//             }
//         }

//         /* Recursion */
//         // if(root == null) return 0;
//         // return countNodes(root.left) + countNodes(root.right) + 1;
//     }
// }

/* Solution (O(logn)) */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int r = getD(root.left, true) + 1;
        int l = getD(root.right, false) + 1;
        if (r == l) return (1 << r) - 1;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int getD(TreeNode root, boolean left) {
        int d = 0;
        while (root != null) {
            root = left ? root.left : root.right;
            d++;
        }
        return d;
    }
}