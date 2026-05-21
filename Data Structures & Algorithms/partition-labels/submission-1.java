/**
* we are given a string s consisting of lowercase english letters
*
* split string into as many substrings as possible, while ensuring that
* each letter appears in at most one substring
*
* return a list of integers representing size of these substrings in order
* they appear in the string
*
* to solve this question, we can implement the following algorithm:
* 1. create map to track last occurrences of each character
*    -populate this map
*
* 2. create a list to hold substring lengths
*
* 3. track start and end, start at 0
*
* 4. traverse through string:
*    -get current char 
*    -extend partition boundary on the right
*    -if i has reached the end:
*     -add substring length to result list
*     -adjust start to end + 1
*
* 5. return resulting list
*
*/
class Solution {
    public List<Integer> partitionLabels(String s) {
        // create map to track last occurrences of each character
        Map<Character, Integer> lastIndex = new HashMap<>();

        // get last occurrences of each character
        for(int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        // create list to hold result
        List<Integer> result = new ArrayList<>();

        // track start and end, start at 0
        int start = 0;
        int end = 0;

        // traverse through string
        for(int i = 0; i < s.length(); i++) {
            // get current char
            char c = s.charAt(i);

            // extend partition boundary from the right
            end = Math.max(end, lastIndex.get(c));

            // if i meets end -> partition complete
            if(i == end) {
                // add length to result list
                result.add(end - start + 1);

                // adjust starting point
                start = end + 1;
            }
        }

        // return resulting list
        return result;
    }
}
