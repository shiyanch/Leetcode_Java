package ConcatenatedWords;

import java.util.*;

/**
 * 472. Concatenated Words
 *
 * Given a list of words (without duplicates),
 * please write a program that returns all concatenated words in the given list of words.
 *
 * A concatenated word is defined as a string that is comprised
 * entirely of at least two shorter words in the given array.
 */
public class ConcatenatedWords {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> res = new ArrayList<>();
        Set<String> preWords = new HashSet<>();
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        for (int i=0; i<words.length; i++) {
            if (canFrom(words[i], preWords)) {
                res.add(words[i]);
            }
            preWords.add(words[i]);
        }

        return res;
    }

    private boolean canFrom(String word, Set<String> dict) {
        if (dict.isEmpty()) {
            return false;
        }
        boolean[] dp = new boolean[word.length()+1];
        dp[0] = true;
        for (int i=1; i<=word.length(); i++) {
            for (int j=0; j<i; j++) {
                dp[i] = dp[j] && dict.contains(word.substring(j,i));
                if (dp[i]) {
                    break;
                }
            }
        }
        return dp[word.length()];
    }
}
