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
* we are given the root of non-empty binary tree
*
* return the max path sum of any non-empty path
*
* path defined as:
* -sequence of nodes where each pair of adjacent nodes
*  has edge connecting them
* -node cannot appear more than once
* -doesnt necessarily need to include root
*
* to solve this, we can use post-order tree traversal:
* 1. if root null -> return 0
*
* 2. calculate left & right gain
*
* 3. calculate current path through node sum
*
* 4. update max path seen so far to max of current value and path through node sum
*
* 5. return node val + max of left & right path sums
*/
class Solution {
    // init global variable
    int maxSum = Integer.MIN_VALUE;

    // helper function to calculate best path sum
    private int findBestPath(TreeNode node) {
        // if node is null -> return 0
        if(node == null) return 0;

        // calculate left & right gains
        int leftGain = Math.max(0, findBestPath(node.left));
        int rightGain = Math.max(0, findBestPath(node.right));

        // calc path through node sum
        int pathThroughNode = node.val + leftGain + rightGain;

        // update max seen so far
        maxSum = Math.max(maxSum, pathThroughNode);

        // return current node val + best of left & right paths
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        // call helper function
        findBestPath(root);

        // return max sum
        return maxSum;
    }
}
