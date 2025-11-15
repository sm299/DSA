package Recursion;

import java.util.ArrayList;
import java.util.List;

// public class FIxedSum {
//     public static void main(String[] args) {
//         int[] arr = { 1, 2, 1 };
//         int sum = 2;
//         List<Integer> list = new ArrayList<>();
//         generate(arr, list, sum, 0, 0);
//     }

//     public static boolean generate(int[] arr, List<Integer> list, int sum, int temp, int itr) {

//         if (itr == arr.length) {
//             if (sum == temp) {
//                 System.out.println(list);
//                 return true;
//             }
//             return false;
//         }
//         list.add(arr[itr]);
//         temp = temp + arr[itr];
//         if (generate(arr, list, sum, temp, itr + 1)) {
//             return true;
//         } // pick
//         list.remove(list.size() - 1);
//         temp -= arr[itr];
//         if (generate(arr, list, sum, temp, itr + 1)) {
//             return true;
//         } // not pick
//         return false;

//     }
// }
//if count is needed
public class FIxedSum {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 1 };
        int sum = 2;
        List<Integer> list = new ArrayList<>();
        System.out.println(generate(arr, list, sum, 0, 0));
    }

    public static int generate(int[] arr, List<Integer> list, int sum, int temp, int itr) {

        if (itr == arr.length) {
            if (sum == temp) {
                // System.out.println(list);//if I print this, this will give both the arrays
                return 1;
            }
            return 0;
        }
        list.add(arr[itr]);
        temp = temp + arr[itr];
        int l = generate(arr, list, sum, temp, itr + 1); // pick
        list.remove(list.size() - 1);
        temp -= arr[itr];
        int r = generate(arr, list, sum, temp, itr + 1); // not pick
        return l + r;

    }
}
