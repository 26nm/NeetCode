/**
* we are given a graph of n nodes, an integer n, and an array edges where
* edges[i] = [ai, bi] indicates an edge between ai and bi
* 
* return # of connected components in graph
*
* to solve this question, we can consider following algo:
*
* helper:
* 1. if current node already visited -> stop
*
* 2. mark node visited
*
* 3. iterate through all nodes:
*    -call dfs
*
* main function:
* 1. create map to represent graph
*    -put lists in each slot
*
* 2. fill graph with edges
*
* 3. create hashset to track visited nodes
*
* 4. track # of components, start at 0
*
* 5. iterate through all nodes in graph:
*    -if node unexplored -> increment component count and start dfs
*
* 6. return # of components
*/
class Solution {
    // helper function to perform dfs
    private void dfs(
        int node,
        Map<Integer, List<Integer>> graph,
        Set<Integer> visited) {
        // if we visit node again -> stop
        if(visited.contains(node)) return;

        // mark node visited
        visited.add(node);

        // iterate through all neighbors
        for(int neighbor : graph.get(node)) {
            // dfs on all neighbors
            dfs(neighbor, graph, visited);
        }

    }
    public int countComponents(int n, int[][] edges) {
        // create map to represent list
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // add lists for each slot in graph
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // put edge pairs in graph
        for(int[] edge : edges) {
            // get current edge pair
            int u = edge[0];
            int v = edge[1];

            // connect edge pair
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // create set to track visited nodes
        Set<Integer> visited = new HashSet<>();

        // track # of connected components, start at 0
        int components = 0;

        // iterate through all nodes in graph
        for(int node = 0; node < n; node++) {
            // check if node unvisited
            if(!visited.contains(node)) {
                // increment count and start dfs
                components++;
                dfs(node, graph, visited);
            }
        }

        // return # of components
        return components;
    }
}
