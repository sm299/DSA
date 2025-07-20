package Sorting;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        insertionSort(arr);
    }

    public static void insertionSort(int[] arr) {

        for (int i = 0; i <= arr.length - 1; i++) {
            int j = i;
            int temp = 0;
            while (j > 0 && arr[j - 1] > arr[j]) {
                temp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = temp;
                j--;
            }
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
