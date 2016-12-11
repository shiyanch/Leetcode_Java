package InsertDeleteGetRandomO1;

import PacificAtlanticWaterFlow.PacificAtlanticWaterFlow;

import java.util.*;

/**
 * 380. Insert Delete GetRandom O(1)
 *
 * Design a data structure that supports all following operations in average O(1) time.
 *
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements.
 * Each element must have the same probability of being returned.
 */
public class InsertDeleteGetRandomO1 {
    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random rand = new java.util.Random();
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        if (index < list.size()-1) {
            int lastone = list.get(list.size()-1);
            list.set(index, lastone);
            map.put(lastone, index);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
