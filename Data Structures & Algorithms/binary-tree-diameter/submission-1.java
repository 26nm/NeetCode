/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

 /**
 * diameter of binary tree is defined as length of longest path between any
 * two nodes
 * -path does not necessarily need to pass through root
 * -length of path between two nodes is # of edges between nodes
 *
 * given root of tree root, return diameter of tree
 *
 * to solve this question, we can implement helper function to calculate
 * height of subtrees and update max diameter seen so far:
 * 1. if node null -> return 0
 *
 * 2. calculate height for left & right subtrees
 *
 * 3. update diameter to max of its current value and left + right heights
 *
 * 4. return max of left & right heights + 1
 */

class Solution {
    // init variables
    private int diameter = 0;

    // helper to calc subtree heights
    private int dfs(TreeNode node) {
        // if node null -> return 0
        if(node == null) return 0;

        // calc height for left & right subtrees
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        // update diameter to max of its current value and both heights
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // return max of both heights + 1
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        // call helper function
        dfs(root);

        // return diameter seen so far
        return diameter;
    }
}
