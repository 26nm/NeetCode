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
* we are given two integer arrays preorder and inorder
* -preorder is preorder traversal of tree
* -inorder is inorder traversal of tree
* -both arrays same size and have unique values
*
* rebuild binary tree from preorder and inorder traversals and return its root
*
* to solve this question, we might recognize that inorder array tells us
* how to split the tree:
* 1. if left > right -> return null
*
* 2. determine the root from preorder array
*
* 3. create a root node for this value
*
* 4. build left & right subtrees for this root
*
* 5. return resulting root
*/
class Solution {
    // init variables
    private int preIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    // helper method to build the tree
    private TreeNode build(int[] preorder, int left, int right) {
        // if left and right intersect -> return null
        if(left > right) return null;

        // extract root from preorder array
        int rootVal = preorder[preIndex++];

        // calc current mid as value at rootVal in inorder
        int mid = inorderMap.get(rootVal);

        // create node for this root
        TreeNode root = new TreeNode(rootVal);

        // build left & right subtrees for root
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        // return resulting root;
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // build HashMap
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // return resulting root from helper call
        return build(preorder, 0, inorder.length - 1);
    }
}
