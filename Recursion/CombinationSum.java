package Recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] arr = { 2, 3, 6, 7 };
        List<Integer> list = new ArrayList<>();
        generate(arr, list, 7, 0, 0);
    }

    public static void generate(int[] arr, List<Integer> list, int sum, int temp, int itr) {
        // if (itr < arr.length) {
        if (sum == temp) {
            System.out.println(list);
            return;
        }
        if (itr == arr.length || temp > sum) {
            return;
        }

        list.add(arr[itr]);
        temp = temp + arr[itr];
        generate(arr, list, sum, temp, itr);
        list.remove(list.size() - 1);
        temp = temp - arr[itr];
        itr = itr + 1;
        generate(arr, list, sum, temp, itr);
    }
}
