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
    // helper function to recurse with DFS
    private void dfs(TreeNode node, int depth, List<Integer> result) {
        // if node null -> stop
        if(node == null) return;

        // add only first node reached's value to list
        if(depth == result.size()) {
            result.add(node.val);
        }

        // recurse from right & left
        dfs(node.right, depth + 1, result);
        dfs(node.left, depth + 1, result);
    }
    public List<Integer> rightSideView(TreeNode root) {
        // create list to hold result
        List<Integer> result = new ArrayList<>();

        // call helper function
        dfs(root, 0, result);

        // return resulting list
        return result;
    }
}
