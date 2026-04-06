class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];

        for(int[] pair : prerequisites) {
            int course = pair[0], prereq = pair[1];
            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        for(int i = 0; i < numCourses; i++) {
            if(inDegree[i] == 0) queue.offer(i);
        }

        int count = 0;

        while(!queue.isEmpty()) {
            int curr = queue.poll();
            count++;

            for(int next : graph.get(curr)) {
                inDegree[next]--;
                if(inDegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return count == numCourses;
    }
}
