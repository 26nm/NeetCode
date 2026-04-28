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
    * we are given the root of a binary tree root
    *
    * invert the tree and return its root
    *
    * to solve this question, we could use DFS recursion:
    * 1. if root is null, return null <-- base case
    *
    * 2. swap children
    *
    * 3. recurse from left and right
    *
    * 4. return root
    */
    public TreeNode invertTree(TreeNode root) {
        // if root null return null
        if(root == null) return null;

        // swap children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // recurse from left and right
        invertTree(root.left);
        invertTree(root.right);

        // return root
        return root;
    }
}
