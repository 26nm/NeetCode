class Solution {
    // helper function to perform dfs
    private void dfs(
        int node,
        Map<Integer, List<Integer>> graph,
        Set<Integer> visited) {
        // if we visit same node again -> stop
        if(visited.contains(node)) return;

        // mark visited
        visited.add(node);

        // iterate through neighbors
        for(int neighbor : graph.get(node)) {
            // dfs on all neighbors
            dfs(neighbor, graph, visited);
        }

    }

    // main function
    public int countComponents(int n, int[][] edges) {
        // create map to represent graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // create lists for each slot in graph
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // put edges in graph
        for(int[] edge : edges) {
            // get current edge pair
            int u = edge[0];
            int v = edge[1];

            // connect edge pairs
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // make a set to track nodes visited
        Set<Integer> visited = new HashSet<>();

        // track # of connected components
        int components = 0;

        // iterate through all nodes in graph
        for(int node = 0; node < n; node++) {
            // if node unexplored -> increment component count and perform dfs
            if(!visited.contains(node)) {
                components++;
                dfs(node, graph, visited);
            }
        }

        // return # of components counted
        return components;
    }
}
