package NestedListWeightSumII;

import java.util.ArrayList;
import java.util.List;

/**
 * 364. Nested List Weight Sum II
 *
 * Given a nested list of integers,
 * return the sum of all integers in the list weighted by their depth.
 *
 * Each element is either an integer, or a list
 * -- whose elements may also be integers or other lists.
 *
 * Different from the previous question where weight is increasing from root to leaf,
 * now the weight is defined from bottom up.
 * i.e., the leaf level integers have weight 1,
 * and the root level integers have the largest weight.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 8.
 * (four 1's at depth 1, one 2 at depth 2)
 *
 * Example 2:
 * Given the list [1,[4,[6]]], return 17.
 * (one 1 at depth 3, one 4 at depth 2, and one 6 at depth 1; 1*3 + 4*2 + 6*1 = 17)
 */
public class NestedListWeightSumII {
    private List<Integer> levelSum ;
    public int depthSumInverse(List<NestedInteger> nestedList) {
        levelSum = new ArrayList<Integer>();
        if (nestedList == null || nestedList.size() == 0) {
            return 0;
        }
        for (NestedInteger each : nestedList) {
            depthSum(each, 1);
        }

        // Actually total depth is levelSum.size()-1
        int totalDepth = levelSum.size();
        int sum = 0;
        for (int i=1; i<levelSum.size(); i++) {
            sum += levelSum.get(i) * (totalDepth-i);
        }

        return sum;
    }

    private void depthSum(NestedInteger nestedList, int level) {
        if (nestedList.isInteger()) {
            while (levelSum.size() <= level) {
                levelSum.add(0);
            }
            levelSum.set(level, levelSum.get(level)+nestedList.getInteger());
            return;
        }
        for (NestedInteger eachNestedInteger : nestedList.getList()) {
            depthSum(eachNestedInteger, level + 1);
        }
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