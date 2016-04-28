package PascalsTriangle;

import java.util.LinkedList;
import java.util.List;

/**
 * 118. Pascal's Triangle
 * Given numRows, generate the first numRows of Pascal's triangle.
 *
 * For example, given numRows = 5,
 *
 * Return
 * [
 * [1],
 * [1,1],
 * [1,2,1],
 * [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 */
public class PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<>();
        if(numRows <= 0)
            return result;

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

        return result;
    }
}
