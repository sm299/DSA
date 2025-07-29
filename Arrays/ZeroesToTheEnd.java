package Arrays;

import java.util.ArrayList;
import java.util.List;

public class ZeroesToTheEnd {
    public static void main(String[] args) {
        int[] arr = { 1, 0, 2, 3, 4, 0, 0, 0, 7, 8, 5, 0, 0, 6, 0 };
        System.out.println("BF : ");
        zeroesToTheEndBF(arr); // TC-> O(n)+O(n-x)+O(x)->O(2n) ; SC->O(x)
        System.out.println();

        int[] arr1 = { 4, 2, 4, 0, 0, 3, 0, 5, 1, 0 };
        System.out.println("OA : ");
        zeroesToTheEndOA(arr1);
    }

    public static void zeroesToTheEndBF(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int i : arr) {
            if (i != 0) {
                list.add(i);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        for (int i = list.size(); i < arr.length; i++) {
            arr[i] = 0;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void zeroesToTheEndOA(int[] arr) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j = i;
                break;
            }
        }
        if (j == -1)
            return;
        for (int i = j + 1; i < arr.length; i++) {
            if (arr[i] != 0) {
                arr[j] = arr[i];
                arr[i] = 0;
                j++;
            }
        }

        for (int k : arr) {
            System.out.print(k + " ");
        }

    }
}
