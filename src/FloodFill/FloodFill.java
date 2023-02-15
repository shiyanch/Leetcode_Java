package FloodFill;

import java.util.*;

/**
 * 733. Flood Fill
 *
 * An image is represented by an m x n integer grid image where image[i][j] represents the pixel value of the image.
 *
 * You are also given three integers sr, sc, and color. You should perform a flood fill on the image starting from the pixel image[sr][sc].
 *
 * To perform a flood fill, consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color), and so on. Replace the color of all of the aforementioned pixels with color.
 *
 * Return the modified image after performing the flood fill.
 */
public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }

        Queue<int[]> queue = new LinkedList<>();
        int initialColor = image[sr][sc];

        queue.offer(new int[] {sr, sc});

        while(!queue.isEmpty()) {
            int[] pixel = queue.poll();
            image[pixel[0]][pixel[1]] = color;
            findSameColorPixelsInFourDirections(image, pixel[0], pixel[1], initialColor, queue);
        }

        return image;
    }

    private static void findSameColorPixelsInFourDirections(int[][] image, int sr, int sc, int initialColor, Queue<int[]> queue) {
        if (sr > 0 && image[sr-1][sc] == initialColor) {
            queue.offer(new int[] {sr-1, sc});
        }

        if (sr < image.length - 1 && image[sr+1][sc] == initialColor) {
            queue.offer(new int[] {sr+1, sc});
        }

        if (sc > 0 && image[sr][sc-1] == initialColor) {
            queue.offer(new int[] {sr, sc-1});
        }

        if (sc < image[0].length - 1 && image[sr][sc+1] == initialColor) {
            queue.offer(new int[] {sr, sc+1});
        }
    }
}
