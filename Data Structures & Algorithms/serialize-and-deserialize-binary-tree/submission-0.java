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
* serialize the tree such that you can turn it
* into a string and revert it back to its
* original structure
*
* to solve this question, what if we... converted
* the tree into an array, and then use that array
* to convert back into the original tree?
*/
public class Codec {

    // helper function to serialize a tree
    private void serializeToString(TreeNode node, StringBuilder sb) {
        // if node null -> append "null" and stop
        if(node == null) {
            sb.append("null,");
            return;
        }

        // append node value followed with commas
        sb.append(node.val).append(",");

        // recurse from left & right subtrees
        serializeToString(node.left, sb);
        serializeToString(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // create string builder to hold serialized tree
        StringBuilder sb = new StringBuilder();

        // call helper function to serialize tree
        serializeToString(root, sb);

        // return resulting string
        return sb.toString();
    }

    // helper function to deserialize tree
    private TreeNode deserializeToTree(Queue<String> queue) {
        // extract current serialized node
        String val = queue.poll();

        // if value is null -> return null
        if(val.equals("null")) {
            return null;
        }

        // create node to hold extracted value
        TreeNode node = new TreeNode(Integer.parseInt(val));

        // create left & right subtrees
        node.left = deserializeToTree(queue);
        node.right = deserializeToTree(queue);

        // return resulting node;
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // split dats with comma as delimiter
        String[] values = data.split(",");

        // create queue to process data FIFO
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));

        // call helper function
        return deserializeToTree(queue);
    }
}
