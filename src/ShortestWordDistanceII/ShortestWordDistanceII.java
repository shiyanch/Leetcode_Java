package ShortestWordDistanceII;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 244. Shortest Word Distance II
 *
 * This is a follow up of Shortest Word Distance.
 * The only difference is now you are given the list of words
 * and your method will be called repeatedly many times
 * with different parameters. How would you optimize it?
 *
 * Design a class which receives a list of words in the constructor,
 * and implements a method that takes two words word1 and word2
 * and return the shortest distance between these two words in the list.
 */
public class ShortestWordDistanceII {
    private Map<String, List<Integer>> map;
    public ShortestWordDistanceII(String[] words) {
        map = new HashMap<String, List<Integer>>();
        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) {
                map.put(words[i], new ArrayList<Integer>());
            }
            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {
        List<Integer> list1 = map.get(word1);
        List<Integer> list2 = map.get(word2);
        int min = Integer.MAX_VALUE;
        for (int i=0, j=0; i < list1.size() && j < list2.size();) {
            int index1 = list1.get(i);
            int index2 = list2.get(j);
            min = Math.min(min, Math.abs(index1-index2));
            if (index1 < index2) {
                i++;
            }
            else {
                j++;
            }
        }
        return min;
    }
}
