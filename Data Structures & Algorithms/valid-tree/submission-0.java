class Solution {
    // helper function to perform dfs
    private boolean dfs(
        int node,
        int parent,
        Map<Integer, List<Integer>> graph,
        Set<Integer> visited) {
        // if we visit same node again -> return false
        if(visited.contains(node)) return false;

        // mark node visited
        visited.add(node);

        // visit neighbors
        for(int neighbor : graph.get(node)) {
            // if node is a parent -> skip
            if(neighbor == parent) continue;

            // if dfs fails -> return false
            if(!dfs(neighbor, node, graph, visited))
                return false;
        }

        // all nodes successfully traversed
        return true;

    }

    // main function
    public boolean validTree(int n, int[][] edges) {
        // create HashMap to represent graph
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // create lists for each slot in graph
        for(int i = 0; i < n; i++) {
            graph.put(i, new ArrayList<>());
        }

        // connect nodes in graph
        for(int[] edge : edges) {
            // get current node pair
            int u = edge[0];
            int v = edge[1];

            // connect nodes in graph
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // make a set to track already visited nodes
        Set<Integer> visited = new HashSet<>();

        // if dfs fails -> return false
        if(!dfs(0, -1, graph, visited)) return false;

        // all nodes are reachable
        return visited.size() == n;
    }
}
