package Recursion;

import java.util.ArrayList;
import java.util.List;

public class Subsequences {
    public static void main(String args[]) {
        int[] arr = { 3, 1, 2 };
        int n = arr.length;
        List<Integer> list = new ArrayList<>();
        subseq(0, list, arr, n);
    }

    public static void subseq(int i, List<Integer> list, int[] arr, int n) {

        if (i >= n) {
            System.out.println(list);
            return;
        }
        list.add(arr[i]);
        subseq(i + 1, list, arr, n);
        list.remove(list.size() - 1);
        subseq(i + 1, list, arr, n);
    }
}
