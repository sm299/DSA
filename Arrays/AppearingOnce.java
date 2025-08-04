package Arrays;

import java.util.HashMap;
import java.util.Map;

public class AppearingOnce {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 2, 3, 3, 4, 4, 5, 5 };
        appearingOnceBF(nums);// TC->
        appearingOnceBA(nums);
        appearingOnceOA(nums);
    }

    public static void appearingOnceBF(int[] nums) {
        int num;
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            num = nums[i];
            int count = 0;
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == num) {
                    count++;
                }
            }
            if (count == 1) {
                result = num;
            }
        }
        System.out.println("BF : " + result);
    }

    public static void appearingOnceBA(int[] nums) {
        int result = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                result = entry.getKey();
            }
        }
        System.out.println("BA : " + result);
    }

    public static void appearingOnceOA(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        System.out.println("OA : " + result);
    }
}
