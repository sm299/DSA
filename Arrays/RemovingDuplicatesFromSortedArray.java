package Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemovingDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = { 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5 };
        arr = removeDuplicatesBruteForce(arr);
        System.out.println("BruteForce: ");// tc->O(nlogn+n); sc->O(n)
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        int[] arr1 = { 1, 1, 2, 2, 3, 3, 3, 4, 4, 4, 5 };
        arr1 = removeDuplicatesOptimal(arr1);
        System.out.println("Optimal: ");
        for (int i : arr1) {
            System.out.print(i + " ");
        }
    }

    public static int[] removeDuplicatesBruteForce(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int n = 0;
        for (int i : arr) {
            set.add(i);
        }
        for (int i : set) {
            arr[n] = i;
            n++;
        }
        return Arrays.copyOfRange(arr, 0, n);
    }

    public static int[] removeDuplicatesOptimal(int[] arr) {
        int n = 1;
        int fp = arr[0];
        int sp = arr[1];
        for (int i = 1; i < arr.length; i++) {

            sp = arr[i];
            if (fp != sp) {
                arr[n] = sp;
                fp = sp;

                n++;
            }
        }

        return Arrays.copyOfRange(arr, 0, n);
    }
}
