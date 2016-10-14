package ImplementTrie;

/**
 * 208. Implement Trie (Prefix Tree)
 *
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 */
public class ImplementTrie {
    class TrieNode {
        private TrieNode[] children;
        private boolean endHere; // This is important!

        public TrieNode() {
            endHere = false;
        }

        public void insert(char c) {
            if(children == null)
                children = new TrieNode[26];

            if(children[c-'a'] == null) {
                children[c-'a'] = new TrieNode();
            }
        }
    }

    private TrieNode root;

    public ImplementTrie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode cur = root;
        for(char c : word.toCharArray()) {
            cur.insert(c);
            cur = cur.children[c-'a'];
        }
        cur.endHere = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i=0;i<word.length();i++) {
            char c = word.charAt(i);
            if(cur == null || cur.children == null)
                return false;

            if(cur.children[c-'a'] == null)
                return false;
            cur = cur.children[c-'a'];
        }

        return cur.endHere;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i=0;i<prefix.length();i++) {
            char c = prefix.charAt(i);
            if(cur == null || cur.children == null)
                return false;

            if(cur.children[c-'a'] == null)
                return false;
            cur = cur.children[c - 'a'];
        }

        return true;
    }

    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("bad");
        trie.insert("dad");
        trie.insert("mad");
        trie.insert("b");
        System.out.println(trie.search("pad"));
        System.out.println(trie.search("bad"));
        System.out.println(trie.search("bada"));
        System.out.println(trie.search("ba"));
        System.out.println(trie.search("maa"));

        System.out.println(trie.startsWith("dad"));
        System.out.println(trie.startsWith("d"));
        System.out.println(trie.startsWith("da"));
        System.out.println(trie.startsWith("c"));
    }

}
