package Recursion;

public class Power {
    public static void main(String[] args) {
        int n = -5;
        int x = 2;
        System.out.println(power(x, n));
    }

    public static double power(int x, int n) {
        double result = 1;

        long nn = n;
        if (n < 0) {
            nn = (long) (-1) * (n);
        }
        while (nn > 0) {
            if (nn % 2 == 0) {
                x = x * x;
                nn = nn / 2;
            } else {
                result = result * x;
                nn = nn - 1;
            }
        }
        if (n < 0) {
            return 1 / result;
        } else {
            return result;
        }
    }

}
