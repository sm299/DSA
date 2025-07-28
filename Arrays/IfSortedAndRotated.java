package Arrays;
/* Given an array nums, return true if the array was originally sorted in non-decreasing order, then rotated some number of positions (including zero). Otherwise, return false.

There may be duplicates in the original array.

Note: An array A rotated by x positions results in an array B of the same length such that B[i] == A[(i+x) % A.length] for every valid index i.

 

Example 1:

Input: nums = [3,4,5,1,2]
Output: true
Explanation: [1,2,3,4,5] is the original sorted array.
You can rotate the array by x = 3 positions to begin on the element of value 3: [3,4,5,1,2].
Example 2:

Input: nums = [2,1,3,4]
Output: false
Explanation: There is no sorted array once rotated that can make nums.
 */

public class IfSortedAndRotated {
    public static void main(String[] args) {
        int[] nums = { 3, 4, 5, 1, 2 };
        System.out.println(check(nums));

    }

    public static boolean check(int[] nums) {
        int n = 0;
        for (int i = 0; i < nums.length; i++) {
            int next = (i + 1) % nums.length;
            if (nums[i] > nums[next]) {
                n++;
            }
        }
        return n <= 1;
    }
}
