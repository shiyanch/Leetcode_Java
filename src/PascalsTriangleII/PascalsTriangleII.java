package PascalsTriangleII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * Given an index k, return the kth row of the Pascal's triangle.
 *
 * For example, given k = 3,
 * Return [1,3,3,1].
 *
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 *
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 */
public class PascalsTriangleII {
    public List<Integer> generate(int rowIndex) {
        int numRows = rowIndex+1;
        List<List<Integer>> result = new LinkedList<>();
        if(numRows <= 0)
            return new LinkedList<>();

        for(int i = 0;i<numRows;i++) {
            List<Integer> cur = new LinkedList<>();
            for(int j=0;j<i+1;j++) {
                if(j == 0 || j == i)
                    cur.add(1);
                else {
                    List<Integer> last = result.get(i-1);
                    cur.add(last.get(j-1)+last.get(j));
                }
            }
            result.add(cur);
        }

        return result.get(rowIndex);
    }

    public List<Integer> generate2(int rowIndex) {
        List<Integer> result = new ArrayList<>();
        for(int i=0;i<rowIndex+1;i++) {
            result.add(1);
            for(int j=i-1;j>0;j--) {
                result.set(j,result.get(j-1)+result.get(j));
            }
        }
        return result;
    }
}
