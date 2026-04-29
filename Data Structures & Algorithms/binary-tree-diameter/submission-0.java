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

class Solution {
    // init variables
    private int diameter = 0;

    // helper to calculate height of subtrees
    private int dfs(TreeNode node) {
        // if node null -> return 0
        if(node == null) return 0;

        // calc heights of left & right subtrees
        int leftHeight = dfs(node.left);
        int rightHeight = dfs(node.right);

        // update diameter seen so far
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // add 1 for each node visited and get max height of both subtrees
        return 1 + Math.max(leftHeight, rightHeight);
    }
    
    public int diameterOfBinaryTree(TreeNode root) {
        // call helper function
        dfs(root);

        // return longest diameter seen
        return diameter;
    }
}
