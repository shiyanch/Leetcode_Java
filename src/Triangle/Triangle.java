package Triangle;

import java.util.List;

/**
 * 120. Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom.
 * Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 * [
 *    [2],
 *   [3,4],
 *  [6,5,7],
 * [4,1,8,3]
 * ]
 *
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 */

// a[i][j] <--> b[i*(i+1)/2 + j]
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() == 1)
            return triangle.get(0).get(0);

        int len = triangle.size()*(triangle.size()+1)/2;
        int[] dp = new int[len];

        dp[0] = triangle.get(0).get(0);
        int min = Integer.MAX_VALUE;

        for(int i=1;i<triangle.size();i++) {
            List<Integer> innerList = triangle.get(i);
            for(int j=0;j<innerList.size();j++) {
                if(j==0)
                    dp[i*(i+1)/2+j] = dp[(i-1)*i/2+j];
                else if(j==i)
                    dp[i*(i+1)/2+j] = dp[(i-1)*i/2+j-1];
                else
                    dp[i*(i+1)/2+j] = Math.min(dp[(i-1)*i/2+j-1], dp[(i-1)*i/2+j]);

                dp[i*(i+1)/2+j] += innerList.get(j);

                if(i == triangle.size()-1 && dp[i*(i+1)/2+j] < min)
                    min = dp[i*(i+1)/2+j];
            }
        }

        return min;
    }
}
