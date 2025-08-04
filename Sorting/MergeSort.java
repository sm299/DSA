package Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = { 13, 46, 24, 52, 20, 9 };
        int low = 0;
        int high = arr.length - 1;
        mergeSort(arr, low, high);
        for (int i = low; i <= high; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (low == high)
            return;
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, mid, high);

    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        List<Integer> arrTemp = new ArrayList<>();
        // int count = 0;
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                arrTemp.add(arr[left]);
                // count++;
                left++;
            } else {
                arrTemp.add(arr[right]);
                // count++;
                right++;
            }
        }
        while (left <= mid) {
            arrTemp.add(arr[left]);
            // count++;
            left++;
        }
        while (right <= high) {
            arrTemp.add(arr[right]);
            // count++;
            right++;
        }
        for (int i = low; i <= high; i++) {
            arr[i] = arrTemp.get(i - low);
        }

    }
}
