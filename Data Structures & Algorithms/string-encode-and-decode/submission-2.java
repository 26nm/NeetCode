class Solution {
    /**
    * here we must implement two functions:
    *
    * 1. encode
    * 2. decode
    *
    * for encode, we can simply:
    * 1. add string length and "#" in front of actual string
    * 2. return this result
    *
    * for decode, we could:
    * 1. declare new List<String> result
    *
    * 2. declare i = 0;
    *
    * 3. loop while (i < str.length()):
    *    -declare new String list
    *    -declare j for "bound-setting":
    *     set this value to i
    *    -move past the integer (stop at "#")
    *    -parse the String length, store it
    *    -declare new String as substring of
    *     current string, from j to j + length
    *    -add this String to the list
    *    -adjust i to j + length
    *
    * 4. return this string list
    */

    public String encode(List<String> strs) {
        StringBuilder encode = new StringBuilder();

        // append length and "#" for easy parsing
        for(String str : strs) {
            encode.append(str.length()).append("#").append(str);
        }

        return encode.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        int i = 0;

        // parse each string
        while(i < str.length()) {
            int j = i;

            while(str.charAt(j) != '#') {
                j++;
            }

            int strLength = Integer.parseInt(str.substring(i, j));
            j++;
            String word = str.substring(j, j + strLength);
            result.add(word);
            i = j + strLength;
        }

        return result;
    }
}
