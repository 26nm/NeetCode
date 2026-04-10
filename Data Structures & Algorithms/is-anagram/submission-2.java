class Solution {
    /**
    * we are given two strings
    *
    * we are asked to determine if they are anagrams of each other
    * 
    * two strings are said to be anagrams of each other if and only if:
    * -they have exact same characters and character counts
    * -characters do not have to be same order
    *
    * to solve, we could:
    * 1. check if strings differ in length (to save resources)
    *    -if strings differ in length, return false
    *
    * 2. declare integer array of 26 to count frequencies
    *
    * 3. iterate through first string:
    *    -count frequency of each character (c - 'a')++;
    *
    * 4. iterate through second string:
    *    -ensure frequency of each character matches (c - 'a')--;
    * 
    * 5. iterate through frequency array:
    *    -if any number is NOT 0, they are not anagrams (return false)
    *    -return true;
    */
    public boolean isAnagram(String s, String t) {
        // strings have diff length
        if(s.length() != t.length()) return false;

        int[] freqs = new int[26];

        // count freqs in first string
        for(char ch : s.toCharArray()) {
            freqs[ch - 'a']++;
        }

        // subtract freqs in second string
        for(char ch : t.toCharArray()) {
            freqs[ch - 'a']--;
        }

        // ensure freqs are back to 0
        for(int count : freqs) {
            if(count != 0) return false;
        }

        return true;
    }
}
