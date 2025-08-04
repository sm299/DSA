package Arrays;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = { 2, 2, 3, 3, 1, 2, 2 };
        majEleBA(nums);
        majEleOA(nums);// Moore's voting also
    }

    public static void majEleBA(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > nums.length / 2) {
                result = nums[i];
                break;
            }
        }
        if (result == 0) {
            System.out.println("None got majority");
        } else
            System.out.println("BA : Majority element -> " + result);
    }

    public static void majEleOA(int[] nums) {
        int count = 0;
        int element = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                element = nums[i];
                count = 1;
            } else if (nums[i] == element) {
                count++;
            } else if (nums[i] == element) {
                count--;
            }
        }
        count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) {
                count++;
            }
        }
        if (count > nums.length / 2) {
            System.out.println("OA : Majority element -> " + element);
        } else {
            System.out.println("None got majority");
        }
    }
}
