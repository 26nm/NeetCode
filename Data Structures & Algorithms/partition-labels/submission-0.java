class Solution {
    public List<Integer> partitionLabels(String s) {
        // create map to store last occurrence of characters
        Map<Character, Integer> lastIndex = new HashMap<>();

        // store last occurrence of each character
        for(int i = 0; i < s.length(); i++) {
            lastIndex.put(s.charAt(i), i);
        }

        // create list to hold result
        List<Integer> result = new ArrayList<>();

        // track end and start, start at 0
        int start = 0;
        int end = 0;

        // traverse through string
        for(int i = 0; i < s.length(); i++) {
            // get current char
            char c = s.charAt(i);

            // extend partition boundary on the right
            end = Math.max(end, lastIndex.get(c));

            // if i reaches end -> partition complete
            if(i == end) {
                // add distance traveled to result
                result.add(end - start + 1);

                // adjust start
                start = i + 1;
            }
        }

        // return resulting list
        return result;
    }
}
