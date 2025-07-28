package Arrays;

import java.util.Arrays;

// right rotation= arraylength -left rotation
public class LeftRotate {
    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        int k = 3;
        leftRotateBF(arr, k);
        System.out.println("BruteForce : "); // TC = O(n) ->(O(k) + O(n - k) + O(n - k)=O(n)) //SC-> O(k)
        for (int i : arr) {
            System.out.print(i + " ");
        }

        int arr1[] = { 1, 2, 3, 4, 5 };
        leftRotateBA(arr1, k);
        System.out.println();
        System.out.println("BetterApproach : "); // TC-> O(n); SC-> O(k)
        for (int i : arr1) {
            System.out.print(i + " ");
        }

        int arr2[] = { 1, 2, 3, 4, 5 };
        leftRotateOA(arr2, k);
        System.out.println();
        System.out.println("OptimalApproach : ");// TC-> O(2n), SC-> O(1)
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }

    public static int[] leftRotateBF(int[] arr, int k) {
        k = k % arr.length;
        int[] temp = new int[k];
        int j = 0;
        temp = Arrays.copyOfRange(arr, 0, k);
        for (int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }

        for (int i = k - 1; i < arr.length; i++) {
            arr[i] = temp[j];
            j++;
        }
        return arr;
    }

    public static int[] leftRotateBA(int[] arr, int k) {
        k = k % arr.length;
        int[] temp = new int[k];
        // int j = 0;
        temp = Arrays.copyOfRange(arr, 0, k);
        for (int i = k; i < arr.length; i++) {
            arr[i - k] = arr[i];
        }

        for (int i = k - 1; i < arr.length; i++) {
            arr[i] = temp[i - (arr.length - k)];
        }
        return arr;
    }

    public static int[] leftRotateOA(int[] arr, int k) {
        k = k % arr.length;
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
        return arr;
    }

    public static int[] reverse(int[] arr, int f, int l) {
        while (f < l) {
            int temp = arr[f];
            arr[f] = arr[l];
            arr[l] = temp;
            f++;
            l--;
        }
        return arr;
    }
}
