package MapSumPairs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 677. Map Sum Pairs
 *
 * Implement a MapSum class with insert, and sum methods.
 *
 * For the method insert, you'll be given a pair of (string, integer).
 * The string represents the key and the integer represents the value.
 *
 * If the key already existed, then the original key-value pair will be overridden to the new one.
 *
 * For the method sum, you'll be given a string representing the prefix,
 * and you need to return the sum of all the pairs' value whose key starts with the prefix.
 */
public class MapSumPairs {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private final Map<String, Integer> map;
    private final TrieNode trie;

    /** Initialize your data structure here. */
    public MapSumPairs() {
        this.map = new HashMap<>();
        this.trie = new TrieNode();
    }

    public void insert(String key, int val) {
        if (!map.containsKey(key)) {
            insertToTrie(key);
        }
        map.put(key, val);
    }

    public int sum(String prefix) {
        int sum = 0;
        List<String> list = scanAllPrefix(prefix);
        for (String key : list) {
            sum += map.get(key);
        }
        return sum;
    }

    private void insertToTrie(String key) {
        TrieNode root = this.trie;
        for (char c : key.toCharArray()) {
            if (root.children[c-'a'] == null) {
                root.children[c-'a'] = new TrieNode();
            }
            root = root.children[c-'a'];
        }
        root.isEnd = true;
    }

    private List<String> scanAllPrefix(String prefix) {
        TrieNode root = this.trie;
        List<String> list = new LinkedList<>();
        for (char c : prefix.toCharArray()) {
            if (root.children[c-'a'] == null) {
                return list;
            }
            root = root.children[c-'a'];
        }

        traveseSubTree(root, list, prefix);
        return list;
    }

    private void traveseSubTree(TrieNode root, List<String> list, String prefix) {
        if (root.isEnd) {
            list.add(prefix);
        }

        for (int i=0; i < root.children.length; i++) {
            TrieNode child = root.children[i];
            if (child != null) {
                traveseSubTree(child, list, prefix+(char)(i+'a'));
            }
        }
    }
}
