package Patern;

public class DiamondPattern {
    public static void main(String[] args) {
        int n = 5;
        pattern(n);
    }

    public static void pattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                System.out.print("*");
            }
            for (int j = 0; j < (n - i - 1); j++) {
                System.out.print(" ");
            }
            System.out.println();
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = (n - i - 1); j > 0; j--) {
                System.out.print(" ");
            }
            for (int j = 2 * i - 1; j > 0; j--) {
                System.out.print("*");
            }
            for (int j = (n - i - 1); j > 0; j--) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}
