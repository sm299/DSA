package Recursion;

/* Step 1: Count how many even and odd positions

If n = 1:

Only index 0 exists → 5 possibilities.

In general:

Number of even positions = (n + 1) / 2 (integer division ceiling).

Number of odd positions = n / 2.

Step 2: Formula
answer=(5^even positions×4^odd positions)mod(10^9+7)

Step 3: Efficient Computation

Since n can be large (up to 10¹⁵ in some versions of the problem), we must use fast modular exponentiation (a.k.a. binary exponentiation). */

public class GoodNmbrs {
    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        int result = countGoodNumbers(Long.valueOf(4));
        System.out.println(result);
    }

    public static int countGoodNumbers(long n) {
        long evenPos = (n + 1) / 2;
        long oddPos = n / 2;

        long ans = (pow(5, evenPos) * pow(4, oddPos)) % MOD;
        return (int) ans;
    }

    private static long pow(long base, long exp) {
        long result = 1;
        base = base % MOD;
        while (exp > 0) {

            if (exp % 2 == 1) {
                result = (result * base) % MOD;
            }

            base = (base * base) % MOD;

            exp = exp / 2;
        }
        return result;
    }
}
