package Recursion;

import java.util.Arrays;

/* The frequency of an element is the number of times it occurs in an array.

You are given an integer array nums and an integer k. In one operation, you can choose an index of nums and increment the element at that index by 1.

Return the maximum possible frequency of an element after performing at most k operations.

 

Example 1:

Input: nums = [1,2,4], k = 5
Output: 3
Explanation: Increment the first element three times and the second element two times to make nums = [4,4,4].
4 has a frequency of 3. */

public class MaxFreq {
    public static void main(String args[]) {
        int arr1[] = { 1, 2, 4 };
        int arr2[] = { 1, 4, 8, 13 };
        int arr3[] = { 3, 9, 6 };
        int k = 5;
        maxFreq(arr1, k);
        maxFreq(arr2, k);
        maxFreq(arr3, k);

    }

    public static void maxFreq(int[] nums, int k) {
        Arrays.sort(nums);
        int left = 0;
        long total = 0;
        int max = 1;

        for (int right = 1; right < nums.length; right++) {
            // Total increments to make all elements from left to right equal to nums[right]
            total += (long) (nums[right] - nums[right - 1]) * (right - left);

            // Shrink the window if total cost > k
            while (total > k) {
                total -= nums[right] - nums[left];
                left++;
            }

            max = Math.max(max, right - left + 1);
        }

        System.out.println(max);
    }
}
