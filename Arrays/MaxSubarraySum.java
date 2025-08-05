package Arrays;

public class MaxSubarraySum {
    public static void main(String[] args) {
        int[] nums = { -2, -3, 4, -1, -2, 1, 5, -3 };

        maxSubBF(nums);
        maxSubBA(nums);
        maxSubOA(nums);// Kadane's Algo
    }

    public static void maxSubBF(int[] nums) {
        int tempSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum = sum + nums[k];

                }
                tempSum = Math.max(sum, tempSum);
            }
        }
        System.out.println("BF : " + tempSum);
    }

    public static void maxSubBA(int[] nums) {
        int tempSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                tempSum = Math.max(tempSum, sum);
            }
        }
        System.out.println("BA : " + tempSum);
    }

    public static void maxSubOA(int[] nums) {
        int tempSum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum = sum + num;
            if (sum < 0) {
                sum = 0;
            }
            tempSum = Math.max(sum, tempSum);
        }
        System.out.println("OA : " + tempSum);
    }
}
