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

    // TLE !!
    public List<String> wordBreak_dp(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> l = new ArrayList<String >();
        l.add("");
        map.put(s.length(), l);

        for(int i=s.length()-1;i>=0;i--) {
            List<String> tmp = new ArrayList<>();
            for(int j=i+1;j<=s.length();j++) {
                if(map.containsKey(j) && wordDict.contains(s.substring(i, j))) {
                    for (String str : map.get(j)) {
                        tmp.add(s.substring(i, j)+(str.isEmpty() ? "" : " ")+str);
                    }
                }
            }
            map.put(i, tmp);
        }

        return map.getOrDefault(0, new ArrayList<>());
    }

    private int getMaxLen(Set<String> wordDict) {
        int max = 0;
        for (String s : wordDict) {
            max = Math.max(max, s.length());
        }
        return max;
    }

    public static void main(String[] args) {
        Set<String> wordDict = new HashSet<>();
        String s = "catsanddog";
        wordDict.add("cat");
        wordDict.add("cats");
        wordDict.add("and");
        wordDict.add("sand");
        wordDict.add("dog");

        System.out.println(new WordBreakII().wordBreak_dp(s, wordDict).toString());
    }
}
