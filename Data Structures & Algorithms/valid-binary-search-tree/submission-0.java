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
    // helper method to validate BST
    private boolean checkBST(TreeNode node, long min, long max) {
        // if node null -> return true
        if(node == null) return true;

        // left child exceeds node value or right child value below node value
        if(node.val <= min || node.val >= max) {
            return false;
        }

        // recurse from left and right subtrees
        return checkBST(node.left, min, node.val) 
                && checkBST(node.right, node.val, max);
    }
    public boolean isValidBST(TreeNode root) {
        // return result of helper call
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
