class Solution {
    public boolean isAnagram(String s, String t) {
        // IMPLEMENTATION
        if(s.length() != t.length()) return false;

        int[] counts = new int[26];

        for(int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }

        for(int count : counts) {
            if(count != 0) return false;
        }

        return true;

    }
}

// COMMENT
// STRUCTURE
// IMPLEMENTATION

// COMMENT
// we're asked to indicate whether two strings contain the same characters
    // characters must be the exact same but can be in any order
    // we can use frequency counting since the order doesn't need to match

// STRUCTURE
// we first check if strings have the same length
    // if strings differ in length, return false immediately

// then, we create an integer array to store character frequencies
    // since there are 26 letters in the alphabet, make array size 26

// iterating i from 0 to end of string s:
    // increment frequency of current letters
    // also decrement frequency of current letters to 'balance out'

// iterating through frequency array:
    // if any frequency > 0, return false
    // this indicates a different number of characters, meaning they AREN'T anagrams

// return true
