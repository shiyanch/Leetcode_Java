package PalindromePairs;

import java.util.*;

/**
 * 336. Palindrome Pairs
 *
 * Given a list of unique words,
 * find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.
 */
public class PalindromePairs {
    class TrieNode {
        TrieNode[] next;
        int index;
        List<Integer> list;

        TrieNode() {
            next = new TrieNode[26];
            index = -1;
            list = new ArrayList<>();
        }
    }

    private void addWord(TrieNode root, String word, int index) {
        for (int i=word.length()-1; i>=0; i--) {
            int j=word.charAt(i)-'a';
            if (root.next[j] == null) {
                root.next[j] = new TrieNode();
            }

            if (isPalindrome(word, 0, i)) {
                root.list.add(index);
            }

            root = root.next[j];
        }

        root.list.add(index);
        root.index = index;
    }

    private void search(String[] words, int i, TrieNode root, List<List<Integer>> result) {
        for (int j=0; j<words[i].length(); j++) {

            // word[i]的前j个字符在trie中找到，且word[i]的剩余部分是回文
            // 则可以构成一个回文，内容是word[i]+word[root.index]，word[root.index]作为补充
            if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length()-1)) {
                result.add(Arrays.asList(i, root.index));
            }
            root = root.next[words[i].charAt(j)-'a'];
            if (root == null) {
                return;
            }
        }

        // word[i]全部匹配，但当前trie节点不是单词的终结，那么找root.list中的节点
        // 构成的回文内容是word[i]+word[root.index]，word[i]作为补充
        for (int j:root.list) {
            if (i == j) {
                continue;
            }
            result.add(Arrays.asList(i, j));
        }

    }

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        TrieNode root = new TrieNode();
        for (int i=0; i<words.length; i++) {
            addWord(root, words[i], i);
        }

        for (int i=0; i<words.length; i++) {
            search(words, i, root, result);
        }

        return result;
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    public List<List<Integer>> palindromePairs_hashmap(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i=0; i<words.length; i++) {
            map.put(words[i], i);
        }

        for (int i=0; i<words.length; i++) {
            int l=0, r=0;
            while (l <= r) {
                String s = words[i].substring(l, r);
                Integer j = map.get(new StringBuilder(s).reverse().toString());
                if (j != null && i!=j && isPalindrome(words[i].substring(l==0?r:0, l==0?words[i].length():l))) {
                    result.add(Arrays.asList(l==0?new Integer[] {i, j}:new Integer[] {j,i}));
                }

                if (r < words[i].length()) {
                    ++r;
                }
                else {
                    ++l;
                }
            }
        }

        return result;
    }

    private boolean isPalindrome(String s) {
        for (int i=0; i<s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = new String[] {"abcd", "dcba", "lls", "s", "sssll"};
        System.out.println(new PalindromePairs().palindromePairs(words));
    }
}
