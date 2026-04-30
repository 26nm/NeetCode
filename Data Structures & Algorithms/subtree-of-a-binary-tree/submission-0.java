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
    // helper method to check if two trees identical
    private boolean isSameTree(TreeNode a, TreeNode b) {
        // if both nodes null -> same tree
        if(a == null && b == null) return true;

        // if one of the nodes null -> diff structure
        if(a == null || b == null) return false;

        // if values mismatch -> diff tree
        if(a.val != b.val) return false;

        // compare both subtrees from left and right
        return (isSameTree(a.left, b.left) 
                && isSameTree(a.right, b.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if subroot null -> return true
        if(subRoot == null) return true;

        // if root null -> return false
        if(root == null) return false;

        // if trees are identical -> return true
        if(isSameTree(root, subRoot)) return true;

        // recurse root from left & right to compare against subRoot
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
}
