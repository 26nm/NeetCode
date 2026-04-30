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
* return the level order traversal of it as a nested list
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // init variables
        List<List<Integer>> result = new ArrayList<>();

        // if root null -> return empty list
        if(root == null) return result;

        // create queue to hold nodes at each level
        Queue<TreeNode> queue = new LinkedList<>();

        // add root to queue
        queue.offer(root);

        // iterate until queue empty
        while(!queue.isEmpty()) {
            // count number of nodes at current level
            int size = queue.size();

            // make a list to store node values at current level
            List<Integer> level = new ArrayList<>();

            // iterate through level size
            for(int i = 0; i < size; i++) {
                // extract current node, add its value to list
                TreeNode node = queue.poll();
                level.add(node.val);

                // if it has a left child -> add to queue
                if(node.left != null) {
                    queue.offer(node.left);
                }

                // if it has a right child -> add to queue
                if(node.right != null) {
                    queue.offer(node.right);
                }
            }

            // add processed level to result
            result.add(level);
        }

        // return resulting list
        return result;
    }
}
