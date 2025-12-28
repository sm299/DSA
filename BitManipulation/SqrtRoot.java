package BitManipulation;

public class SqrtRoot {

        public static int sqrtBit(int n) {
            if (n < 0) {
                throw new IllegalArgumentException("Negative number");
            }

            int result = 0;
            int bit = 1 << 30; // Highest power of 4 within int range

            // Step 1: Move 'bit' to the highest power of 4 <= n
            while (bit > n) {
                bit >>= 2;
            }

            // Step 2: Build the result bit by bit
            while (bit != 0) {
                int temp = result + bit;

                // Check temp * temp <= n (using division to avoid overflow)
                if (temp <= n / temp) {
                    result = temp;
                }

                bit >>= 2; // Move to next lower power of 4
            }

            return result;
        }

        public static void main(String[] args) {
            int n = 25;
            System.out.println(sqrtBit(n)); // Output: 5
        }
}
