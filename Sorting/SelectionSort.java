package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        selectionSort(arr);
    }

    public static void selectionSort(int[] arr) {
        int min = 0;
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            min = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
