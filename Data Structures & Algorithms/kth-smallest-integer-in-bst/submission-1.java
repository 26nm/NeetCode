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
* we are given root of a binary search tree, and integer k
* 
* return the kth smallest (1-indexed) value in the tree
*
* to solve this question, we can perform an inorder traversal
* and stop at the kth element:
* 1. if root null -> stop
*
* 2. recurse from the left subtree
*
* 3. increment count
*
* 4. if count matches k -> match found
*    -update result to node value
*    -stop
*
* 5. recurse from the right subtree
*/
class Solution {
    // init variables
    private int count = 0;
    private int result = 0;

    // helper function to perform inorder traversal
    private void inorder(TreeNode node, int k) {
        // if node null -> stop
        if(node == null) return;

        // recurse from left subtree
        inorder(node.left, k);

        // increment count as we go
        count++;

        // if count matches k -> match found
        if(count == k) {
            result = node.val;
            return;
        }

        // recurse from right subtree
        inorder(node.right, k);
    }

    public int kthSmallest(TreeNode root, int k) {
        // call helper function
        inorder(root, k);
        
        // return result after helper call
        return result;
    }
}
