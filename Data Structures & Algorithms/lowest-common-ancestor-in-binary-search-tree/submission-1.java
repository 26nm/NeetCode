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
* we are given a binary search tree and two nodes from the tree p and q
*
* find the lowest common ancestor (LCA) of p & q
* -LCA is said to be lowest node in a tree T such that both p & q 
*  are descendants
*
* to solve this, we can use an iterative approach:
* 1. while root not null:
*    -if both p's and q's values smaller than root's -> move left
*    -otherwise, if bigger -> move right
*    -otherwise, ancestor is found (values converge) -> return this node
*
* 2. return a null
*/
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // iterate until null node reached
        while(root != null) {
            // move left if p & q smaller than root
            if(p.val < root.val && q.val < root.val) {
                root = root.left;

            // move right if p & q bigger than root
            } else if(p.val > root.val && q.val > root.val) {
                root = root.right;

            // ancestor found
            } else {
                return root;
            }
        }

        // ancestor not found
        return null;
    }
}
