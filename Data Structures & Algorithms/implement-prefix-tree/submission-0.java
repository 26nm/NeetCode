class PrefixTree {
    // inner node class
    private static class TrieNode {
        // store array of children
        TrieNode[] children = new TrieNode[26];

        // use a boolean to mark words
        boolean isWord;
    }

    // define root of trie
    private final TrieNode root;

    // class constructor
    public PrefixTree() {
         root = new TrieNode();
    }

    // function to insert a string into trie
    public void insert(String word) {
        // set current node to the root
        TrieNode current = root;

        // iterate through input string
        for(char c : word.toCharArray()) {
            // convert current char to its ascii index
            int index = c - 'a';

            // if child does not exist, make new node
            if(current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            // move to the child
            current = current.children[index];
        }

        // mark final node as word
        current.isWord = true;
    }

    // function to search for a word in trie
    public boolean search(String word) {
        // call helper function to find node containing word
        TrieNode node = findNode(word);

        // return whether the node contains a word and
            // if it is a word
        return node != null && node.isWord;
    }

    // function to determine if string starts with certain prefix
    public boolean startsWith(String prefix) {
        return findNode(prefix) != null;
    }

    // helper function to search for input string in trie
    private TrieNode findNode(String s) {
        // start at the root
        TrieNode current = root;

        // iterate through the input
        for(char c : s.toCharArray()) {
            // convert char to its ascii index
            int index = c - 'a';

            // if child does not exist, return null
            if(current.children[index] == null)
                return null;

            // move to child node
            current = current.children[index];
        }

        // return current node
        return current;
    }
}
