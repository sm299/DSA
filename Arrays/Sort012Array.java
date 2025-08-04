package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Sort012Array {
    public static void main(String[] args) {
        int[] nums = { 0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort012ArrayBF(nums, 0, nums.length - 1);// TC-> O(nlogn); SC->O(1)
        System.out.println("BF : ");
        for (int i : nums) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] nums1 = { 0, 1, 2, 0, 1, 2, 1, 2, 0, 0, 0, 1 };
        sort012ArrayBA(nums1);// TC-> O(2n); SC->O(1)
        System.out.println();
        sort012ArrayOA(nums1);// TC->O(n);SC->O(1)
        // sort012ArrayOA(new int[] { 2, 0, 1 });
    }

    public static void sort012ArrayBF(int[] nums, int low, int high) {
        if (low == high)
            return;
        int mid = (high + low) / 2;
        sort012ArrayBF(nums, low, mid);
        sort012ArrayBF(nums, mid + 1, high);
        merge(nums, low, mid, high);

    }

    public static void merge(int[] nums, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                list.add(nums[left]);
                left++;
            } else {
                list.add(nums[right]);
                right++;
            }
        }

        while (left <= mid) {
            list.add(nums[left]);
            left++;
        }
        while (right <= high) {
            list.add(nums[right]);
            right++;
        }
        for (int i = low; i <= high; i++) {
            nums[i] = list.get(i - low);
        }

    }

    public static void sort012ArrayBA(int[] nums) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;
        int j = 0;
        for (int i : nums) {
            if (i == 0) {
                count0++;
            } else if (i == 1) {
                count1++;
            } else {
                count2++;
            }
        }

        for (int i = 0; i < count0; i++) {
            nums[j] = 0;
            j++;
        }
        for (int i = 0; i < count1; i++) {
            nums[j] = 1;
            j++;
        }
        for (int i = 0; i < count2; i++) {
            nums[j] = 2;
            j++;
        }
        System.out.println("BA : ");
        for (int i : nums) {
            System.out.print(i + " ");
        }

    }

    public static void sort012ArrayOA(int[] nums) { // dutch national flag algo
        int low = 0;
        int mid = 0;
        int high = nums.length - 1;
        int temp;
        while (mid <= high) {
            if (nums[mid] == 0) {
                temp = nums[mid];
                nums[mid] = nums[low];
                nums[low] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else if (nums[mid] == 2) {
                temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                high--;
            }
        }
        System.out.println("OA : ");
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
