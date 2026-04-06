class Solution {
    /**
    * another famous DSA question
    *
    * we are asked to group strings in a string array in groups of anagrams
    *
    * as discovered in previous iterations, the most efficient approach is as follows
    * 
    * for each String:
    * 1. count char frequencies (store in an int array)
    * 2. create a string identifier using this array
    * 3. sort each string by key
    *
    * we might initialize a HashMap<String, List<String>> result to store results
    *
    * then return an array list of the HashMap's values
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        // count character frequencies
        for(String word : strs) {
            int[] freqs = new int[26];

            for(char ch : word.toCharArray()) {
                freqs[ch - 'a']++;
            }

            // create a unique key
            StringBuilder keyBuilder = new StringBuilder();
            
            for(int count : freqs) {
                keyBuilder.append('#').append(count);
            }

            String key = keyBuilder.toString();

            // sort each string by key
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(word);
        }

        return new ArrayList<>(result.values());
    }
}
