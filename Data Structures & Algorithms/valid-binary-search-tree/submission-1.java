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
* given a binary tree, return true if it is a valid binary search tree, false otherwise
*
* a tree is said to be a valid BST if:
* -left subtree of every node contains only nodes with keys less than node's key
* -right subtree of every node contains only nodes with keys bigger than node's key
* -both subtrees are BSTs themselves
*
* to solve this question, we can recurse DFS with bounds to ensure each node value
* satisfies this condition: min <= node.val <= max
* 1. if root null -> return true
*
* 2, if node.val less than min OR node.val bigger than max -> return false
*
* 3. recurse from left & right subtrees
*/
class Solution {
    // helper function to validate BSTs
    private boolean checkBST(TreeNode node, long min, long max) {
        // if node null -> return true
        if(node == null) return true;

        // values on left not strictly decreasing or values on right not strictly increasing
        if(node.val <= min || node.val >= max) {
            return false;
        }

        // recurse from both subtrees
        return checkBST(node.left, min, node.val)
                && checkBST(node.right, node.val, max);
    }

    public boolean isValidBST(TreeNode root) {
        // return result from helper call
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
