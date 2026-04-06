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
* using the frequency array approach, for each word:
* -initialize a 26-length array
* -count frequency of each letter (do c - 'a')
*
*/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        for(String word: strs) {
            // init frequency array
            int[] count = new int[26];

            // count frequency of each letter
            for(char letter : word.toCharArray()) {
                count[letter - 'a']++;
            }

            // create a unique key for each frequency array
            StringBuilder keyBuilder = new StringBuilder();

            // append number followed with '#'
            for(int freq: count) {
                keyBuilder.append('#').append(freq);
            }

            String key = keyBuilder.toString();

            // Add to map
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(word);
        }

        return new ArrayList<>(result.values());
    }
}
