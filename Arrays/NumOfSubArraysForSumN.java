package Arrays;

import java.util.HashMap;
import java.util.Map;

public class NumOfSubArraysForSumN {
    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, -3, 4, -1, 5, -5, 0 };
        int k = 3;
        subArrayBF(nums, k);
        subArrayBA(nums, k);
        subArrayOA(nums, k);
    }

    private static void subArrayOA(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(sum, 1);
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);

        }
        System.out.println(count);
    }

    private static void subArrayBA(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            sum = 0;
            for (int j = i; j < n; j++) {
                sum = sum + nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void subArrayBF(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sum = 0;
                for (int l = i; l <= j; l++) {
                    sum = sum + nums[l];
                }
                if (sum == k) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
