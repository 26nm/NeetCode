/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    // create map to prevent duping nodes
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        // if node null -> return null
        if(node == null) return null;

        // if we already cloned this node -> return existing
        if(map.containsKey(node)) return map.get(node);

        // clone current node
        Node clone = new Node(node.val);

        // put this node in map
        map.put(node, clone);

        // iterate through node's neighbors
        for(Node neighbor : node.neighbors) {
            // add node's neighbors
            clone.neighbors.add(cloneGraph(neighbor));
        }

        // return cloned node
        return clone;
    }
}