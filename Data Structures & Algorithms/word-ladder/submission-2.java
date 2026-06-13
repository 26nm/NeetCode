/**
* you are given two words, beginWord and endWord, and list of words wordList
* -all given words same length, in lowercase, and distinct
*
* transform beginWord into endWord by following rules:
* 1. you may transform beginWord to any word within wordList, provided that
*    at exactly one position, words have different character, and rest of
*    of positions have same characters
* 2. you may repeat previous step with the new word you can obtain, and you
*    may do this as many time as needed
*
* return min number of words within transformation sequence needed to obtain
* endWord, or 0 if no such sequence exists
*
* to solve this question, we can consider following algo:
* 1. if end word not in word list -> return 0
*
* 2. add begin word to end list 
*
* 3. create map to store word patterns
*    -this represents graph
*
* 4. iterate through word list:
*    -iterate through each word:
*     -create wildcard patterns for each word
*     -put these in graph
*
* 5. create set to track visited words and queue to process words
*    -add begin word to both set and queue
*
* 6. track # of steps needed, start at 1
* 
* 7. process each element in queue:
*    -get current "level"
*    -iterate level amount of times:
*     -extract current word
*     -if this word matches end word -> return # of steps
*     -iterate through word:
*      -create all wildcard patterns
*      -iterate through word's neighbors:
*       -if neighbor not visited -> mark visited and add queue
*
* 8. increment # of steps
*
* 9. return 0 (no sequence exists)
*/
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // if end word not in dict -> return 0
        if(!wordList.contains(endWord)) return 0;

        // add begin word to dict
        wordList.add(beginWord);

        // create map for word patterns, as graph
        Map<String, List<String>> graph = new HashMap<>();

        // iterate through word list
        for(String word : wordList) {
            // iterate through each word
            for(int i = 0; i < word.length(); i++) {
                // create patterns for each word
                String pattern = word.substring(0, i)
                    + "*" + word.substring(i + 1);

                // add pattern to graph
                graph.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
            }
        }

        // create set to track visited words and queue to process words
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

        // add begin word to both queue and visited
        queue.offer(beginWord);
        visited.add(beginWord);

        // track # of steps needed, start at 1
        int steps = 1;

        // process elements in queue
        while(!queue.isEmpty()) {
            // get current level
            int size = queue.size();

            // iterate at current level
            for(int i = 0; i < size; i++) {
                // get current word
                String word = queue.poll();

                // if word matches endWord -> return # of steps
                if(word.equals(endWord)) return steps;

                // iterate through word
                for(int j = 0; j < word.length(); j++) {
                    // create pattern
                    String pattern = word.substring(0, j)
                        + "*" + word.substring(j + 1);

                    // iterate through neighbors
                    for(String neighbor : graph.getOrDefault(pattern, new ArrayList<>())) {
                        // if neighbor not visited -> mark visited and add to queue 
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

        // no sequence exists -> return 0
        return 0;
    }
}
