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
* we are given the roots of two binary trees root and subRoot
*
* return true if a subtree of root has the same structure as
* subRoot, false otherwise
* -a tree is also considered a subtree of itself
*
* to solve this question, we might implement a helper method to
* compare tree structure:
* 1. if subRoot null -> return true
*    
* 2. if root null -> return false
*
* 3. if both root and subRoot identical -> return true
*
* 4. recurse from both sides on root to compare against subRoot
*/
class Solution {  
    // helper function to compare two trees
    private boolean isSameTree(TreeNode p, TreeNode q) {
        // if both roots null -> return true
        if(p == null && q == null) return true;

        // if one of the roots null -> return false
        else if(p == null || q == null) return false;

        // if values mismatch -> return false
        else if(p.val != q.val) return false;

        // recurse from both sides on both subtrees
        return (isSameTree(p.left, q.left) && isSameTree(p.right, q.right));
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // if subRoot null -> return true
        if(subRoot == null) return true;

        // if root null -> return false
        if(root == null) return false;

        // if root & subRoot identical -> return true
        if(isSameTree(root, subRoot)) return true;

        // recurse from both sides on root to compare again subRoot
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
}
