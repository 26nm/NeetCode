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

/**
* given a node in connected undirected graph, return deep copy of the graph
* -graph is shown as adjacency list
* -node values are numbered from 1 to n
*
* to solve this question, we can consider following approach:
* 1. create HashMap to store already cloned nodes
*
* 2. if node null -> return null
*
* 3. if map already contains cloned node -> return existing
*
* 4. create new node -> put it inside map
*
* 5. iterate through node's neighbors:
*    -clone each neighbor and add to list
*
* 6. return cloned node
*/
class Solution {
    // create map to prevent node duping
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        // if node null -> return null
        if(node == null) return null;

        // if node already cloned -> return existing
        if(map.containsKey(node)) return map.get(node);

        // make new node and add to map
        Node cloned = new Node(node.val);
        map.put(node, cloned);

        // iterate through node's neighbors
        for(Node neighbor : node.neighbors) {
            // add each neighbor
            cloned.neighbors.add(cloneGraph(neighbor));
        }

        // return cloned node
        return cloned;
    }
}