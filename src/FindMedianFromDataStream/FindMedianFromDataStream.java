package FindMedianFromDataStream;

import java.util.ArrayList;

/**
 * 295. Find Median from Data Stream
 *
 * Median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value.
 * So the median is the mean of the two middle value.
 *
 * Examples:
 * [2,3,4] , the median is 3
 * [2,3], the median is (2 + 3) / 2 = 2.5
 *
 * Design a data structure that supports the following two operations:
 * void addNum(int num) - Add a integer number from the data stream to the data structure.
 * double findMedian() - Return the median of all elements so far.
 *
 * For example:
 * add(1)
 * add(2)
 * findMedian() -> 1.5
 * add(3)
 * findMedian() -> 2
 */
public class FindMedianFromDataStream {
    private ArrayList<Integer> array = new ArrayList<>();

    public void addNum(int num) {
        if(array.isEmpty()) {
            array.add(num);
            return;
        }

        int mid,left=0,right=array.size()-1;

        while(left <= right) {
            mid = (left+right) >> 1;
            if(array.get(mid) > num)
                right = mid-1;
            else
                left = mid+1;
        }

        array.add(left,num);
    }

    public double findMedian() {
        int size = array.size();
        if(size == 0)
            return 0;

        if(size%2 == 0)
            return (array.get(size/2)+array.get(size/2-1))/2.0;
        else
            return array.get(size/2);
    }
}
