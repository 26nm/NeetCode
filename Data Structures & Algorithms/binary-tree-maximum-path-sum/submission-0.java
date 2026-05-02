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
* we are given the root of a non-empty binary tree
*
* return the maximum path sum of any non-empty path
*/
class Solution {
    // init variables
    private int maxSum = Integer.MIN_VALUE;

    // helper function to find best possible path
    private int findBestPath(TreeNode node) {
        // if node null -> return 0
        if(node == null) return 0;

        // calculate left & right gains
        int leftGain = Math.max(0, findBestPath(node.left));
        int rightGain = Math.max(0, findBestPath(node.right));

        // calc path through node value
        int pathThroughNode = node.val + leftGain + rightGain;

        // update max sum seen so far
        maxSum = Math.max(maxSum, pathThroughNode);

        // return current node value + max of left & right path sums
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        // call helper function
        findBestPath(root);

        // return max sum from helper
        return maxSum;
    }
}
