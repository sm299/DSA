package Patern;

/*
 * 1      1
 * 12    21
 * 123  321
 * 12344321
 */

public class NumberPattern1 {
    public static void main(String[] args) {
        int n = 4;
        pattern(n);
    }

    public static void pattern(int n) {
        int space = 2 * n - 2;
        for (int i = 0; i < n; i++) {
            // numbers
            for (int j = 1; j <= i + 1; j++) {
                System.out.print(j);
            }
            // spaces
            for (int j = space; j >= 0; j--) {
                System.out.print(" ");
            }

            // numbers
            for (int j = i + 1; j >= 1; j--) {
                System.out.print(j);
            }

            System.out.println();
            space = space - 2;
        }
    }
}
