/**
* PROMPT:
* design a data structure to support adding new words and searching for
* existing words
*
* CONSTRAINTS:
* 1 <= word.length <= 25
* word in addWord is lowercase
* word in search consists of '.' or lowercase
* 2 '.'s at most in word for search queries
* at most 10,000 calls to addWord and search
*
* BLUEPRINT:
* to solve this question, we can implement and maintain a trie, with a 
* modified search algorithm using dfs
*
* addWord:
* 1. start at the root
* 2. iterate through input, char-by-char:
*    -convert each char to its ascii index
*    -if a node does not already exist for this index, create one
* 3. point current to this node at the ascii index
* 4. set final node's isWord flag to true
*
* search:
* 1. call dfs function, starting from root, index 0, and word
*
* dfs:
* 1. if we reached end of word, return final node's isWord flag
* 2. get char at current index
* 3. if current char is '.':
*    -try every possible child
*    -if node exists, return true
*    -otherwise, return false
* 4. move to child of current char
* 5. if no matches found, return false
* 6. search rest of dict using dfs
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

        // iterate through input char-by-char:
        for(char ch : word.toCharArray()) {
            // convert each char to its ascii index
            int index = ch - 'a';

            // if node for this index does not exist, create new one
            if(current.children[index] == null)
                current.children[index] = new TrieNode();

            // point current to child
            current = current.children[index];
        }

        // set final node's flag to true
        current.isWord = true;
    }

    // function to search for word in trie
    public boolean search(String word) {
        // search for word using dfs
        return dfs(root, 0, word);
    }

    // function to search for word in trie using dfs
    private boolean dfs(TrieNode node, int index, String str) {
        // if we reached end of word, return isWord flag
        if(index == str.length()) return node.isWord;

        // get char at current index
        char ch = str.charAt(index);

        // if current char is '.', try every child:
        if(ch == '.') {
            for(TrieNode child : node.children) {
                // if child exists, return true
                if(child != null 
                    && dfs(child, index + 1, str))
                        return true;
            }

            // no match found, return false
            return false;
        }

        // move to current char's child
        TrieNode child = node.children[ch - 'a'];

        // if child does not exist, return false
        if(child == null) return false;

        // search rest of dict using dfs
        return dfs(child, index + 1, str);
    }
}
