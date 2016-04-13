package ContainerWithMostWater;

/**
 * 11. Container With Most Water
 * Given n non-negative integers a1, a2, ..., an,
 * where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 *
 * Find two lines, which together with x-axis forms a container,
 * such that the container contains the most water.
 *
 * Note: You may not slant the container.
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        if(height == null || height.length < 2)
            return 0;

        int left = 0;
        int right = height.length-1;

        int maxArea = 0;

        while(left < right) {
            maxArea = Math.max(maxArea, Math.min(height[left], height[right])
                *(right - left));

            // our aim is to find max area size
            // since right - left will always be smaller after each loop
            // assume height[left] < height[right]
            //   1. if we move right (right--) to right'
            //      a. if height[left] < height[right'], area = height[left] * (right' - left), become smaller
            //      b. if height[left] > height[right'], area = height[right'] * (right' - left), become smaller
            //   2. if we move left (left++) to left'
            //      c. if height[left'] < height[right], area = height[left'] * (right - left'), might be bigger
            //      d. if height[left'] > height[right], area = height[right] * (right - left'), might be bigger
            //   therefore, we should move the less pointer.

            if(height[left] < height[right])
               left++;
            else
                right--;
        }

        return maxArea;
    }
}
