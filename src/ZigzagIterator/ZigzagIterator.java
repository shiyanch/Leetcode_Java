package ZigzagIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 281. Zigzag Iterator
 *
 * Given two 1d vectors, implement an iterator to return their elements alternately.
 * For example, given two 1d vectors:
 * v1 = [1, 2]
 * v2 = [3, 4, 5, 6]
 *
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1, 3, 2, 4, 5, 6].
 *
 * Follow up: What if you are given k 1d vectors?
 * How well can your code be extended to such cases?
 */
public class ZigzagIterator {
    private final ArrayList<Iterator<Integer>> iterators;
    private int index;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new ArrayList<Iterator<Integer>>();
        iterators.add(v1.iterator());
        iterators.add(v2.iterator());
        index = 0;
    }

    public int next() {
        int next = iterators.get(index).next();
        index = (index+1) % iterators.size();
        return next;
    }

    public boolean hasNext() {
        while (!iterators.isEmpty() && !iterators.get(index).hasNext()) {
            iterators.remove(index);
            if (index == iterators.size()) {
                index = 0;
            }
        }

        return !iterators.isEmpty();
    }


    // Using LinkedList
    /*
    private final LinkedList<Iterator<Integer>> iterators;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        iterators = new LinkedList<Iterator<Integer>>();
        if (!v1.isEmpty()) iterators.add(v1.iterator());
        if (!v2.isEmpty()) iterators.add(v2.iterator());
    }

    public int next() {
        Iterator<Integer> curr = iterators.remove();
        int next = curr.next();
        if (curr.hasNext()) {
            iterators.add(curr);
        }
        return next;
    }

    public boolean hasNext() {
        return !iterators.isEmpty();
    }
    */

    public static void main(String[] args) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);
        ZigzagIterator i = new ZigzagIterator(list1, list2);
        while (i.hasNext()) {
            System.out.print(i.next()+" ");
        }
    }
}
