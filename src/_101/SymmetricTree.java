package _101;

// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Stack;

public class SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println(solution.isSymmetric(root)); // Output: true
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

/* My method 1 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode node1, TreeNode node2) {
        if(node1 == null && node2 == null) return true;
        if(node1 == null || node2 == null) return false;
        if(node1.val != node2.val) return false;
        return isSymmetric(node1.right, node2.left) && isSymmetric(node1.left, node2.right);
    }
}

/* My method 2 */
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         Queue<TreeNode> queue1 = new LinkedList<>();
//         Queue<TreeNode> queue2 = new LinkedList<>();
//         queue1.add(root.left);
//         queue2.add(root.right);
//         while(!queue1.isEmpty() && !queue2.isEmpty()) {
//             TreeNode node1 = queue1.poll();
//             TreeNode node2 = queue2.poll();
//             if(node1 == null && node2 == null) continue;
//             if(node1 == null || node2 == null) return false;
//             if(node1.val != node2.val) return false;
//             queue1.add(node1.left);
//             queue1.add(node1.right);
//             queue2.add(node2.right);
//             queue2.add(node2.left);
//         }
//         return true;
//     }
// }

/* Solution */
// class Solution {
//     public boolean isSymmetric(TreeNode root) {
//         if (root == null) return true;
//         Stack<TreeNode> stack = new Stack<>();
//         stack.push(root.left);
//         stack.push(root.right);
//         while (!stack.empty()) {
//             TreeNode n1 = stack.pop(), n2 = stack.pop();
//             if (n1 == null && n2 == null) continue;
//             if (n1 == null || n2 == null || n1.val != n2.val) return false;
//             stack.push(n1.left);
//             stack.push(n2.right);
//             stack.push(n1.right);
//             stack.push(n2.left);
//         }
//         return true;
//     }
// }