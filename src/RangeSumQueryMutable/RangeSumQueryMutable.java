package RangeSumQueryMutable;

/**
 * 307. Range Sum Query - Mutable
 *
 * Given an integer array nums,
 * find the sum of the elements between indices i and j (i ≤ j), inclusive.
 *
 * The update(i, val) function modifies nums by updating the element at index i to val.
 * Example:
 * Given nums = [1, 3, 5]
 *
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 *
 * Note:
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is distributed evenly.
 */
public class RangeSumQueryMutable {
    static class SegmentTreeNode {
        int start;
        int end;
        int sum;
        SegmentTreeNode left;
        SegmentTreeNode right;
        public SegmentTreeNode(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }
    }

    private final SegmentTreeNode root;
    private final int[] A;

    public RangeSumQueryMutable(int[] nums) {
        this.A = nums;
        this.root = build(A, 0, A.length-1);
    }

    void update(int i, int val) {
        modify(root, i, val);
    }

    public int sumRange(int i, int j) {
        return query(root, i, j);
    }

    private int modify(SegmentTreeNode root, int index, int value) {
        if (root == null) {
            return 0;
        }

        if (root.start > index || root.end < index) {
            return root.sum;
        }

        if (root.start == index && root.end == index) {
            root.sum = value;
        }
        else {
            int mid = (root.start + root.end)/2;
            if (mid >= index) {
                root.sum = root.right.sum + modify(root.left, index, value);
            }
            else {
                root.sum = root.left.sum + modify(root.right, index, value);
            }
        }
        return root.sum;
    }

    private int query(SegmentTreeNode root, int start, int end) {
        if (root == null) {
            return 0;
        }
        if (end < root.start || start > root.end) {
            return 0;
        }

        if (start <= root.start && root.end <= end) {
            return root.sum;
        }

        int mid = (root.start + root.end)/2;
        int sum = 0;
        if (start <= mid) {
            sum += query(root.left, start, end);
        }
        if (end > mid) {
            sum += query(root.right, start, end);
        }

        return sum;
    }

    private SegmentTreeNode build(int[] A, int start, int end) {
        if (start > end || start < 0 || end >= A.length) {
            return null;
        }

        SegmentTreeNode root = new SegmentTreeNode(start, end);
        if (start == end) {
            root.sum = A[start];
        }
        else {
            int mid = (start + end)/2;
            root.left = build(A, start, mid);
            root.right = build(A, mid+1, end);
            root.sum = ((root.left==null)?0:root.left.sum) + ((root.right==null)?0:root.right.sum);
        }

        return root;
    }
}
