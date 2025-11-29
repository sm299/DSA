package BitManipulation;

public class MinBitFlipsToConvertNum {
    public static void main(String[] args) {
        int a = 11;
        int b = 15;
        int n = 11 ^ 15;
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        System.out.println(count);
        System.out.println(Integer.bitCount(11^15));
    }
}
