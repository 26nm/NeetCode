/**
* a prefix tree (also known as a trie) is a tree data structure used to efficiently
* store and retrieve keys in a set of strings
*
* some applications of this data structure include auto-complete and spell checker
* systems
*
* implement the PrefixTree class:
*/
class PrefixTree {
    // inner node class
    private static class TrieNode {
        // store an array of children with 26 slots
        private TrieNode[] children = new TrieNode[26];

        // store a boolean flag to mark words
        boolean isWord;
    }

    // define the root
    private final TrieNode root;

    // class constructor
    public PrefixTree() {
        root = new TrieNode();
    }

    // function to insert a string into the trie
    public void insert(String word) {
        // start at the root
        TrieNode current = root;

        // iterate through the input char by char
        for(char c : word.toCharArray()) {
            // convert each char to its ascii index
            int index = c - 'a';

            // if a child does not exist for this node,
                // create new one
            if(current.children[index] == null)
                current.children[index] = new TrieNode();

            // move to the current child
            current = current.children[index];
        }

        // mark the final node as a word
        current.isWord = true;
    }

    // function to search for input within trie
    public boolean search(String word) {
        // call helper function to find input within trie
        TrieNode found = findWord(word);

        // return whether the node is not null 
            // and if it is a word
        return found != null && found.isWord;
    }

    // helper function to find input string within trie
    private TrieNode findWord(String word) {
        // start at the root
        TrieNode current = root;

        // iterate through input char by char
        for(int c : word.toCharArray()) {
            // convert each char to its ascii index
            int index = c - 'a';

            // if child does not exist, return null
            if(current.children[index] == null)
                return null;

            // move to the child
            current = current.children[index];
        }

        // return current node if found
        return current;
    }

    // function to determine if prefix exists within trie
    public boolean startsWith(String prefix) {
        // determine if prefix exists within trie
        return findWord(prefix) != null;
    }
}
