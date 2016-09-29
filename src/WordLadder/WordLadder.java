package WordLadder;

import java.util.*;

/**
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord),
 * and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        wordList.add(endWord);
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 0;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                String cur = queue.poll();
                if(cur.equals(endWord))
                    return level+1;

                for(int j=0;j<cur.length();j++) {
                    char[] word = cur.toCharArray();
                    for(char ch='a';ch<'z';ch++) {
                        word[j] = ch;
                        String check = new String(word);
                        if(!check.equals(cur) && wordList.contains(check)) {
                            queue.add(check);
                            wordList.remove(check);
                        }
                    }
                }
            }
            level++;
        }
        return 0;
    }
}
