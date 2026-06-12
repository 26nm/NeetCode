class Solution {
    // helper function to find union of both sets
    private boolean union(
        int node1,
        int node2,
        int[] parent,
        int[] rank) {
        // find root of both nodes
        int root1 = find(node1, parent);
        int root2 = find(node2, parent);

        // if roots are same -> stop
        if(root1 == root2) return false;

        // if root1 in rank > root2 in rank -> set parent of root2 to root1
        if(rank[root1] > rank[root2])
            parent[root2] = root1;

        // else, if root2 in rank > root1 in rank -> set parent of root1 to root2
        else if(rank[root2] > rank[root1])
            parent[root1] = root2;

        // else, set parent of root2 to root1 and increment root1's rank
        else
            parent[root2] = root1;
            rank[root1]++;

        // root found
        return true;
    }

    // helper function to make a node its own parent
    private int find(int node, int[] parent) {
        // make every node its own parent
        if(parent[node] != node) {
            parent[node] = find(parent[node], parent);
        }

        // return parent node
        return parent[node];
    }

    // main function
    public int[] findRedundantConnection(int[][] edges) {
        // get # of edges
        int n = edges.length;

        // create parent and rank arrays of size n + 1
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        // iterate through each edge
        for(int i = 1; i <= n; i++) {
            // set i in parent to current index
            parent[i] = i;

            // assign current index a rank of 1
            rank[i] = 1;
        }

        // iterate through all edges
        for(int[] edge : edges) {
            // if union find unsuccessful -> edge found
            if(!union(edge[0], edge[1], parent, rank))
                return edge;
        }

        // return empty array
        return new int[0];
    }
}
