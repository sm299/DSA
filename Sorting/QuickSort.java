package Sorting;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        int place = 0;
        if (low < high) {
            place = pivotPlaceSelector(arr, low, high);
            quickSort(arr, low, place - 1);
            quickSort(arr, place + 1, high);
        }
    }

    public static int pivotPlaceSelector(int[] arr, int low, int high) {
        int pivot = low;
        int i = low;
        int j = high;
        while (i < j) {
            while (arr[i] <= arr[pivot] && i < high) {
                i++;
            }
            while (arr[j] > arr[pivot] && j > low) {
                j--;
            }
            if (i < j) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

            int temp = arr[j];
            arr[j] = arr[pivot];
            arr[pivot] = temp;
        }
        return j;
    }
}
