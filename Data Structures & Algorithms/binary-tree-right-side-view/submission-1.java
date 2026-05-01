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
* we are given root of binary tree
*
* return only the values of the nodes visibl from right side of tree, ordered
* from top to bottom.
*
* to solve this, we can use DFS with right-first approach:
* 1. if root is null -> stop
*
* 2. if current depth matches list size -> add node value to list (looking at only node reached)
*
* 3. recurse from right & left (order matters)
*
* 4. return resulting list
*/
class Solution {
    // helper function to perform DFS with right-first approach
    private void dfsRight(TreeNode node, int depth, List<Integer> input) {
        // if node null -> stop
        if(node == null) return;

        // if depth matches input size -> we reached right node to insert its value
        if(depth == input.size()) {
            input.add(node.val);
        }

        // recurse from right & left
        dfsRight(node.right, depth + 1, input);
        dfsRight(node.left, depth + 1, input);
    }

    public List<Integer> rightSideView(TreeNode root) {
        // create list to store result
        List<Integer> result = new ArrayList<>();

        // call helper function
        dfsRight(root, 0, result);

        // return state of result after helper call
        return result;
    }
}
