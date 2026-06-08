/**
* you are given an array prerequisites where prerequisites[i] = [a,b] indicates
* that you must take course b first to take course a
* -[0,1] indicates you must take course 1 before course 0
* -total of numCourses required, labeled from 0 to numCourses - 1
*
* return true if possible to finish all courses, return false otherwise
*
* to solve this question, we can consider following algo:
* helper:
* 1. if we encounter previously visited course -> return false
*    -if prereq list for course is empty -> return true
*
* 2. mark course as visited
*
* 3. iterate through course list
*    -if dfs unsuccessful -> return false
*
* 4. remove course from graph and set
*
* 5. return true
*
* main function
* 1. create adjacency list to store course info
*    -create (numCourses - 1) lists inside graph
*
* 2. create set to track visiting courses
*
* 3. iterate through prereqs:
*    -get current course, add prereq to graph
*
* 4. iterate through graph:
*    -if dfs unsuccessful -> return false
*
* 5. return true
*/
class Solution {
    // helper function to perform dfs
    private boolean dfs(
        int course,
        List<List<Integer>> graph,
        Set<Integer> visiting ) {
        // if we encounter already visited course -> return false
        if(visiting.contains(course)) return false;

        // if prereqs list for course empty -> return true
        if(graph.get(course).isEmpty()) return true;

        // mark course visited
        visiting.add(course);

        // iterate through course list
        for(int prereq : graph.get(course)) {
            // if dfs unsuccessful -> return false
            if(!dfs(prereq, graph, visiting)) return false;
        }

        // clear course from graph and visiting
        visiting.remove(course);
        graph.get(course).clear();

        // course successfully cleared
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create adjacency list to hold courses
        List<List<Integer>> graph = new ArrayList<>();

        // create numCourses - 1 lists inside graph
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // create set to track courses visited
        Set<Integer> visiting = new HashSet<>();

        // add prereqs to courses inside graph
        for(int[] prereqs : prerequisites) {
            graph.get(prereqs[0]).add(prereqs[1]);
        }

        // iterate through courses
        for(int course = 0; course < numCourses; course++) {
            // if dfs unsuccessful -> return false
            if(!dfs(course, graph, visiting)) return false;
        }

        // all courses cleared
        return true;
    }
}
