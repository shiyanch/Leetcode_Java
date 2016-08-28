package TwoSumII;

/**
 * 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2.
 * Please note that your returned answers (both index1 and index2) are not zero-based.
 *
 * You may assume that each input would have exactly one solution.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 */

public class TwoSumII {

    public int[] twoSum2(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers.length <= 2)
            return res;

        int left = 0;
        int right = numbers.length-1;

        while(left < right) {
            int sum = numbers[left]+numbers[right];
            if(sum < target)
                left++;
            else if(sum > target)
                right--;
            else {
                res[0] = left+1;
                res[1] = right+1;
                return res;
            }

        }

        return res;
    }


    public int[] twoSum(int[] numbers, int target) {

        for(int i=0;i<numbers.length;i++) {
            int res = binarySearch(numbers, i+1, numbers.length-1, target-numbers[i]);
            if(res != -1)
                return new int[] {i+1, res+1};
        }

        return null;
    }

    private int binarySearch(int[] numbers, int left, int right, int key) {
        if(left > right)
            return -1;

        int mid = (left+right)/2;
        if(numbers[mid] < key)
            return binarySearch(numbers, mid+1, right, key);
        else if (numbers[mid] > key)
            return binarySearch(numbers, left, mid-1, key);
        else
            return mid;
    }
}
