package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsuquenceTargetSum {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 2, 4, 0, -1 };
        int sum = 4;
        int tempSum = 0;
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        subseqSum(0, tempSum, list, arr, n, sum);
    }

    public static void subseqSum(int i, int tempSum, List<Integer> list, int[] arr, int n, int sum) {

        if (i >= n) {
            // if (list.stream().collect(Collectors.summingInt(x -> x)) == sum)
            if (tempSum == sum)
                System.out.println(list);
            return;
        }
        list.add(arr[i]);
        tempSum = tempSum + arr[i];
        subseqSum(i + 1, tempSum, list, arr, n, sum);
        tempSum = tempSum - list.get(list.size() - 1);
        list.remove(list.size() - 1);
        subseqSum(i + 1, tempSum, list, arr, n, sum);
    }
}
