package Arrays;

public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = { 1, 1, 0, 0, 1, 1, 1, 0, 0, 1 };
        maxConsOnes(nums);
    }

    public static void maxConsOnes(int[] nums) {
        int max = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            if (sum > max) {
                max = sum;
            }
            if (nums[i] == 0) {
                sum = 0;
            }
        }

        System.out.println("max consecutive ones : " + max);
    }
}
