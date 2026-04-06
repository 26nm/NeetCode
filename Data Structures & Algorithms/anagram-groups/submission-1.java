/**
* problem: group anagrams together 
*
* input: an array containing strings
*
* output: strings grouped together based
* on same (exact) characters, different order
*
* example: 
* input: ["act", "pots", "tops", "cat", "stop", "hat"]
* output: [["hat"], ["act", "cat"], ["stop", "pots", "tops"]]
*
* we could use a HashMap to store words under a common key
*
* the key is the "normalized" word, the value is the string
*
* we could iterate the list, check if each key already exists
*
* but how do we account for an empty String array?
*
* we check if array is empty:
* -if yes, return an empty ArrayList
*
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();

        // iterate through String array
        for(String s: strs) {
            int[] count = new int[26];
        
            // Count characters
            for(char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build key (e.g., "#1#0#0#2...")
            StringBuilder keyBuilder = new StringBuilder();

            for(int num : count) {
                keyBuilder.append('#').append(num);
            }

            String key = keyBuilder.toString();

            // Add to map
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(s);
        }

        return new ArrayList<>(result.values());
    }
}
