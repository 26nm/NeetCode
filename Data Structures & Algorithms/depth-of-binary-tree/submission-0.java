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
    * we are given the root of binary tree
    *
    * return the depth
    *
    * to solve this, we could use DFS recursion:
    * 1. if root is 0, return 0
    *
    * 2. otherwise, add 1 to whichever has bigger result
    *    from recursing left and right
    */
    public int maxDepth(TreeNode root) {
        // if root is null, return 0
        if(root == null) return 0;

        // add 1 to the max of left and right, keep going
        return 1 + (Math.max(maxDepth(root.left), maxDepth(root.right)));
    }
}
