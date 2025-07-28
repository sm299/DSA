package Arrays;

public class IfArraySorted {
    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 5, 2, 7, 7 };
        int[] arr1 = { 1, 2, 4, 6, 7, 9 };
        System.out.println(ifSorted(arr));
        System.out.println(ifSorted(arr1));
    }

    public static boolean ifSorted(int[] arr) {
        boolean ifArraySorted = false;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] <= arr[i + 1]) {
                ifArraySorted = true;
            } else {
                return false;
            }
        }
        return ifArraySorted;
    }
}
