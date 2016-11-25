package MovingAverageFromDataStream;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 346. Moving Average from Data Stream
 *
 * Given a stream of integers and a window size,
 * calculate the moving average of all integers in the sliding window.
 *
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 */
public class MovingAverageFromDataStream {
    private final Queue<Integer> queue;
    private final int size;
    private int currSum;
    /** Initialize your data structure here. */
    public MovingAverageFromDataStream(int size) {
        this.size = size;
        queue = new LinkedList<>();
        currSum = 0;
    }

    public double next(int val) {
        if (queue.size() == size) {
            currSum -= queue.poll();
        }
        queue.offer(val);
        currSum += val;
        return (double)currSum / queue.size();
    }
}
