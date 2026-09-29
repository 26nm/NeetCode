/**
* PROMPT:
* design a data structure to supporting adding new words and searching for
* existing words
*
* CONSTRAINTS:
* 1 <= word.length <= 25
* word in addWord is in all lowercase
* word in search consists of "." or lowercase
* there is at most 2 '.' in word for search queries
* 10,000 calls made at most
*
* BLUEPRINT:
* to solve this question, we can implement and maintain a trie, with a modified
* search function using DFS
*
* addWord:
* 1. start from root
* 2. iterate through input char-by-char:
*    -convert each char to its ascii index
*    -if no child node for each char exists, create new one
* 3. point current to the child
* 4. mark final node's isWord flag as true
*
* search:
* 1. call helper function
*
* dfs:
* 1. if we reached end of word, return the node's isWord status
* 2. if we encounter '.', try dfs for every child node:
*    -return true if a match has been found
*    -return false otherwise
* 3. move to the current child's index
* 4. if no match is found, return false
* 5. recursively search using dfs
*/
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

    // function to add word to trie
    public void addWord(String word) {
        // start at the root
        TrieNode current = root;

        // iterate through input char-by-char
        for(int ch : word.toCharArray()) {
            // convert current char to its ascii index
            int index = ch - 'a';

            // if child does not exist, make new node
            if(current.children[index] == null) 
                current.children[index] = new TrieNode();

            // point current to the child node
            current = current.children[index];
        }

        // mark final node's isWord as true
        current.isWord = true;
    }

    // function to search for word in trie
    public boolean search(String word) {
        // call helper function
        return dfs(root, 0, word);
    }

    // helper function to search for word in trie
    private boolean dfs(TrieNode node, int index, String str) {
        // if we reached end of word, 
            // return isWord of current node
        if(index == str.length()) return node.isWord;

        // get current char
        char ch = str.charAt(index);

        // if we encounter '.', try every child
        if(ch == '.') {
            for(TrieNode child : node.children) {
                // if a match is found, return true
                if(child != null && 
                    dfs(child, index + 1, str))
                    return true;
            }

            // return false if no match
            return false;
        }

        // move to the current node's child
        TrieNode child = node.children[ch - 'a'];

        // if child does not exist, return false
        if(child == null) return false;

        // recursively search dict using DFS
        return dfs(child, index + 1, str);
    }
}
