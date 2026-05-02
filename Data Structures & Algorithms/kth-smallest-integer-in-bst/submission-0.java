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
    private int count = 0;
    private int result = 0;
    
    // helper function to perform inorder traversal
    private void inorder(TreeNode node, int k) {
        // if node null -> stop
        if(node == null) return;

        // recurse from left
        inorder(node.left, k);

        // increment counter as we go
        count++;

        // if count matches k, match found
        if(count == k) {
            result = node.val;
            return;
        }

        // recurse from right
        inorder(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        // call helper function
        inorder(root, k);

        // return result of helper function
        return result;
    }
}
