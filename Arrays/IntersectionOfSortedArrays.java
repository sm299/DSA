package Arrays;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfSortedArrays {
    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2, 2, 3, 3, 3, 4, 5 };
        int nums2[] = { 2, 3, 3, 4, 4, 5, 6 };
        intersectionOfSortedArraysBF(nums1, nums2);// TC-> O(n1*n2) ; SC->O(n2)
        System.out.println();
        intersectionOfSortedArraysOA(nums1, nums2);// TC-> O(n1+n2) ; SC-> O(1)
    }

    public static void intersectionOfSortedArraysBF(int[] nums1, int[] nums2) {
        int n = nums2.length;
        int m = nums1.length;
        int[] visited = new int[n];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j] && visited[j] == 0) {
                    list.add(nums1[i]);
                    visited[j] = 1;
                    break;
                }
                if (nums2[j] > nums1[i])
                    break;
            }
        }
        System.out.println("BF : ");
        for (int i : list) {
            System.out.print(i + " ");
        }

    }

    public static void intersectionOfSortedArraysOA(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int i = 0;
        int j = 0;
        List<Integer> list = new ArrayList<>();
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums2[j] < nums1[i]) {
                j++;
            } else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        System.out.println("OA : ");
        for (int k : list) {
            System.out.print(k + " ");
        }
    }
}
