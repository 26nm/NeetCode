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
* implement algorithms to serialize and deserialize a binary tree
*
* to solve this question, we can use pre-order to serialize the tree:
* 1. if node is null -> append "null," and stop
*
* 2. append node value followed with comma
*
* 3. recurse from left & right subtree
*
* to deserialize the tree, we can:
* 1. extract current node from queue
*    -if value is null -> return null
*    
* 2. parse node value, create new node for it
*
* 3. create left & right subtrees for this node
*
* 4. return resulting node
*/
public class Codec {
    // helper function to serialize tree
    private void serializeToString(TreeNode node, StringBuilder sb) {
        // if node is null -> append "null," to string and stop
        if(node == null) {
            sb.append("null,");
            return;
        }

        // append current node value followed with comma
        sb.append(node.val).append(",");

        // recurse from left & right
        serializeToString(node.left, sb);
        serializeToString(node.right, sb);
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        // create string builder to hold serialized tree
        StringBuilder sb = new StringBuilder();

        // call helper function
        serializeToString(root, sb);

        // return resulting serialization
        return sb.toString();
    }

    // helper function to deserialize tree
    private TreeNode deserializeToTree(Queue<String> queue) {
        // extract current serialized node
        String value = queue.poll();

        // if node is "null" -> return null
        if(value.equals("null")) {
            return null;
        }

        // create node to hold parsed value
        TreeNode node = new TreeNode(Integer.parseInt(value));

        // create left & right subtrees
        node.left = deserializeToTree(queue);
        node.right = deserializeToTree(queue);

        // return resulting node
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        // split data with comma delimiter
        String[] values = data.split(",");

        // create queue to process serialized nodes FIFO style
        Queue<String> queue = new LinkedList<>(Arrays.asList(values));

        // call helper function
        return deserializeToTree(queue);
    }
}
