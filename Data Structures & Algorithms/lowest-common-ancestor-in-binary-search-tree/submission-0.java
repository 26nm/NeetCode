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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // iterate until null node reached
        while(root != null) {
            // move left if both p & q smaller than root
            if(p.val < root.val && q.val < root.val) {
                root = root.left;

            // move right if both p & q bigger than root
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;

            // ancestor found
            } else {
                return root;
            }
        }

        // no ancestor found
        return null;
    }
}
