class Solution {
    // helper function to perform dfs
    private boolean dfs(
        int course,
        List<List<Integer>> graph,
        Set<Integer> visiting,
        Set<Integer> visited,
        List<Integer> result) {
        // if we visit the same course twice -> return false
        if(visiting.contains(course)) return false;

        // if we encounter course already visited -> return true
        if(visited.contains(course)) return true;

        // mark current course as visiting
        visiting.add(course);

        // iterate through prereqs
        for(int prereq : graph.get(course)) {
            // if dfs unsuccessful -> return false
            if(!dfs(prereq, graph, visiting, visited, result))
                return false;
        }

        // remove course from visiting
        visiting.remove(course);

        // add course to visited
        visited.add(course);

        // add course to result
        result.add(course);

        // prereqs successfully cleared
        return true;

    }

    // main function
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create graph to hold courses
        List<List<Integer>> graph = new ArrayList<>();

        // create lists for each slot in graph
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // add prereqs for each course
        for(int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }

        // create set to track nodes currently being visited
        Set<Integer> visiting = new HashSet<>();

        // create set to track nodes already visited
        Set<Integer> visited = new HashSet<>();

        // create list to hold result
        List<Integer> result = new ArrayList<>();

        // perform dfs for each course
        for(int course = 0; course < numCourses; course++) {
            // if dfs unsuccessful -> return empty array
            if(!dfs(course, graph, visiting, visited, result))
                return new int[0];
        }

        // create array of size numCourses to hold final ordering
        int[] answer = new int[numCourses];

        // transfer content from list to array
        for(int i = 0; i < numCourses; i++) {
            answer[i] = result.get(i);
        }

        // return final ordering
        return answer;
    }
}
