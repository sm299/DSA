package Patern;

public class halfDiamondPattern {
    public static void main(String[] args) {
        int n = 5;
        pattern(n);
    }

    public static void pattern(int n) {
        int num;
        for (int i = 0; i <= 2 * n - 1; i++) {
            num = i;
            if (i > n)
                num = 2 * n - i;
            for (int j = 0; j <= num; j++)
                System.out.print("*");

            System.out.println();
        }
        // for (int i = n - 1; i >= 0; i--) {
        // for (int j = i; j > 0; j--)
        // System.out.print("*");

        // System.out.println();
        // }
    }
}
