package FindTheDuplicateNumber;

/**
 * 287. Find the Duplicate Number
 *
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive)
 * Prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Note:
 * 1.You must not modify the array (assume the array is read only).
 * 2.You must use only constant, O(1) extra space.
 * 3.Your runtime complexity should be less than O(n2).
 * 4.There is only one duplicate number in the array, but it could be repeated more than once.
 */
public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int n = nums.length - 1;
        int mid=0,left=1, right = n;

        while( left <= right) {
            mid = (left + right) >> 1;
            int c = count(nums, mid);
            if (c <= mid) left=mid+1;
            else right=mid-1;
        }
        return left;
    }

    private int count(int[] nums, int mid) {
        int c=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i] <= mid)
                c++;
        }

        return c;
    }

    // O(n)
    // https://discuss.leetcode.com/topic/25685/java-o-n-time-and-o-1-space-solution-similar-to-find-loop-in-linkedlist
    public int findDuplicate2(int[] nums) {
        int n = nums.length;
        int slow = n;
        int fast = n;
        do{
            slow = nums[slow-1];
            fast = nums[nums[fast-1]-1];
        }while(slow != fast);
        slow = n;
        while(slow != fast){
            slow = nums[slow-1];
            fast = nums[fast-1];
        }
        return slow;
    }
}
