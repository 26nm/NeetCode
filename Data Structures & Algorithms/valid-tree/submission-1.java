/**
* given n nodes labeled from 0 to n-1 and list of undirected edges
* write function to check whether these edges make up a valid tree
* -you may assume no duplicate edges will appear in edges
*
* to solve this question, we can consider following algo:
*
* helper:
* 1. if we visit same node again -> return false
*
* 2. mark node visited
*
* 3. iterate through node's neighbors:
*    -if we encounter a parent node -> skip it
*    -if dfs fails -> return false
*
* 4. return true
*
* main function:
* 1. create map to represent graph
*
* 2. add list to each slot in graph
*
* 3. add edges to the graph
*
* 4. make a set to track visited nodes
*
* 5. run dfs on the graph:
*    -if it fails -> return false
*
* 6. check if size of visited matches n (all nodes reachable)
*/
class Solution {
    // helper function to perform dfs
    private boolean dfs(
        int node,
        int parent,
        Map<Integer, List<Integer>> graph,
        Set<Integer> visited) {
        // if we encounter same node again -> return false
        if(visited.contains(node)) return false;

        // mark node visited
        visited.add(node);

        // visit neighbors
        for(int neighbor : graph.get(node)) {
            // if node is a parent -> skip it
            if(neighbor == parent) continue;
            
            // if dfs fails -> return false
            if(!dfs(neighbor, node, graph, visited))
                return false;
        }

        // successfully traversed nodes
        return true;
    }

    public boolean validTree(int n, int[][] edges) {
        // create map to represent graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // add list to each slot in graph
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // connect nodes in graph
        for(int[] edge : edges) {
            // get current node pair
            int u = edge[0];
            int v = edge[1];

            // connect nodes
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // create set to track nodes already visited
        Set<Integer> visited = new HashSet<>();

        // if dfs fails -> return false
        if(!dfs(0, -1, graph, visited)) return false;

        // return if all nodes reachable
        return visited.size() == n;
    }
}
