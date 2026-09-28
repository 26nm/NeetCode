class WordDictionary {
    // inner node class
    private static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    // define the root
    private final TrieNode root;

    // class constructor
    public WordDictionary() {
        root = new TrieNode();
    }

    // function to add word into word dict
    public void addWord(String word) {
        // start at the root
        TrieNode current = root;

        // iterate through input, char-by-char
        for(char c : word.toCharArray()) {
            // convert each char to its ascii index
            int index = c - 'a';

            // if child does not already exist, make new node
            if(current.children[index] == null)
                current.children[index] = new TrieNode();

            // point to current child
            current = current.children[index];
        }

        // mark final node as a word
        current.isWord = true;
    }

    // function to search for word in dict
    public boolean search(String word) {
        // call helper function to search for input
        return dfs(word, 0, root);
    }

    // function to search for word in dict using dfs
    private boolean dfs(String word, int index, TrieNode node) {
        // if entire search has been processed,
            // return current node's isWord
        if(index == word.length()) return node.isWord;

        // get current char
        char c = word.charAt(index);

        // if '.' is encountered, try every existing child
        if(c == '.') {
            for(TrieNode child : node.children) {
                // if child is not null and match is found,
                    // return true
                if(child != null && dfs(word, index + 1, child))
                    return true;
            }

            // if no match found, return false
            return false;
        }

        // point to current node's child
        TrieNode child = node.children[c - 'a'];

        // if child does not exist, return false
        if(child == null) return false;

        // recursively search dictionary with dfs
        return dfs(word, index + 1, child);
    }
}
