package BitManipulation;

public class DivideTwoInt {
    public static void main(String[] args) {
        int dividend = -2147483648;
        int divisor = 1;

        // required overflow check
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            System.out.println(Integer.MAX_VALUE);
            return;
        }

        boolean sign = (dividend < 0) ^ (divisor < 0);

        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);

        long quo = 0;

        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            quo += 1L << cnt;
            n -= d << cnt;
        }

        if (sign)
            quo = -quo;

        System.out.println(quo);
    }
}