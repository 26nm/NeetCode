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
* we are given two binary trees p and q
*
* return true if trees are equivalent, return false otherwise
* -trees are said to be the same if they have identical structure
*  and node values
*
* to solve this, we can implement a helper function to compare 
* both trees:
* 1. if both roots null -> return true
*
* 2. else if one of them null -> return false
*
* 3. else if value mismatch -> return false
*
* 4. recurse from the left & right for both trees
*/
class Solution {
    // helper to compare subtrees
    private boolean isSame(TreeNode root1, TreeNode root2) {
        // if both roots null -> return true
        if(root1 == null && root2 == null) return true;

        // if one of the roots null -> return false
        else if(root1 == null || root2 == null) return false;

        // if node values have mismatch -> return false
        else if(root1.val != root2.val) return false;

        return (isSame(root1.left, root2.left) 
                    && isSame(root1.right, root2.right));
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        return isSame(p, q);
    }
}
