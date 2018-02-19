package LongestWordInDictionary;

import java.util.HashSet;
import java.util.Set;

/**
 * 720. Longest Word in Dictionary
 *
 * Given a list of strings words representing an English Dictionary,
 * find the longest word in words that can be built one character at a time by other words in words.
 *
 * If there is more than one possible answer,
 * return the longest word with the smallest lexicographical order.
 *
 * If there is no answer, return the empty string.
 */
public class LongestWordInDictionary {
    public String longestWord(String[] words) {
        String ans = "";
        Set<String> wordset = new HashSet();
        for (String word: words) wordset.add(word);
        for (String word: words) {
            if (word.length() > ans.length() ||
                    word.length() == ans.length() && word.compareTo(ans) < 0) {
                boolean good = true;
                for (int k = 1; k < word.length(); ++k) {
                    if (!wordset.contains(word.substring(0, k))) {
                        good = false;
                        break;
                    }
                }
                if (good) ans = word;
            }
        }
        return ans;
    }
}
