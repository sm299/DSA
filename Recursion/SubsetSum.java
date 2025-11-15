package Recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SubsetSum {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1 };
        List<Integer> list = new ArrayList<>();
        generateSumBF(arr, list, 0, 0, 0, 0);
        Collections.sort(list);
        System.out.println(list);
        list = new ArrayList<>();
        generateSumPnP(arr, list, 0, 0);
        Collections.sort(list);
        System.out.println(list);
    }

    public static void generateSumPnP(int[] arr, List<Integer> list, int ind, int sum) {
        if (ind == arr.length) {
            list.add(sum);
            return;
        }
        generateSumPnP(arr, list, ind + 1, sum + arr[ind]);
        generateSumPnP(arr, list, ind + 1, sum);
    }

    public static void generateSumBF(int[] arr, List<Integer> list, int start, int end, int ind, int sum) {
        list.add(sum);
        // for (int i = 0; i < arr.length; i++) {
        // sum = 0;
        // for (int j = i; j < arr.length; j++) {
        if (start == arr.length) {
            return;
        }

        sum = 0;
        for (int k = start; k <= end; k++) {
            sum = sum + arr[k];
        }
        // list.add(sum);
        end = end + 1;
        if (end == arr.length) {
            start = start + 1;
            end = start;
        }
        generateSumBF(arr, list, start, end, ind, sum);
    }

}
