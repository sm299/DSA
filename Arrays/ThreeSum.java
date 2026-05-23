package Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = { -1, 0, 2, -1, 4, 2, -2, -3 };
        threeSumBF(arr);
        threeSumBA(arr);
        threeSumOA(arr);
    }

    private static void threeSumOA(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> list = new ArrayList<>();
        int j;
        int k;
        for (int i = 0; i < arr.length - 1; i++) {
            if (i > 0 && arr[i] == arr[i - 1])
                continue; // skip duplicates

            k = arr.length - 1;
            j = i + 1;
            while (j < k) {
                if (arr[i] + arr[j] + arr[k] > 0) {
                    k--;
                } else if (arr[i] + arr[j] + arr[k] < 0) {
                    j++;
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(arr[k]);
                    list.add(temp);
                    j++;
                    k--;

                    while (j < k && arr[j] == arr[j - 1]) {
                        j++;
                    }
                    while (j < k && arr[k] == arr[k + 1]) {
                        k--;
                    }
                }
            }
        }
        System.out.println("Optimal" + list);
    }

    private static void threeSumBA(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            int j = i + 1;
            while (j < arr.length) {
                if (list.contains(0 - (arr[i] + arr[j]))) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(arr[i]);
                    temp.add(arr[j]);
                    temp.add(0 - (arr[i] + arr[j]));
                    Collections.sort(temp);
                    set.add(temp);
                } else {
                    list.add(arr[j]);
                }
                j++;
            }
            list.clear();
        }
        System.out.println("Better" + set);
    }

    private static void threeSumBF(int[] arr) {

        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> listTemp = new ArrayList<>();
                        listTemp.add(arr[j]);
                        listTemp.add(arr[k]);
                        listTemp.add(arr[i]);
                        Collections.sort(listTemp);
                        set.add(listTemp);
                    }
                }
            }
        }
        // List<List<Integer>> list = new ArrayList<>(set);
        System.out.println("BruteForce" + set);
    }
}
