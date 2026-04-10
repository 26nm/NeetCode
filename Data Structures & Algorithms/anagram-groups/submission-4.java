class Solution {
    /**
    * we are given a String array
    *
    * return a List of String List in which strings are grouped
    * in anagrams
    *
    * best to use a frequency array to group strings together
    *
    * we could:
    * 1. declare new HashMap<String, List<String>>
    *
    * 2. for each string:
    *    -declare an int array of 26 (to track frequencies)
    *    -count the frequency of each character
    *    -convert this frequency array into a string:
    *      -append "#" followed with value
    *    -place each string accordingly with putIfAbsent(key, new ArrayList<>())
    *    -add each String 
    *
    * 3. return values list
    */
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> result = new HashMap<>();

        // calculate char frequencies for each word
        for(String str : strs) {
            int[] freqs = new int[26];

            for(char ch : str.toCharArray()) {
                freqs[ch - 'a']++;
            }

            StringBuilder keyBuilder = new StringBuilder();

            // generate key using freq array
            for(int num : freqs) {
                keyBuilder.append("#").append(num);
            }

            String key = keyBuilder.toString();
            result.putIfAbsent(key, new ArrayList<>());
            result.get(key).add(str);
        }

        return new ArrayList(result.values());
    }
}
