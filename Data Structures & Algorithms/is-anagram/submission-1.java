class Solution {
    /**
    * another common DSA problem where
    *
    * given two strings, you are asked to determine
    *
    * if they are anagrams of each other
    *(i.e., they have same exact characters, different order)
    *
    * the simplest (and optimal) approach is to use character
    * frequencies
    *
    * we might initialize a frequency array 26-indices long
    *
    * we can increment the frequencies for s, decrement for t
    * 
    * maybe we can convert the strings to char arrays
    *
    * if the frequency is NOT zero, then we can conclude that
    * strings are NOT anagrams, as they do not have matching characters
    *
    * NOTE: do c - 'a'
    */
    public boolean isAnagram(String s, String t) {
        int[] freqs = new int[26];

        // if strings differ in length, exit immediately
        if (s.length() != t.length()) return false;

        // count frequencies across both strings
        for(int i = 0; i < s.length(); i++) {
            freqs[s.charAt(i) - 'a']++;
            freqs[t.charAt(i) - 'a']--;
        }

        // ensure all frequencies are "zero-d out"
        for(int count : freqs) {
            if(count != 0) return false; // different number of characters
        }

        return true;
    }
}
