package WordBreakII;

import java.util.*;

/**
 * 140. Word Break II
 *
 * Given a string s and a dictionary of words dict,
 * add spaces in s to construct a sentence where each word is a valid dictionary word.
 *
 * Return all such possible sentences.
 *
 * For example, given
 * s = "catsanddog",
 * dict = ["cat", "cats", "and", "sand", "dog"].
 * A solution is ["cats and dog", "cat sand dog"].
 */
public class WordBreakII {
    // https://discuss.leetcode.com/topic/34260/java-dp-dfs-memoization-dfs-and-dp-pruning-solutions-with-analysis/2
    // 38ms
    private final Map<String, List<String>> cache = new HashMap<>();
    public List<String> wordBreak(String s, Set<String> wordDict) {
        if(cache.containsKey(s)) {
            return cache.get(s);
        }
        List<String> result = new LinkedList<>();
        if(wordDict.contains(s)) {
            result.add(s);
        }

        for(int i=1;i<=s.length();i++) {
            String left = s.substring(0,i);
            String right = s.substring(i);
            if(wordDict.contains(left) && containsSuffix(wordDict, right)) {
                for(String ss : wordBreak(right, wordDict)) {
                    result.add(left+" "+ss);
                }
            }
        }

        cache.put(s, result);
        return result;
    }

    private boolean containsSuffix(Set<String> dict, String str) {
        for (int i = 0; i < str.length(); i++) {
            if (dict.contains(str.substring(i))) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<>();
        String s = "catsanddog";
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        System.out.println(new WordBreakII().wordBreak(s, wordDict).toString());
    }
}
