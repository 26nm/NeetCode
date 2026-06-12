/**
* we are given a connected undirected graph with n nodes labeled from 1 to n
* -initially, no cycles and n-1 edges in graph
* -however, 1 additional edge has been added to graph
* -edge has 2 different vertices chosen from 1 to n
* -graph represented as an array edges length n where edges[i] = [ai, bi]
*  indicates an edge between ai and bi
*
* return an edge that can be removed from graph so it's still a connected
* non-cyclical graph
* -if multiple answers, return edge that appears last
*
* to solve this question, we can consider following algo:
*
* union find:
* 1. get root of both nodes
*
* 2. if roots are the same -> stop (return false)
*    -else if root1 in rank bigger than root2 in rank -> set parent of root2 to root1
*    -else if root2 in rank bigger than root1 in rank -> set parent of root1 to root2
*    -else set parent of root2 to root1 and increment root1's rank
*
* 3. return true
*
* making a node its own parent:
* 1. if a node's parent isn't itself -> recurse
*
* 2. return parent node
*
* main function:
* 1. get # of edges
*
* 2. iterate through each edge:
*    -set parent of each index to current index
*    -assign current index a rank of 1
*
* 3. iterate through all edges:
*    -if union find unsuccessful -> return current edge
*
* 4. otherwise return empty array
*/
class Solution {
    // helper function to union find both sets
    private boolean union(
        int node1,
        int node2,
        int[] parent,
        int[] rank) {
        // get roots of both node and parents
        int root1 = find(node1, parent);
        int root2 = find(node2, parent);

        // if roots same -> stop (return false)
        if(root1 == root2) return false;

        // else if root1 in rank bigger than root2 in rank -> set parent of root2 to root1
        else if(rank[root1] > rank[root2])
            parent[root2] = root1;

        // else if root2 in rank bigger than root1 in rank -> set parent of root1 to root2
        else if(rank[root2] > rank[root1])
            parent[root1] = root2;

        // else set parent of root2 to root1 and increment root1's rank
        else
            parent[root2] = root1;
            rank[root1]++;

        // return true
        return true;
    }

    // helper function to make a node its own parent
    private int find(int node, int[] parent) {
        // if a node isn't its own parent -> make it its own parent
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

        // create parent and rank arrays of size n+1
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];

        // iterate through all edges
        for(int i = 1; i <= n; i++) {
            // set parent of index to itself
            parent[i] = i;

            // assign each index rank of 1
            rank[i] = 1;
        }

        // iterate through edges
        for(int[] edge : edges) {
            // if union find unsuccessful -> return edge
            if(!union(edge[0], edge[1], parent, rank))
                return edge;
        }

        // return empty array (no edge needs to be removed)
        return new int[0];
    }
}
