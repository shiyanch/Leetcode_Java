package TopKFrequentWords;

import java.util.*;

/**
 * 692. Top K Frequent Words
 *
 * Given a non-empty list of words, return the k most frequent elements.
 * Your answer should be sorted by frequency from highest to lowest.
 * If two words have the same frequency,
 * then the word with the lower alphabetical order comes first.
 */
public class TopKFrequentWords {
    class Item {
        String val;
        int freq;

        public Item(String val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        PriorityQueue<Item> pq =
                new PriorityQueue<>((i1, i2) -> (i1.freq == i2.freq ? i2.val.compareTo(i1.val) : i1.freq - i2.freq));
        for (String key : map.keySet()) {
            pq.offer(new Item(key, map.get(key)));
            if (pq.size() > k) {
                pq.poll();
            }
        }

        List<String> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            list.add(pq.poll().val);
        }
        Collections.reverse(list);
        return list;
    }

    public static void main(String[] args) {
        String[] s = "i love leetcode i love coding".split(" ");
        int k = 2;
        for (String w : new TopKFrequentWords().topKFrequent(s, k)) {
            System.out.println(w);
        }
    }
}
