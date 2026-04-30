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
* return the level order traversal of its values as a nested list
* -read values from left to right, level-by-level
*
* to solve this question, we use BFS:
* 1. create a list of list integers to store result
*    -if root is null -> return empty list
*
* 2. create a queue to process nodes
*
* 3. add the root to the queue
* 
* 4. iterate while the queue is not empty:
*    -determine how many nodes are at current level (queue.size())
*    -create a list to store node values at current level
*    -iterate 0 to # of nodes at current level:
*     -extract current node and add value to list
*     -if it has a left child -> add to queue
*     -if it has a right child -> add to queue
*    -add processed level to the result
*
* 5. return resulting list
*/
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // init variables
        List<List<Integer>> result = new ArrayList<>();

        // if root null -> return empty list
        if(root == null) return result;

        // create queue to process levels
        Queue<TreeNode> queue = new LinkedList<>();

        // add root to the queue
        queue.offer(root);

        // iterate until queue is empty:
        while(!queue.isEmpty()) {
            // determine how many nodes at current level:
            int size = queue.size();

            // create list to store node values at curr level
            List<Integer> levels = new ArrayList<>();

            // process nodes at current level
            for(int i = 0; i < size; i++) {
                // extract current node and add value to list
                TreeNode node = queue.poll();
                levels.add(node.val);

                // check if it has a left child
                if(node.left != null) queue.offer(node.left);

                // check if it has a right child
                if(node.right != null) queue.offer(node.right);
            }

            // add processed level to resulting list
            result.add(levels);
        }

        // return resulting list
        return result;
    }
}
