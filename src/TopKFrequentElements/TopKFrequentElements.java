package TopKFrequentElements;

import java.util.*;

/**
 * 347. Top K Frequent Elements
 *
 * Given a non-empty array of integers,
 * return the k most frequent elements.
 *
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Integer> res = new ArrayList<>();

        for(int n: nums) {
            if(countMap.containsKey(n))
                countMap.put(n, countMap.get(n)+1);
            else
                countMap.put(n, 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pq =
                new PriorityQueue<Map.Entry<Integer, Integer>>((o1, o2) -> o2.getValue() - o1.getValue());

        pq.addAll(countMap.entrySet());

        for(int i=0;i<k;i++)
            res.add(pq.poll().getKey());

        return res;
    }
}
