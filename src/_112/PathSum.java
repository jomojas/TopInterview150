package _112;

// import java.util.LinkedList;
// import java.util.Queue;
// import java.util.Stack;

public class PathSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // Example usage
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        boolean result = solution.hasPathSum(root, targetSum);
        System.out.println("Has path sum: " + result); // Output: true
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        /* Solution */
        if(root == null) return false;

        if(root.left == null && root.right == null) {
            return targetSum == root.val;
        }

        targetSum -= root.val;

        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }
}


/* Solution (DFS(stack) BFS(queue)) */
// class Solution {
//     public  boolean hasPathSum(TreeNode root, int targetSum) {
//         /* DFS */
//         // if(root == null) return false;
//         // Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
//         // stack.push(new Pair<>(root, root.val));
//         // while(!stack.isEmpty()) {
//         //     Pair<TreeNode, Integer> cur = stack.pop();
//         //     TreeNode curNode = cur.getKey();
//         //     int sum = cur.getValue();

//         //     if(curNode.left == null && curNode.right == null && sum == targetSum) {
//         //         return true;
//         //     }
//         //     if(curNode.left != null) {
//         //         stack.push(new Pair<>(curNode.left, curNode.left.val + sum));
//         //     }
//         //     if(curNode.right != null) {
//         //         stack.push(new Pair<>(curNode.right, curNode.right.val + sum));
//         //     }
//         // }
//         // return false;

//         /* BFS */
//         // if(root == null) return false;
//         // Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
//         // queue.add(new Pair<>(root, root.val));
//         // while(!queue.isEmpty()) {
//         //     Pair<TreeNode, Integer> cur = queue.poll();
//         //     TreeNode curNode = cur.getKey();
//         //     int sum = cur.getValue();

//         //     if(curNode.left == null && curNode.right == null && sum == targetSum) {
//         //         return true;
//         //     }
//         //     if(curNode.left != null) {
//         //         queue.add(new Pair<>(curNode.left, curNode.left.val + sum));
//         //     }
//         //     if(curNode.right != null) {
//         //         queue.add(new Pair<>(curNode.right, curNode.right.val + sum));
//         //     }
//         // }
//         // return false;
//     }
// }

// class Pair<K, V> {
//     private K key;
//     private V value;

//     public Pair(K key, V value) {
//         this.key = key;
//         this.value = value;
//     }

//     public K getKey() {
//         return key;
//     }
//     public V getValue() {
//         return value;
//     }
// }