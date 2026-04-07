class Solution {
    /**
    * this DSA question involves string manipulation
    *
    * we are given a string, and we need to encode/decode
    *
    * input: ["Hello", "World"]
    * output: ["Hello", "World"]
    *
    * to solve this problem, we split into two parts:
    * 1. encode
    * 2. decode
    *
    * for encode, it's pretty straight simple:
    * 1. add string length, delimiter ('#'), followed with actual string
    *    for precise parsing using StringBuilder
    *
    * for decode, we could do the following for each string:
    * 1. extract string length
    * 2. skip over delimiter ('#')
    * 3. extract string using substring
    * 4. add to result list, update pointers
    * 5. repeat
    */

    public String encode(List<String> strs) {
        StringBuilder encodeSB = new StringBuilder();

        // encode string with length and delimiter for precise parsing
        for(String str : strs) {
            encodeSB.append(str.length()).append("#").append(str);
        }

        return encodeSB.toString();
    }

    public List<String> decode(String str) {
        int index = 0;
        List<String> result = new ArrayList<>();

        // get string length, skip delimiter, extract string
        // "4#leetcode"
        while(index < str.length()) {
            int j = index;

            while(str.charAt(j) != '#') {
                j++;
            }

            int strLength = Integer.parseInt(str.substring(index, j));
            j++;
            String word = str.substring(j, j + strLength);
            result.add(word);

            index = j + strLength;
        }

        return result;
    }
}
