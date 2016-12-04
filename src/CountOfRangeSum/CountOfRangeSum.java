package CountOfRangeSum;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 327. Count of Range Sum
 *
 * Given an integer array nums,
 * return the number of range sums that lie in [lower, upper] inclusive.
 *
 * Range sum S(i, j) is defined as the sum of the elements in nums
 * between indices i and j (i ≤ j), inclusive.
 */
public class CountOfRangeSum {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sums = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countWhileMergeSort(sums, 0, nums.length + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }

        int mid = (start - end) / 2 + end;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid, k = mid, t = mid;
        long[] cache = new long[end - start];

        for (int i = start, r = 0; i < mid; i++, r++) {

            // k is the first index satisfy sums[k] - sums[i] >= lower
            while (k < end && sums[k] - sums[i] < lower) {
                k++;
            }

            // j is the first index satisfy sums[j] - sums[i] > upper
            while (j < end && sums[j] - sums[i] <= upper) {
                j++;
            }

            while (t < end && sums[t] < sums[i]) {
                cache[r++] = sums[t++];
            }
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }


    class SegmentTreeNode {
        SegmentTreeNode left;
        SegmentTreeNode right;
        int count;
        long min;
        long max;

        public SegmentTreeNode(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }

    private SegmentTreeNode buildSegmentTree(Long[] valArr, int low, int high) {
        if (low > high) {
            return null;
        }
        SegmentTreeNode root = new SegmentTreeNode(valArr[low], valArr[high]);
        if (low == high) {
            return root;
        }

        int mid = (high - low) / 2 + low;
        root.left = buildSegmentTree(valArr, low, mid);
        root.right = buildSegmentTree(valArr, mid + 1, high);
        return root;
    }

    private void updateSegmentTree(SegmentTreeNode root, long val) {
        if (root == null) {
            return;
        }

        if (val >= root.min && val <= root.max) {
            root.count++;
            updateSegmentTree(root.left, val);
            updateSegmentTree(root.right, val);
        }
    }

    private int getCount(SegmentTreeNode root, long min, long max) {
        if (root == null || min > root.max || max < root.min) {
            return 0;
        }

        if (min <= root.min && max >= root.max) {
            return root.count;
        }
        else {
            return getCount(root.left, min, max) + getCount(root.right, min, max);
        }
    }

    public int countRangeSum_SegmentTree(int[] nums, int lower, int upper) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int ans = 0;
        Set<Long> valSet = new HashSet<>();
        long sum = 0;
        for (int i=0; i<nums.length; i++) {
            sum += nums[i];
            valSet.add(sum);
        }

        Long[] valArr = valSet.toArray(new Long[0]);
        Arrays.sort(valArr);
        SegmentTreeNode root = buildSegmentTree(valArr, 0, valArr.length-1);

        for (int i=nums.length-1; i>=0; i--) {
            updateSegmentTree(root, sum);
            sum -= (long) nums[i];
            ans += getCount(root, (long) lower+sum, (long) upper+sum);
        }

        return ans;
    }




























}
