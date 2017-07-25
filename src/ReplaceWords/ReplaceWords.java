package ReplaceWords;

import java.util.List;

/**
 * 648. Replace Words
 *
 * In English, we have a concept called root,
 * which can be followed by some other words to form another longer word - let's call this word successor.
 *
 * For example, the root an, followed by other, which can form another word another.
 * Now, given a dictionary consisting of many roots and a sentence.
 * You need to replace all the successor in the sentence with the root forming it.
 * If a successor has many roots can form it, replace it with the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 */

public class ReplaceWords {
    class Trie {
        Trie[] children;
        boolean isEnd;
        Trie() {
            isEnd = false;
            children = new Trie[26];
        }
    }

    public String replaceWords(List<String> dict, String sentence) {
        Trie root = buildTrie(dict);
        String[] words = sentence.split("[ ]+");
        StringBuilder sb = new StringBuilder();
        for (String word: words) {
            sb.append(findRoot(root, word)+" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private Trie buildTrie(List<String> dict) {
        Trie root = new Trie();
        for (String word: dict) {
            Trie cur = root;
            for (char c: word.toCharArray()) {
                if (cur.children[c-'a'] == null) {
                    cur.children[c-'a'] = new Trie();
                }
                cur = cur.children[c-'a'];
            }
            cur.isEnd = true;
        }
        return root;
    }

    private String findRoot(Trie root, String word) {
        int i = 0;
        for (char c: word.toCharArray()) {
            if (root.isEnd) {
                return word.substring(0, i);
            }
            if (root.children[c-'a'] == null) {
                return word;
            }
            root = root.children[c-'a'];
            i++;
        }
        return word;
    }
}
