package ImplementMagicDictionary;

/**
 * 676. Implement Magic Dictionary
 *
 * Implement a magic directory with buildDict, and search methods.
 * For the method buildDict,
 * you'll be given a list of non-repetitive words to build a dictionary.
 *
 * For the method search, you'll be given a word,
 * and judge whether if you modify exactly one character into another character in this word,
 * the modified word is in the dictionary you just built.
 */
public class ImplementMagicDictionary {
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private final TrieNode root;

    /** Initialize your data structure here. */
    public ImplementMagicDictionary() {
        this.root = new TrieNode();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            insertToTrie(word);
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        return searchTrie(word, 0, false, root);
    }

    private boolean searchTrie(String word, int index, boolean changed, TrieNode root) {
        if (root == null) {
            return false;
        }

        if (index == word.length()) {
            return changed && root.isEnd; // Very Important!
        }

        // change current char
        if (!changed) {
            for (int i=0; i<26; i++) {
                if (i != word.charAt(index)-'a' && root.children[i] != null && searchTrie(word, index+1, true, root.children[i])) {
                    return true;
                }
            }
        }

        // not find when change current char, now don't change current char
        if (root.children[word.charAt(index)-'a'] == null) {
            return false;
        }
        return searchTrie(word, index+1, changed, root.children[word.charAt(index)-'a']);
    }

    private void insertToTrie(String s) {
        TrieNode cur = root;
        for (char c : s.toCharArray()) {
            if (cur.children[c-'a'] == null) {
                cur.children[c-'a'] = new TrieNode();
            }
            cur = cur.children[c-'a'];
        }
        cur.isEnd = true;
    }
}
