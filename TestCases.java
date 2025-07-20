import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class TestCases {
    public static void main(String[] args) {
        int n = 36;
        int m = 108;
        allDivisors(n);
        hcf(n, m);
        System.out.println(isArmstrong(153));
        palindrom("MADAM");
    }

    public static void allDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for (int i = 1; i * i < n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (i != n / i)
                    divisors.add(n / i);
            }
        }
        Collections.sort(divisors);
        System.out.println(divisors);
    }

    public static void hcf(int a, int b) {
        while (a != 0 && b != 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }

        }
        System.out.println(a > b ? a : b);
    }

    public static boolean isArmstrong(int num) {
        int original = num;
        int digits = String.valueOf(num).length();
        int sum = 0;

        while (num > 0) {
            int digit = num % 10;
            sum += Math.pow(digit, digits);
            num /= 10;
        }

        return sum == original;
    }

    public static void palindrom(String s) {
        int n = s.length();
        boolean isPalindrome = IntStream.range(0, n / 2)
                .allMatch(i -> s.charAt(i) == s.charAt(n - i - 1));

        if (isPalindrome) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not palindrome");
        }
    }
}
