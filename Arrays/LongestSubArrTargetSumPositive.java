package Arrays;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrTargetSumPositive {
    static int target = 6;

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 1, 1, 0, 0, 4, 2, 3 };
        subArrBFo(nums);
        subArrBF(nums);
        subArrBA(nums);
        subArrOA(nums);

        int[] nums1 = { 1, 2, 3, 1, 1, 0, 0, 4, -1, -1, 2, 3 };
        subArrBF(nums1);
    }

    public static void subArrBFo(int[] nums) {
        int sum = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum == target) {
                    length = Math.max(length, j - i + 1);

                }
            }
        }
        System.out.println("Bfo : " + length);
    }

    public static void subArrBF(int[] nums) {
        int sum = 0;
        int length = 0;
        int j = 0;
        // List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
            // list.add(nums[i]);
            if (sum > target) {
                sum = sum - nums[j];
                // list.remove(nums[j]);
                j++;
                if (length < i - j + 1) {
                    length = i - j + 1;
                }
            }
        }
        System.out.println("BF : " + length);

    }

    public static void subArrBA(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer sum = 0;
        int length = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum == target) {
                length = Math.max(length, i + 1);
            }
            int rem = sum - target;
            if (map.containsKey(rem)) {
                int len = i - map.get(rem);
                length = Math.max(len, length);
            } else {
                map.put(sum, i);
            }
        }
        System.out.println("BA : " + length);
    }

    public static void subArrOA(int[] nums) {
        // String s = "madam";

        // System.out
        // .println(IntStream.range(0, s.length() / 2).allMatch(i -> s.charAt(i) ==
        // s.charAt(s.length() - 1 - i)));

    }
}
