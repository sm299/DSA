package Arrays;

import java.util.ArrayList;
import java.util.List;

public class Leader {
    public static void main(String[] args) {
        int[] nums = { 1, 5, 22, 12, 7, 9, 0, 6 };
        List<Integer> result = leader(nums);
        System.out.println(result);
    }

    public static List<Integer> leader(int[] arr) {
        int temp=Integer.MIN_VALUE;
        List<Integer> result = new ArrayList<>();
        if (arr == null || arr.length == 0) {
            return result;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if ( arr[i] > temp) {
                result.add(arr[i]);
                temp = arr[i];
            }
        }
        return result;
    }

}
