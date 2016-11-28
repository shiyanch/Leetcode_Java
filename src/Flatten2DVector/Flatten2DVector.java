package Flatten2DVector;

import java.util.Iterator;
import java.util.List;

/**
 * 251. Flatten 2D Vector
 *
 * Implement an iterator to flatten a 2d vector.
 *
 * For example,
 * Given 2d vector =
 * [
 * [1,2],
 * [3],
 * [4,5,6]
 * ]
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,2,3,4,5,6].
 */
public class Flatten2DVector implements Iterator<Integer> {
    private final Iterator<List<Integer>> listIterator;
    private Iterator<Integer> iterator;
    private List<Integer> currList;
    public Flatten2DVector(List<List<Integer>> vec2d) {
        this.listIterator = vec2d.iterator();
        if (listIterator.hasNext()) {
            currList = listIterator.next();
            iterator = currList.iterator();
        }
    }

    @Override
    public Integer next() {
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (currList == null) {
            return false;
        }

        if (iterator.hasNext()) {
            return true;
        }

        while (!iterator.hasNext()) {
            if (!listIterator.hasNext()) {
                return false;
            }
            else {
                currList = listIterator.next();
                iterator = currList.iterator();
            }
        }
        return true;
    }
}
