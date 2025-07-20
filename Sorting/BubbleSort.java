package Sorting;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        // int min = 0;
        int temp = 0;
        for (int i = arr.length - 1; i >= 1; i--) {
            // min = i;
            int didSwap = 0;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // min = j;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    didSwap = 1;
                }
            }
            if (didSwap == 0) {
                break;
            }

        }
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
