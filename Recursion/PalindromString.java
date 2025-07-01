package Recursion;

public class PalindromString {
    public static void main(String[] args) {
        String s = "madam";
        String[] arr = s.split("");
        if (check(arr, 0)) {
            System.out.println("Palindrom");
        } else {
            System.out.println("not Palindrom");
        }
    }

    public static boolean check(String[] arr, int i) {
        if (i > arr.length / 2) {
            return true;
        }
        if (!arr[i].equals(arr[arr.length - 1 - i])) {
            return false;
        }
        return check(arr, i + 1);
    }
}
