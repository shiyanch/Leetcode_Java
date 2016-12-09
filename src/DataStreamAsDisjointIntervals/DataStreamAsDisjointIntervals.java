package DataStreamAsDisjointIntervals;

import StringToInteger.StringToInteger;

import java.util.ArrayList;
import java.util.List;

/**
 * 352. Data Stream as Disjoint Intervals
 *
 * Given a data stream input of non-negative integers
 * a1, a2, ..., an, ..., summarize the numbers seen so far as a list of disjoint intervals.
 *
 * For example, suppose the integers from the data stream are 1, 3, 7, 2, 6, ...,
 * then the summary will be:
 * [1, 1]
 * [1, 1], [3, 3]
 * [1, 1], [3, 3], [7, 7]
 * [1, 3], [7, 7]
 * [1, 3], [6, 7]
 */
class Interval {
    int start;
    int end;
    Interval() {
        start = 0;
        end = 0;
    }
    Interval(int s, int e) {
        start = s;
        end = e;
    }

    @Override
    public String toString() {
        return "["+start+", "+end+"]";
    }
}
public class DataStreamAsDisjointIntervals {

    class BSTNode {
        Interval interval;
        BSTNode left;
        BSTNode right;
        BSTNode(Interval i) {
            interval = i;
        }
    }

    private BSTNode root;
    private final List<Interval> list = new ArrayList<>();
    public DataStreamAsDisjointIntervals() {
        root = null;
    }

    public void addNum(int val) {
        if (root == null) {
            root = addKey(val, root);
        }
        else {
            if (findKey(val, root) != null) {
                return;
            }
            BSTNode left = findKey(val-1, root);
            BSTNode right = findKey(val+1, root);
            if (left == null && right == null) {
                root = addKey(val, root);
            }
            else if (left != null && right == null) {
                left.interval.end++;
            }
            else if (left == null && right != null) {
                right.interval.start--;
            }
            else {
                Interval l = left.interval;
                int e = right.interval.end;
                root = remove(right.interval, root);
                l.end = e;
            }
        }
    }

    public List<Interval> getIntervals() {
        list.clear();
        inOrder(root);
        return list;
    }

    private void inOrder(BSTNode root) {
        if (root != null) {
            inOrder(root.left);
            list.add(root.interval);
            inOrder(root.right);
        }
    }

    private BSTNode findMin(BSTNode root) {
        if (root == null) return null;
        if (root.left == null ) return root;
        else return findMin(root.left);
    }

    private BSTNode remove(Interval interval, BSTNode root) {
        if (root == null) {
            return null;
        }
        else if (interval == null) {
            return root;
        }
        else if (interval.start > root.interval.end) {
            root.right = remove(interval, root.right);
        }
        else if (interval.end < root.interval.start) {
            root.left = remove(interval, root.left);
        }
        else if (root.left != null && root.right != null) {
            root.interval = findMin(root.right).interval;
            root.right = remove(root.interval, root.right);
        }else {
            root = (root.left != null)?root.left : root.right;
        }
        return root;
    }

    private BSTNode findKey(int val, BSTNode root) {
        if (root == null) {
            return null;
        }
        if (root.interval.start > val) {
            return findKey(val, root.left);
        }
        else if (root.interval.end < val) {
            return findKey(val, root.right);
        }
        else {
            return root;
        }
    }

    private BSTNode addKey(int val, BSTNode root) {
        if (root == null) {
            root = new BSTNode(new Interval(val, val));
        }
        else if (root.interval.start > val) {
            root.left = addKey(val, root.left);
        }
        else if (root.interval.end < val) {
            root.right = addKey(val, root.right);
        }
        return root;
    }

    public static void main(String[] args) {
        DataStreamAsDisjointIntervals obj = new DataStreamAsDisjointIntervals();
        obj.addNum(1);
        obj.addNum(3);
        obj.addNum(2);
        System.out.println(obj.getIntervals().toString());
    }
}
