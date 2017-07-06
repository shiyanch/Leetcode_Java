package LonelyPixel_II;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 533. Lonely Pixel II
 *
 * Given a picture consisting of black and white pixels,
 * and a positive integer N,
 * find the number of black pixels located at some specific row R and column C
 * that align with all the following rules:
 *
 * Row R and column C both contain exactly N black pixels.
 * For all rows that have a black pixel at column C, they should be exactly the same as row R
 * The picture is represented by a 2D char array consisting of 'B' and 'W',
 * which means black and white pixels respectively.
 */
public class LonelyPixel_II {
    /**
     * Steps:
     * >> 1. create map<int, set<int>> cols, rows; -- to store black dots on that row;
     *
     *     _0_1_2_3_4_5_
     *  0 | 0 l 0 1 1 0     rows[0] = {1, 3, 4}
     *  1 | 0 l 0 1 1 0     rows[1] = {1, 3, 4}
     *  2 | 0 l 0 1 1 0     rows[2] = {1, 3, 4}
     *  3 | 0 0 1 0 1 0     rows[3] = {  2,  4}
     *
     * >> 2. for every pixel meet rule 1, that is: pic[i][j] == 'B' && rows[i].size() == N && cols[j].size() == N
     *       check rule2: for every row k in cols[j];  check that row[k] = row[i];
     *
     * We can tell the 6 black pixel in col 1 and col 3 are lonely pixels
     *     _0_1_2_3_4_5_
     *  0 | 0 L 0 L 1 0     rows[0] = {1, 3, 4}  =
     *  1 | 0 L 0 L 1 0     rows[1] = {1, 3, 4}  =
     *  2 | 0 L 0 L 1 0     rows[2] = {1, 3, 4}
     *  3 | 0 0 1 0 1 0     rows[3] = {  2,  4}
     *
     */
    public int findBlackPixel(char[][] pic, int N) {
        int m = pic.length;
        int n = pic[0].length;
        Map<Integer, Set<Integer>> rows = new HashMap<Integer, Set<Integer>>(); // black pixels in each row;
        Map<Integer, Set<Integer>> cols = new HashMap<Integer, Set<Integer>>(); // black pixels in each col;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pic[i][j] == 'B') {
                    if (!rows.containsKey(i)) { rows.put(i, new HashSet<Integer>()); }
                    if (!cols.containsKey(j)) { cols.put(j, new HashSet<Integer>()); }
                    rows.get(i).add(j);
                    cols.get(j).add(i);
                }
            }
        }

        int lonelys = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n && rows.containsKey(i); j++) {
                if (pic[i][j] == 'B' && rows.get(i).size() == N && cols.containsKey(j) && cols.get(j).size() == N) {   // rule 1 fulfilled
                    int lonely = 1;
                    for (int row : cols.get(j)) {
                        if (!rows.get(i).equals(rows.get(row))) {
                            lonely = 0; break;
                        }
                    }
                    lonelys += lonely;
                }
            }
        }
        return lonelys;
    }
}
