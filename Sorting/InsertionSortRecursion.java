package Sorting;

public class InsertionSortRecursion {
    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        insertionSort(arr, 0);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void insertionSort(int[] arr, int n) {
        if (n == arr.length)
            return;
        int j = n;
        while (j > 0 && arr[j - 1] > arr[j]) {
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }
        n++;
        insertionSort(arr, n);
    }
}
