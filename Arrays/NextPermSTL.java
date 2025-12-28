package Arrays;

import java.util.Arrays;

public class NextPermSTL {
    public static void main(String[] args) {
        //int[] arr = { 2, 1, 5, 4, 3, 0, 0 };
        int[] arr = { 1, 3, 2 };
        nextPerm(arr);
        System.out.println("next of Input"+Arrays.toString(arr));
        nextPermutation(arr);
        System.out.println("next of previous Output"+Arrays.toString(arr));
    }

    public static void nextPerm(int[] arr) {
        //int num = 0;
        boolean ifLast = true;

        for (int i = arr.length - 2; i >= 0; i--) {
            if (arr[i] < arr[i + 1]) {
                swap(arr, i);
                ifLast = false;
                break;
            }
        }
        if (ifLast) {
            Arrays.sort(arr);
        }
    }

    public static void swap(int[] arr, int j) {
        //int temp=arr[j];
        int pivot = -1;
        for (int i = arr.length - 1; i > j; i--) {
            if (arr[j] < arr[i]) {
                pivot = i;
                break;
            }
        }

        int temp = arr[j];
        arr[j] = arr[pivot];
        arr[pivot] = temp;

        Arrays.sort(arr, j + 1, arr.length);
    }

    //class Solution {
        public static void nextPermutation(int[] nums) {
            int n = nums.length;
            int i = n - 2;

            // Step 1: find first decreasing element
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }

            // Step 2: find element just larger and swap
            if (i >= 0) {
                int j = n - 1;
                while (nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }

            // Step 3: reverse the suffix
            reverse(nums, i + 1, n - 1);
        }

        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        private static void reverse(int[] nums, int left, int right) {
            while (left < right) {
                swap(nums, left++, right--);
            }
        }
   // }
}


