package Recursion;

public class BacktrackRecursion {
    public static void main(String args[]) {
        int n = 5;
        recur(1, n);
    }

    public static void recur(int i, int n) {
        if (i > n) {
            return;
        }

        recur(i + 1, n);
        System.out.print(" " + i + " ");

    }
}
