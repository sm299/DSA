package Recursion;

import java.util.ArrayList;
import java.util.List;

public class SubsetSum2 {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 2 };
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generateSub(arr, finalList, list, 0);
        System.out.println(finalList);
        finalList = new ArrayList<>();
        generateSubOA(arr, finalList, new ArrayList<>(), 0);
        System.out.println(finalList);
    }

    public static void generateSub(int[] arr, List<List<Integer>> finaList, List<Integer> list, int ind) {
        if (ind == arr.length) {
            if (!finaList.contains(list)) {
                finaList.add(new ArrayList<>(list));
            }
            return;
        }

        list.add(arr[ind]);
        generateSub(arr, finaList, list, ind + 1);

        list.remove(list.size() - 1);
        generateSub(arr, finaList, list, ind + 1);

    }

    public static void generateSubOA(int[] arr, List<List<Integer>> finalList, List<Integer> list, int ind) {
        // if (ind == arr.length) {
        finalList.add(new ArrayList<>(list));
        // return;
        // }

        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1])
                continue;

            list.add(arr[i]);
            generateSubOA(arr, finalList, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
