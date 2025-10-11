package project1;


class TrieNode {
    TrieNode[] children;
    boolean isEndOfWord;

    TrieNode() {
        isEndOfWord = false;
        children = new TrieNode[26];
        // By default, elements in a Java array are initialized to null.
    }
}


public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Helper method to check if a node has any children
    private boolean isEmpty(TrieNode node) {
        for (int i = 0; i < 26; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    // Public method to initiate the deletion process
    public void delete(String word) {
        if (search(word)) {
            deleteRecursive(root, word, 0);
            System.out.println("Word '" + word + "' deleted successfully.");
        } else {
            System.out.println("Word '" + word + "' not found in the trie.");
        }
    }

    // The recursive deletion logic
    private TrieNode deleteRecursive(TrieNode currentNode, String word, int depth) {
        // Base case: We have reached the end of the word
        if (depth == word.length()) {
            // Unmark this node as the end of a word
            if (currentNode.isEndOfWord) {
                currentNode.isEndOfWord = false;
            }

            // If the node has no other children, it can be deleted
            if (isEmpty(currentNode)) {
                return null;
            }
            return currentNode;
        }

        // Recursive case: Traverse down the trie
        int index = word.charAt(depth) - 'a';
        TrieNode childNode = currentNode.children[index];

        if (childNode == null) {
            // Word does not exist in the trie
            return currentNode;
        }

        currentNode.children[index] = deleteRecursive(childNode, word, depth + 1);

        // Backtracking phase: If the child was deleted (returned null)
        // and the current node is not the end of another word and has no other children,
        // it can also be deleted
        if (currentNode.children[index] == null && !currentNode.isEndOfWord && isEmpty(currentNode)) {
            return null;
        }

        return currentNode;
    }

    // (Optional) Include insert and search methods for a complete example
    public void insert(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            int index = ch - 'a';
            if (current.children[index] == null) {
                return false;
            }
            current = current.children[index];
        }
        return current.isEndOfWord;
    }

    // Example usage
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        trie.insert("app");
        trie.insert("apply");

        System.out.println("Trie contains 'apple': " + trie.search("apple")); // true
        System.out.println("Trie contains 'app': " + trie.search("app"));   // true
        
        trie.delete("app");
        System.out.println("Trie contains 'app' after deletion: " + trie.search("app")); // false
        System.out.println("Trie still contains 'apple': " + trie.search("apple")); // true
        
        trie.delete("apply");
        trie.delete("apple");
        System.out.println("Trie contains 'apple' after deletion: " + trie.search("apple")); // false
        System.out.println("Trie contains 'app' after deletion: " + trie.search("app")); // false
    }
}

