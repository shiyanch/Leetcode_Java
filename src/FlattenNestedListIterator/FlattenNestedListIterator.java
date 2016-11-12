package FlattenNestedListIterator;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 341. Flatten Nested List Iterator
 *
 * Given a nested list of integers,
 * implement an iterator to flatten it.
 *
 * Each element is either an integer,
 * or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]],
 *
 * By calling next repeatedly until hasNext returns false,
 * the order of elements returned by next should be: [1,1,2,1,1].
 */

// Another solution that worth to read :
// https://discuss.leetcode.com/topic/42042/simple-java-solution-using-a-stack-with-explanation

public class FlattenNestedListIterator implements Iterator<Integer> {
    private final Stack<Integer> stack = new Stack<>();
    private final Iterator<Integer> iterator;

    public FlattenNestedListIterator(List<NestedInteger> nestedList) {
        for(NestedInteger nestedInteger : nestedList) {
            makeStack(nestedInteger, stack);
        }
        this.iterator = stack.iterator();
    }

    private void makeStack(NestedInteger nestedInteger, Stack<Integer> stack) {
        if(nestedInteger.isInteger()) {
            stack.push(nestedInteger.getInteger());
        }
        else {
            List<NestedInteger> list = nestedInteger.getList();
            for(NestedInteger innerNestedInteger : list) {
                makeStack(innerNestedInteger, stack);
            }
        }
    }

    @Override
    public Integer next() {
        return this.iterator.next();
    }

    @Override
    public boolean hasNext() {
        return this.iterator.hasNext();
    }
}

interface NestedInteger {
    // @return true if this NestedInteger holds a single integer, rather than a nested list.
    public boolean isInteger();

    // @return the single integer that this NestedInteger holds, if it holds a single integer
    // Return null if this NestedInteger holds a nested list
    public Integer getInteger();

    // @return the nested list that this NestedInteger holds, if it holds a nested list
    // Return null if this NestedInteger holds a single integer
    public List<NestedInteger> getList();
}
