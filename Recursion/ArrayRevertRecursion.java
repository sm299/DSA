package Recursion;

public class ArrayRevertRecursion {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6 };
        revert(0, arr, arr.length);
        for (int a : arr) {
            System.out.print(" " + a);
        }
    }

    public static void revert(int i, int[] arr, int n) {
        if (i > n / 2)
            return;

        int temp = arr[i];
        arr[i] = arr[n - i - 1];
        arr[n - i - 1] = temp;

        revert(i + 1, arr, n);
    }
}