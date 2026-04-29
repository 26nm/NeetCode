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
* given binary tree, return true if it is balanced or false otherwise
* -binary tree is said to be balanced IFF height of left and right
*  subtrees differ no more than 1
*
* to solve this question, we can implement a helper function to recursively
* calculate heights of both subtrees:
* 1. if node null -> return 0
*
* 2. calc left subtree height
*    -if value is already -1 -> return -1
*    -do the same for the right subtree
*
* 3. check if abs value of leftHeight - rightHeight bigger than 1
*    -if so, return -1
*
* 4. otherwise return 1 + max of left & right heights
*
* 5. return result of helper function call
*/
class Solution {
    // helper function to calculate subtree height
    private int calcHeight(TreeNode node) {
        // if root null -> return 0
        if(node == null) return 0;

        // calc left subtree height and check if already unbalanced
        int leftHeight = calcHeight(node.left);
        if(leftHeight == -1) return -1;

        // calc right subtree height and check if already unbalanced
        int rightHeight = calcHeight(node.right);
        if(rightHeight == -1) return -1;

        // check if height diffs is 1
        if(Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }

        // return 1 + max of left & right height
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {
        return calcHeight(root) != -1;
    }
}
