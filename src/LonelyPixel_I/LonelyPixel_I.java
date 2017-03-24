package LonelyPixel_I;

import java.util.ArrayList;
import java.util.List;

/**
 * 531. Lonely Pixel I
 *
 * Given a picture consisting of black and white pixels,
 * find the number of black lonely pixels.
 *
 * The picture is represented by a 2D char array consisting of 'B' and 'W',
 * which means black and white pixels respectively.
 *
 * A black lonely pixel is character 'B' that located at a specific position
 * where the same row and same column don't have any other black pixels.
 *
 * Example:
 * Input:
 * [['W', 'W', 'B'],
 * ['W', 'B', 'W'],
 * ['B', 'W', 'W']]
 *
 * Output: 3
 * Explanation: All the three 'B's are black lonely pixels.
 */
public class LonelyPixel_I {
    public int findLonelyPixel(char[][] picture) {
        if (picture.length == 0) {
            return 0;
        }
        int m = picture.length;
        int n = picture[0].length;
        List<String> maybeList = new ArrayList<>();
        int[] rows = new int[m];
        int[] cols = new int[n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (picture[i][j] == 'B') {
                    if (rows[i] == 0 && cols[j] == 0) {
                        maybeList.add(i+"#"+j);
                    }
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int count = 0;
        for (String pos : maybeList) {
            String[] slot = pos.split("#");
            int i = Integer.valueOf(slot[0]);
            int j = Integer.valueOf(slot[1]);
            if (rows[i] == 1 && cols[j] == 1) {
                count++;
            }
        }
        return count;
    }
}
