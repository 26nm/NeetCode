/**
* PROMPT:
* design a data structure that supports adding new words and searching for
* existing words
*
* CONSTRAINTS:
* 1 <= word.length <= 25
* word in addWord consists of lowercase letters
* word in search consists of '.'
* there will be at most 2 '.'s in word for search queries
* 10,000 calls at most will be made to addWord and search
*
* BLUEPRINT:
* to solve this question, we can implement and maintain a trie, with slightly
* modified approach to searching using dfs:
*
* addWord:
* 1. start at the root
* 2. iterate through input, char-by-char:
*    -convert each char to its ascii index
*    -if there is no matching node for this index, create new one
*    -point current to this node
* 3. mark the final node's isWord flag to true
*
* search:
* 1. call helper function
*
* dfs:
* 1. if we reached end of the word, return the node's isWord value
* 2. extract current char using index value
* 3. if the char is a wildcard ("."):
*    -try every child of the current node
*    -if a match is found, return true
*    -return false otherwise
* 4. get the child of current char
* 5. if no matching node exists, return false
* 6. recursively search rest of dictionary using dfs
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

        // iterate through input, char-by-char:
        for(char ch : word.toCharArray()) {
            // convert each char to its ascii index
            int index = ch - 'a';

            // if a node for this index doesn't already exist,
                // create one
            if(current.children[index] == null)
                current.children[index] = new TrieNode();

            // point current to the child node
            current = current.children[index];
        }

        // mark final node's isWord status to true
        current.isWord = true;
    }

    // function to search for word within trie
    public boolean search(String word) {
        // call dfs function
        return dfs(root, 0, word);
    }

    // helper function to perform dfs
    private boolean dfs(TrieNode node, int index, String str) {
        // if we reached end of word, return node's isWord flag
        if(index == str.length()) return node.isWord;

        // extract current char at index
        char ch = str.charAt(index);

        // if we encounter wildcard (.), try every possible child:
        if(ch == '.') {
            for(TrieNode child : node.children) {
                // if child exists, return true
                if(child != null 
                    && dfs(child, index + 1, str))
                        return true;
            }

            // no match found, return false;
            return false;
        }

        // move to child node of current char
        TrieNode child = node.children[ch - 'a'];

        // if child does not exist, return false
        if(child == null) return false;

        // recursively search rest of dict using dfs
        return dfs(child, index + 1, str);
    }
}
