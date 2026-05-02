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
*
* rebuild binary tree from preorder and inorder traversals and return its root
*/
class Solution {
    // init variables
    private int preIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    // helper function to build tree
    private TreeNode build(int[] preorder, int left, int right) {
        // if left and right intersect -> return null
        if(left > right) return null;

        // set root value from preorder array
        int rootVal = preorder[preIndex++];

        // create root for this value
        TreeNode root = new TreeNode(rootVal);

        // calc current mid as value at rootVal in inorder
        int mid = inorderMap.get(rootVal);

        // build left and right subtrees
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        // return resulting root
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // build HashMap
        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        // call helper function
        return build(preorder, 0, inorder.length - 1);
    }
}
