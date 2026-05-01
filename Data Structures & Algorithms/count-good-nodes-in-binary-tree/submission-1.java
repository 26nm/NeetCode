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
* we are given a binary tree root
*
* return number of good nodes within the tree
* -node is said to be good if path from root to this node
*  has no values exceeding this node's
*
* to solve this, we can use DFS to track the max node value
* seen so far:
*
* 1. if node null -> return 0
*
* 2. set count to 0
*
* 3 if current node val exceeds max node val so far -> set count to 1
*   -update max value node seen so far
*
* 4. calculate count by recursing from both subtrees
*
* 5. return result
*/
class Solution {
    // helper function to count good nodes
    private int countGoodNodes(TreeNode node, int maxSoFar) {
        // if node null -> return 0
        if(node == null) return 0;

        // track # of good nodes
        int count = 0;

        // if current node val exceeds max node value seen, node is "good"
        if(node.val >= maxSoFar) count = 1;

        // update max node value seen so far
        maxSoFar = Math.max(maxSoFar, node.val);

        // count other good nodes by recursing left & right
        count += countGoodNodes(node.left, maxSoFar);
        count += countGoodNodes(node.right, maxSoFar);

        // return # of good nodes counted
        return count;
    }

    public int goodNodes(TreeNode root) {
        // return resulting count from helper call
        return countGoodNodes(root, Integer.MIN_VALUE);
    }
}
