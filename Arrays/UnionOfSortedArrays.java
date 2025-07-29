package Arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UnionOfSortedArrays {
    public static void main(String[] args) {
        int nums1[] = { 1, 1, 2, 3, 4, 5 };
        int nums2[] = { 2, 3, 4, 4, 5, 6 };
        unionOfSortedArraysBF(nums1, nums2);// TC-> O(n1logn)+O(n2logn)+O(n1+n2) ; SC->O(n1+n2)(to solve)+O(n1+n2)(to
                                            // return)
        System.out.println();
        unionOfSortedArraysOA(nums1, nums2);// TC-> O(n1+n2) ; SC-> O(n1+n2)
    }

    public static void unionOfSortedArraysBF(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();

        for (int i : nums1) { // TC->O(n1logn)
            set.add(i);
        }
        for (int i : nums2) { // TC->O(n2logn)
            set.add(i);
        }
        System.out.println("BF : ");
        Integer[] unionNums = set.toArray(new Integer[0]);// TC->O(n1+n2)

        for (int i : unionNums) {
            System.out.print(i + " ");
        }
    }

    public static void unionOfSortedArraysOA(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        int n = 0;
        List<Integer> list = new ArrayList<>();
        while (i < n1 && j < n2) {
            if (nums1[i] <= nums2[j]) {
                if (list.isEmpty() || !list.contains(nums1[i])) {
                    list.add(nums1[i]);
                }
                i++;
            } else {
                if (list.isEmpty() || !list.contains(nums2[j])) {
                    list.add(nums2[j]);
                }
                j++;
            }
        }
        while (j < n2) {
            if (list.isEmpty() || !list.contains(nums2[j])) {
                list.add(nums2[j]);
            }
            j++;
        }

        while (i < n1) {
            if (list.isEmpty() || !list.contains(nums1[i])) {
                list.add(nums1[i]);
            }
            i++;
        }

        int[] unionNums = list.stream().mapToInt(Integer::intValue).toArray();
        System.out.println("OA : ");
        for (int k : unionNums) {
            System.out.print(k + " ");
        }
    }
}
