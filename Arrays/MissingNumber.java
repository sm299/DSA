package Arrays;

/* Given an array nums containing n distinct numbers in the range [0, n], 
return the only number in the range that is missing from the array.
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = { 3, 0, 1 };
        int n = 3;
        missingNumBA(nums, n);// tc->O(2n), sc->O(n)
        missingNumOASum(nums, n);
        missingNumOAXor(nums, n);
    }

    public static void missingNumBA(int[] nums, int n) {
        int[] hashArr = new int[n + 1];
        int result = -1;
        for (int i : nums) {
            hashArr[i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            if (hashArr[i] == 0) {
                result = i;
                break;
            }
        }
        if (result == -1)
            System.out.println("All are there");
        else
            System.out.println("In BA : " + result);
    }

    public static void missingNumOASum(int[] nums, int n) {

        int result = 0;
        int sum1 = n * (n + 1) / 2;
        int sum2 = 0;
        for (int i : nums) {
            sum2 = sum2 + i;
        }
        result = sum1 - sum2;
        if (result == 0)
            System.out.println("All are there");
        else
            System.out.println("In OA sum : " + result);
    }

    public static void missingNumOAXor(int[] nums, int n) {
        int result = 0;
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < nums.length; i++) {
            xor1 = xor1 ^ (i + 1);
            xor2 = xor2 ^ nums[i];
        }
        result = xor1 ^ xor2;
        if (result == 0)
            System.out.println("All are there");
        else
            System.out.println("In OA xor : " + result);
    }
}
