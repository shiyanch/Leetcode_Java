package WiggleSortII;

/**
 * Given an unsorted array nums,
 * reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
 *
 * Example:
 * (1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
 * (2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].
 *
 * Note:
 * You may assume all input has valid answer.
 * Follow Up:
 * Can you do it in O(n) time and/or in-place with O(1) extra space?
 */
public class WiggleSortII {
    public void wiggleSort(int[] nums) {
        if(nums.length <= 1)
            return;

        for(int i=1;i<nums.length;i++) {
            if(i%2 == 1) {
                if(nums[i] < nums[i-1]) {
                    swap(nums, i, i-1);
                }
                else if(nums[i] == nums[i-1]) {
                    int j=0;
                    while(j < i && nums[j]<=nums[i])
                        j+=2;

                    if(j<i)
                        swap(nums, j, i);
                    else {
                        while(j<nums.length && nums[j]<=nums[i])
                            j++;
                        if(j<nums.length)
                            swap(nums, j, i);
                    }
                }
            }
            else {
                if(nums[i] > nums[i-1]) {
                    swap(nums, i, i-1);
                }
                else if(nums[i] == nums[i-1]) {
                    int j=1;
                    while(j<i && nums[j]>=nums[i])
                        j+=2;

                    if(j<i)
                        swap(nums, j, i);
                    else {
                        while(j<nums.length && nums[j]>=nums[i])
                            j++;
                        if(j<nums.length)
                            swap(nums, j, i);
                    }
                }
            }
        }

        for(int i:nums)
            System.out.print(i+" ");
        System.out.println();
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
