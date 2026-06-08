/**
* we are given an array prerequisites where prerequisites[i] = [a,b] indicates
* that you must take course b first to take course a
* -e.g., [0,1] means take course 1 first to take course 0
* -there are total of numCourses required, labeled from 0 to numCourses - 1
*
* return true if possible to finish all courses, false otherwise
*
* to solve this question, we might consider following algo:
*
* helper:
* 1. if visiting set contains course already processed -> return false
*    -if pre req list for given course empty -> return true
*
* 2. iterate through each course
*    -if dfs unsuccessful -> return false
*
* 3. mark course visited
*
* 4. remove course from visiting and graph
*
* 5. return true
*
* main function:
* 1. create list to hold graph for courses
*
* 2. iterate numCourses times:
*    -add list to each slot in graph
*
* 3. create set to track courses visited
*
* 4. iterate through courses and pre-reqs
*    -get current course and add pre-req to graph
*
* 5. iterate through all courses again:
*    -if dfs unsuccessful -> return false
*
* 6. return true
*/
class Solution {
    // helper function to perform dfs
    private boolean dfs(
        int course,
        List<List<Integer>> graph,
        Set<Integer> visiting) {
        // if we encounter course already visited -> return false
        if(visiting.contains(course)) return false;

        // if pre-reqs list empty -> return true
        if(graph.get(course).isEmpty()) return true;

        // mark course visited
        visiting.add(course);

        // iterate through each course and prereq
        for(int prereq : graph.get(course)) {
            // if dfs unsuccessful -> return false
            if(!dfs(prereq, graph, visiting)) return false;
        }

        // remove course from visiting
        visiting.remove(course);

        // clear course from graph
        graph.get(course).clear();

        // course successfully cleared
        return true;
    }

    // main function
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // create list to hold graph of courses
        List<List<Integer>> graph = new ArrayList<>();

        // iterate numCourses times
        for(int i = 0; i < numCourses; i++) {
            // create list for each slot in graph
            graph.add(new ArrayList<>());
        }

        // create set to track visited courses
        Set<Integer> visiting = new HashSet<>();

        // iterate through all courses and prereqs
        for(int[] prereq : prerequisites) {
            // get current course and add prereq to graph
            graph.get(prereq[0]).add(prereq[1]);
        }

        // iterate through courses again
        for(int course = 0; course < numCourses; course++) {
            // if dfs unsuccessful -> return false
            if(!dfs(course, graph, visiting)) return false;
        }

        // all courses successfully cleared
        return true;
    }
}
