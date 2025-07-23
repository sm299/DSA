package Sorting;

public class BubbleSortRecursion {
    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        bubbleSort(arr, arr.length);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void bubbleSort(int[] arr, int n) {
        int didSwap = 0;
        for (int j = 0; j < n - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j + 1];
                arr[j + 1] = arr[j];
                arr[j] = temp;
                didSwap = 1;
            }
        }
        n--;
        if (didSwap == 0)
            return;
        bubbleSort(arr, n);
    }
}
