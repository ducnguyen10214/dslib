package dslib.Tree;

import java.util.HashMap;

public class Trie {
    public class TrieNode {
        HashMap<Character, TrieNode> children = new HashMap<>();
        String word;
        public TrieNode() {}
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i += 1) {
            if (curr.children.containsKey(word.charAt(i))) {
                curr = curr.children.get(word.charAt(i));
            } else {
                TrieNode newNode = new TrieNode();
                curr.children.put(word.charAt(i), newNode);
                curr = newNode;
            }
        }
        curr.word = word;
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for (int i = 0; i < word.length(); i += 1) {
            if (curr == null || !curr.children.containsKey(word.charAt(i))) {
                return false;
            }
            curr = curr.children.get(word.charAt(i));
        }
        return curr.word != null;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for (int i = 0; i < prefix.length(); i += 1) {
            if (curr == null || !curr.children.containsKey(prefix.charAt(i))) {
                return false;
            }
            curr = curr.children.get(prefix.charAt(i));
        }
        return true;
    }
}
