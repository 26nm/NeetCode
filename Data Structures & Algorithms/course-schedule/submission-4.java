class Solution {
    // helper function to perform dfs
    private boolean dfs(
        int course,
        List<List<Integer>> graph,
        Set<Integer> visiting) {
        // if we already visited course -> return false
        if(visiting.contains(course)) return false;

        // if we successfully cleared pre-reqs -> return true
        if(graph.get(course).isEmpty()) return true;

        // mark course visited
        visiting.add(course);

        // iterate through courses and preqs
        for(int prereq : graph.get(course)) {
            // if dfs unsuccessful -> return false
            if(!dfs(prereq, graph, visiting)) return false;
        }

        // remove course from visiting
        visiting.remove(course);

        // clear pre-req from graph
        graph.get(course).clear();

        // course successfully cleared
        return true;

    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adjacency list to hold courses
        List<List<Integer>> graph = new ArrayList<>();

        // iterate through # of courses
        for(int i = 0; i < numCourses; i++) {
            // make a list for each slot in graph
            graph.add(new ArrayList<>());
        }

        // iterate through all courses and prereqs
        for(int[] prereq : prerequisites) {
            // get current course and add prereq to graph
            graph.get(prereq[0]).add(prereq[1]);
        }

        // create set to track visited courses
        Set<Integer> visiting = new HashSet<>();

        // iterate through # of courses
        for(int course = 0; course < numCourses; course++) {
            // if dfs unsuccessful -> return false
            if(!dfs(course, graph, visiting)) return false;
        }

        // all courses cleared
        return true;
    }
}
