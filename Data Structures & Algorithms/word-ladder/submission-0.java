class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // if word not in list -> return 0
        if(!wordList.contains(endWord)) return 0;

        // create map to store word patterns (as graph)
        Map<String, List<String>> graph = new HashMap<>();

        // add begin word to word list
        wordList.add(beginWord);

        // iterate through word list
        for(String word : wordList) {
            // iterate through each word
            for(int i = 0; i < word.length(); i++) {
                // form patterns for each word
                String pattern = word.substring(0, i)
                    + "*" + word.substring(i + 1);

                // put word in graph
                graph.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // create queue to process each word
        Queue<String> queue = new ArrayDeque<>();

        // create set to track words already visited
        Set<String> visited = new HashSet<>();

        // add begin word to queue and set
        queue.offer(beginWord);
        visited.add(beginWord);

        // track # of steps, start at 1
        int steps = 1;

        // process each element in queue
        while(!queue.isEmpty()) {
            // get current level
            int size = queue.size();

            // iterate current level # of times
            for(int i = 0; i < size; i++) {
                // get current word
                String word = queue.poll();

                // if word matches end word -> return # of steps
                if(word.equals(endWord)) return steps;

                // iterate through current word
                for(int j = 0; j < word.length(); j++) {
                    // generate patterns for current word
                    String pattern = word.substring(0, j)
                        + "*" + word.substring(j + 1);

                    // iterate through word's neighbors
                    for(String neighbor : graph.getOrDefault(pattern, 
                        new ArrayList<>())) {
                        // if neighbor word not visited -> mark visited and add to queue
                        if(!visited.contains(neighbor)) {
                            visited.add(neighbor);
                            queue.offer(neighbor);
                        }
                    }
                }
            }

            // increment # of steps needed
            steps++;
        }

        // return 0 if no sequence exists
        return 0;
    }
}
