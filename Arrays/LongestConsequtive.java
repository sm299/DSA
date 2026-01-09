package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LongestConsequtive {
    public static void main(String[] args) {
        int[] arr = { 102, 4, 100, 1, 101, 2, 3, 1, 1 };
        longestConsequtiveBF(arr);
        longestConsequtiveOA(arr);
    }

    public static void longestConsequtiveBF(int[] arr) {
        Arrays.sort(arr);
        //System.out.println(Arrays.toString(arr));
        int size = 1;
        int finalSize = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                continue;
            } else if (arr[i] - arr[i - 1] == 1) {
                size++;
            } else {
                size = 1;
            }
            finalSize = Math.max(finalSize, size);
        }
        System.out.println(finalSize);
    }

    public static void longestConsequtiveOA(int[] arr) {
        if (arr == null || arr.length == 0) return;

        Set<Integer> set = new HashSet<>();
        for (int num : arr)
            set.add(num);
        int finalSize = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int curr = num;
                while (set.contains(curr + 1)) {
                    count++;
                    curr++;
                }
                finalSize = Math.max(count, finalSize);
            }

        }
        System.out.println(finalSize);
    }
}
