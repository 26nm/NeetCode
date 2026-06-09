/**
* we are given an array prerequisites where prerequisites[i] = [a,b] indicates
* needing to take course b before taking course a
* -e.g., [0,1] means needing to take course 1 before course 0
* -total of numCourses required, labeled from 0 to numCourses - 1
*
* return valid ordering of courses you can take to finish all courses
* -if impossible, return empty array
*
* to solve this question, we can consider following algos:
* 
* helper:
* 1. if we visit the same course again -> return false
*    -if we encounter already visited course -> return true
*
* 2. mark current course as visiting
*
* 3. iterate through all prereqs for a course:
*    -if dfs fails -> return false
*
* 4. remove course from visiting
*    -add course to visited
*    -add to result as well
*
* 5. return true
*
* main function:
* 1. create adjacency list to hold course data
*    -create numCourses lists inside graph
*
* 2. create hash sets to track nodes currently being visited,
*    nodes already visited
*
* 3. add prereqs for each course into the graph
*    
* 4. iterate through each course in graph:
*    -if dfs fails -> return empty array
*
* 5. create array of size numCourses to hold final answers
*
* 6. transfer contents
*
* 7. return final array
*/
class Solution {
    // helper function to perform dfs
    private boolean dfs(
        int course,
        List<List<Integer>> graph,
        Set<Integer> visiting,
        Set<Integer> visited,
        List<Integer> result) {
        // if we encounter same course again -> return false
        if(visiting.contains(course)) return false;

        // if we encounter course in visited -> return true
        if(visited.contains(course)) return true;

        // mark current course as visiting
        visiting.add(course);

        // iterate through course prereqs
        for(int prereq : graph.get(course)) {
            // if dfs fails -> return false
            if(!dfs(prereq, graph, visiting, visited, result))
                return false;
        }

        // remove course from visiting
        visiting.remove(course);

        // add course to visited
        visited.add(course);

        // add course to result
        result.add(course);

        // all prereqs processed
        return true;
    }

    // main function
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // create list to hold course data
        List<List<Integer>> graph = new ArrayList<>();

        // create lists for each slot in graph
        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // add prereqs for each course into graph
        for(int[] prereq : prerequisites) {
            graph.get(prereq[0]).add(prereq[1]);
        }

        // create sets to track courses visiting and visited
        Set<Integer> visiting = new HashSet<>();
        Set<Integer> visited = new HashSet<>();

        // create list to hold ordering
        List<Integer> result = new ArrayList<>();

        // iterate through all courses
        for(int course = 0; course < numCourses; course++) {
            // if dfs fails -> return empty array
            if(!dfs(course, graph, visiting, visited, result))
                return new int[0];
        }

        // create array of numCourses to hold final ordering
        int[] answer = new int[numCourses];

        // transfer contents
        for(int i = 0; i < numCourses; i++) {
            answer[i] = result.get(i);
        }

        // return final ordering
        return answer;
    }
}
