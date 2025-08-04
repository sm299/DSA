package Arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = { 2, 6, 5, 8, 11 };
        int target = 14;
        twoSumBF(nums, target);// TC->O(n2); SC->O(1)
        twoSumBA(nums, target);// TC->O(nlogn); SC->O(n)
        twoSumOA(nums, target);
    }

    public static void twoSumBF(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    System.out.println("BF : indexes-> " + i + " , " + j);
                    return;
                }
            }
        }
    }

    public static void twoSumBA(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {

            if (map.keySet().contains(target - nums[i])) {
                System.out.println("BA : indexes-> " + map.get(target - nums[i]) + " , " + i);
            }
            map.put(nums[i], i);
        }
    }

    // not optimal if indexes were asked
    public static void twoSumOA(int[] nums, int target) {
        int j = 0;
        int i = nums.length - 1;
        boolean isPresent = false;
        for (int k = 0; k < nums.length; k++) {
            int l = k;
            while (k > 0 && nums[k - 1] > nums[k]) {
                int temp = nums[k];
                nums[k] = nums[k - 1];
                nums[k - 1] = temp;
            }
        }

        while (i >= j && j <= i) {
            if (nums[i] + nums[j] == target) {
                isPresent = true;
                break;
            } else if (nums[i] + nums[j] > target) {
                i--;
            } else if (nums[i] + nums[j] < target) {
                j++;
            }

        }
        System.out.println("Is Two Sum Possible : " + isPresent);
    }
}
