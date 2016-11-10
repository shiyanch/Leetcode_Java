package LexicographicalNumbers;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 *
 * Given an integer n, return 1 - n in lexicographical order.
 * For example, given 13, return: [1,10,11,12,13,2,3,4,5,6,7,8,9].
 * Please optimize your algorithm to use less time and space.
 *
 * The input size may be as large as 5,000,000.
 */
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<10;i++) {
            dfs(i, n, list);
        }
        return list;
    }

    private void dfs(int cur, int n, List<Integer> list) {
        if(cur <= n) {
            list.add(cur);
            for(int i=0;i<10;i++) {
                if(cur * 10 + i <= n) {
                    dfs(10*cur+i, n, list);
                }
            }
        }
    }
}
