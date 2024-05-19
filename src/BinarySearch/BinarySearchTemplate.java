package BinarySearch;

public class BinarySearchTemplate {
    /**
     * 当nums为递增序列，如果target在nums里，返回target第一次出现的下标（最左边）
     * 否则返回第一个比target大的元素下标。这里有两种情况：
     * 1. 所有元素都比target大，这时候返回值为0
     * 2. 所有元素都比target小，这时候返回nums.length（注意已经超出nums边界）
     */
    public static int binarySearch_increasingOrder_yesLeftOtherwiseRightBoundary(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 当nums为递减序列，如果target在nums里，返回target第一次出现的下标（最左边）
     * 否则返回第一个比target小的元素下标。这里有两种情况：
     * 1. 所有元素都比target大，这时候返回值为nums.length（注意已经超出nums边界）
     * 2. 所有元素都比target小，这时候返回0
     */
    public static int binarySearch_decreasingOrder_yesLeftOtherwiseRightBoundary(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] <= target) { // 与递增序列的写法唯一不同之处
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    /**
     * 当nums为递增序列，如果target在nums里，返回target最后次出现的下标（最右边）
     * 否则返回最后一个比target小的元素下标。这里有两种情况：
     * 1. 所有元素都比target大，这时候返回值为-1 （注意已超出nums边界）
     * 2. 所有元素都比target小，这时候返回nums.length-1
     */
    public static int binarySearch_increasingOrder_yesRightOtherwiseLeftBoundary(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    /**
     * 当nums为递减序列，如果target在nums里，返回target最后次出现的下标（最右边）
     * 否则返回最后一个比target大的元素下标。这里有两种情况：
     * 1. 所有元素都比target大，这时候返回值为nums.length-1
     * 2. 所有元素都比target小，这时候返回-1 （注意已超出nums边界）
     */
    public static int binarySearch_decreasingOrder_yesRightOtherwiseLeftBoundary_2(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static int test(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] >= target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 4, 5};
        System.out.println("正序数组二分查找 第一次出现的target的下标或第一个比target大的元素下标");
        System.out.println(BinarySearchTemplate.binarySearch_increasingOrder_yesLeftOtherwiseRightBoundary(nums, 0));
        System.out.println(BinarySearchTemplate.binarySearch_increasingOrder_yesLeftOtherwiseRightBoundary(nums, 2));
        System.out.println(BinarySearchTemplate.binarySearch_increasingOrder_yesLeftOtherwiseRightBoundary(nums, 3));
        System.out.println(BinarySearchTemplate.binarySearch_increasingOrder_yesLeftOtherwiseRightBoundary(nums, 7));

        System.out.println("正序数组二分查找 最后一次出现的target的下标或第一个比target大的元素下标");
        System.out.println(BinarySearchTemplate.binarySearch_increasingOrder_yesRightOtherwiseLeftBoundary(nums, 0));
        System.out.println(BinarySearchTemplate.binarySearch_increasingOrder_yesRightOtherwiseLeftBoundary(nums, 2));
        System.out.println(BinarySearchTemplate.binarySearch_increasingOrder_yesRightOtherwiseLeftBoundary(nums, 3));
        System.out.println(BinarySearchTemplate.binarySearch_increasingOrder_yesRightOtherwiseLeftBoundary(nums, 7));

        System.out.println("正序数组二分查找 最后次出现的比target小的元素下标");
        System.out.println(BinarySearchTemplate.test(nums, 0));
        System.out.println(BinarySearchTemplate.test(nums, 2));
        System.out.println(BinarySearchTemplate.test(nums, 3));
        System.out.println(BinarySearchTemplate.test(nums, 7));

        nums = new int[] {5, 4, 2, 2, 2, 1};
        System.out.println("倒序数组二分查找 第一次出现的target的下标或第一个比target小的元素下标");
        System.out.println(BinarySearchTemplate.binarySearch_decreasingOrder_yesLeftOtherwiseRightBoundary(nums, 0));
        System.out.println(BinarySearchTemplate.binarySearch_decreasingOrder_yesLeftOtherwiseRightBoundary(nums, 2));
        System.out.println(BinarySearchTemplate.binarySearch_decreasingOrder_yesLeftOtherwiseRightBoundary(nums, 3));
        System.out.println(BinarySearchTemplate.binarySearch_decreasingOrder_yesLeftOtherwiseRightBoundary(nums, 7));

        System.out.println("倒序数组二分查找 最后次出现的target的下标或最后一个比target大的元素下标");
        System.out.println(BinarySearchTemplate.binarySearch_decreasingOrder_yesRightOtherwiseLeftBoundary_2(nums, 0));
        System.out.println(BinarySearchTemplate.binarySearch_decreasingOrder_yesRightOtherwiseLeftBoundary_2(nums, 2));
        System.out.println(BinarySearchTemplate.binarySearch_decreasingOrder_yesRightOtherwiseLeftBoundary_2(nums, 3));
        System.out.println(BinarySearchTemplate.binarySearch_decreasingOrder_yesRightOtherwiseLeftBoundary_2(nums, 7));
    }
}
