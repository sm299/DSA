package BinarySearch;

public class LowerBound {
    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 1, 3, 4, 5, 6, 7, 8, 9 };
        int target = 2;
        int target1 = 10;
        System.out.println(searchLowerBound(nums, target));
        System.out.println(searchLowerBound(nums, target1));
    }

    private static int searchLowerBound(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        int ind = nums.length;
        while (low <= high) {
            int mid = (high + low) / 2;
            if (nums[mid] >= target) {
                ind = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ind;
    }
}
