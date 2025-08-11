package Arrays;

import java.util.ArrayList;
import java.util.List;

//this is when negative and positives are equal in size
//when either of them is longer , in that case only BF we will use and will go for an if else
// block and if negatives are 2 and positives are 6, we will go till 4 normally then will go for the rest
public class RearrangeElements {
    public static void main(String[] args) {
        int arr[] = { 3, -1, -2, -5, 2, 4 };
        rearrange(arr);
        System.out.println();
        rearrBF(arr);// TC->O(n)+O(n/2); SC->O(n)
        System.out.println();
        int arr1[] = { 3, -1, -2, -5, 2, 4 };
        rearrOA(arr1);// TC->O(n); SC->O(n)

    }

    public static void rearrange(int[] nums) {
        int temp;
        int n = nums.length;
        int i = 0;
        while (i < n - 1) {
            if (i % 2 == 0 && nums[i] < 0) {
                temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;

            } else if (i % 2 != 0 && nums[i] > 0) {
                temp = nums[i + 1];
                nums[i + 1] = nums[i];
                nums[i] = temp;

            }
            i++;

        }
        System.out.println("Test case : ");
        for (int j : nums) {
            System.out.print(j + " ");
        }
    }

    public static void rearrBF(int[] nums) {
        int n = nums.length;
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                pos.add(nums[i]);
            } else {
                neg.add(nums[i]);
            }
        }

        for (int i = 0; i < n / 2; i++) {
            nums[2 * i] = pos.get(i);
            nums[2 * i + 1] = neg.get(i);
        }
        System.out.println("BF : ");
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }

    public static void rearrOA(int[] nums) {
        int n = nums.length;
        int j = 0;
        int k = 1;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result[j] = nums[i];
                j = j + 2;
            } else if (nums[i] < 0) {
                result[k] = nums[i];
                k = k + 2;
            }
        }
        System.out.println("OA : ");

        for (int i : result) {
            System.out.print(i + " ");
        }
    }

}
