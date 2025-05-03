package _226;

public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        TreeNode invertedRoot = solution.invertTree(root);

        // Print the inverted tree (in-order traversal)
        printInOrder(invertedRoot); // Output: 9 7 6 4 3 2 1
    }
    
    public static void printInOrder(TreeNode node) {
        if (node != null) {
            printInOrder(node.left);
            System.out.print(node.val + " ");
            printInOrder(node.right);
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return root;
        invertTree(root.left);
        invertTree(root.right);
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        return root;
    }
}

/* Improved by ChatGpt */
// class Solution {
//     public TreeNode invertTree(TreeNode root) {
//         if (root == null) return root;
//         TreeNode temp = root.left;
//         root.left = invertTree(root.right);
//         root.right = invertTree(temp);
//         return root;
//     }
// }
