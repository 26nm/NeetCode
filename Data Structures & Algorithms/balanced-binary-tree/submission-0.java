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
    // helper method to calculate subtree height
    private int dfs(TreeNode root) {
        // if root null -> return 0
        if(root == null) return 0;

        // calc left subtree height & check if already unbalanced
        int leftHeight = dfs(root.left);
        if(leftHeight == -1) return -1;

        // calc right subtree height & check if already unbalanced
        int rightHeight = dfs(root.right);
        if(rightHeight == -1) return -1;

        // check if height diffs are balanced
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // return 1 for every node explored + max of left & right subtree heights
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        // return result of helper function call
        return dfs(root) != -1;
    }
}
