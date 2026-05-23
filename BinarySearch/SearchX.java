package BinarySearch;

import java.util.Arrays;

public class SearchX {
    public static void main(String[] args) {
        int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };
        int target = 1;
        System.out.println("Index of target : " + search(nums, target));
        System.out.println("Index of target : " + searchRec(nums, 0, nums.length - 1, target));
    }

    public static int searchRec(int[] nums, int low, int high, int target) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (nums[mid] < target) {
            return searchRec(nums, mid + 1, nums.length - 1, target);
        } else if (nums[mid] == target) {
            return mid;
        } else {
            return searchRec(nums, 0, mid, target);
        }
        // return -1;
    }

    public static int search(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                high = mid - 1;
            } else if (nums[mid] == target) {
                System.gc();// reduces teh space complexity
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            }
        }
        return -1;

    }
}
