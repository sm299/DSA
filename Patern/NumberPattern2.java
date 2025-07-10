package Patern;

/*
 * 4444444
 * 4333334
 * 4322234
 * 4321234
 * 4322234
 * 4333334
 * 4444444
 */
public class NumberPattern2 {
    public static void main(String[] args) {
        int n = 4;
        // pattern(n);
        patternDiffApproach(n);
    }

    public static void pattern(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(n - Math.min(i, j));
            }
            for (int j = n - 2; j >= 0; j--) {
                System.out.print(n - Math.min(i, j));
            }
            System.out.println();
        }
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                System.out.print(n - Math.min(i, j));
            }
            for (int j = n - 2; j >= 0; j--) {
                System.out.print(n - Math.min(i, j));
            }
            System.out.println();
        }

    }

    public static void patternDiffApproach(int n) {
        for (int i = 0; i < 2 * n - 1; i++) {
            for (int j = 0; j < 2 * n - 1; j++) {
                System.out.print(n - Math.min(Math.min(i, j), Math.min((2 * n - 1) - i - 1, (2 * n - 1) - j - 1)));
            }
            System.out.println();
        }
    }
}
