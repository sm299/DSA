package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] arr = { 10, 1, 2, 7, 6, 5, 1, 1, 1 };
        Arrays.sort(arr);
        int target = 8;
        List<List<Integer>> finalList = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        generate(arr, finalList, list, target, 0, 0);
        System.out.println(finalList);
        finalList = new ArrayList<>();
        // list = new ArrayList<>();
        generateOA(arr, finalList, new ArrayList<>(), target, 0);
        System.out.println(finalList);
    }

    public static void generate(int[] arr, List<List<Integer>> finalList, List<Integer> list, int target, int sum,
            int itr) {
        if (itr == arr.length) {
            if (sum == target) {
                // Collections.sort(list);
                if (!finalList.contains(list)) {
                    finalList.add(new ArrayList<>(list));
                    return;
                }
            }
            return;
        }
        list.add(arr[itr]);
        sum = sum + arr[itr];
        generate(arr, finalList, list, target, sum, itr + 1);
        sum -= arr[itr];
        list.remove(list.size() - 1);
        generate(arr, finalList, list, target, sum, itr + 1);
    }

    public static void generateOA(int[] arr, List<List<Integer>> finalList, List<Integer> list, int target, int itr) {
        if (target == 0) {
            finalList.add(new ArrayList<>(list));
            return;
        }
        for (int i = itr; i < arr.length; i++) {
            if (i > itr && arr[i] == arr[i - 1])
                continue;
            if (arr[i] > target)
                break;

            list.add(arr[i]);
            generateOA(arr, finalList, list, target - arr[i], i + 1);
            list.remove(list.size() - 1);
        }
    }
}
