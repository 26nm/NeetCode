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
* given node in connected undirected graph, return deep copy of graph
* -each node in graph contains integer value and list of its neighbors
* -graph is implemented as adjacency list
* -for  simplicty, node values numbered from 1 to n
*
* to solve this question, we can consider the following algorithm:
* 1. create map to track already cloned nodes
*
* 2. if node null -> return null
*    -if node already cloned -> return existing
*
* 3. make new node -> copy existing value
*    -add this cloned node to map
*
* 4. iterate through current node's neighbors:
*    -add each cloned neighbor to clone's list of neighbors
*
* 5. return cloned node
*/
class Solution {
    // create map to track already cloned nodes
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        // if node null -> return null
        if(node == null) return null;

        // if node already cloned -> return existing
        if(map.containsKey(node)) return map.get(node);

        // clone this node and add to map
        Node cloned = new Node(node.val);
        map.put(node, cloned);

        // iterate through node's neighbor list
        for(Node neighbor: node.neighbors) {
            // clone each neighbor and add to clone's neighbor list
            cloned.neighbors.add(cloneGraph(neighbor));
        }

        // return cloned node
        return cloned;
    }
}