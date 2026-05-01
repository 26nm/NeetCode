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
    // helper function to count good nodes
    private int dfs(TreeNode node, int maxSoFar) {
        // if node null -> return 0
        if(node == null) return 0;

        // track # of good nodes
        int count = 0;

        // if current node val > current max node value, it's good node
        if(node.val >= maxSoFar) {
            count = 1;
        }

        // update max node value seen so far
        maxSoFar = Math.max(maxSoFar, node.val);

        // recurse from left & right subtrees
        count += dfs(node.left, maxSoFar);
        count += dfs(node.right, maxSoFar);

        // return number of good nodes
        return count;
    }

    public int goodNodes(TreeNode root) {
        // return result from helper function
        return dfs(root, Integer.MIN_VALUE);
    }
}
