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
    /**
    * we are given the root of binary tree root
    *
    * invert binary tree and return its root
    */
    public TreeNode invertTree(TreeNode root) {
        // if root null -> return null
        if(root == null) return null;

        // swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recurse on left and right
        invertTree(root.left);
        invertTree(root.right);

        // return root
        return root;
    }
}
