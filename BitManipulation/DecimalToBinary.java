package BitManipulation;

// x>>k=x/(2^k)
// x<<k=x*2^k
public class DecimalToBinary {
    public static void main(String[] args) {
        int num = 13;
        int binary = toBinary(num);
        System.out.println(binary);
        num = toDecimal(binary);
        System.out.println(num);
    }

    public static int toBinary(int num) {
        int binary = 0;
        int m = 1;
        while (num > 0) {
            binary = binary + (num % 2) * m;
            m = m * 10;
            num = num / 2;
        }
        return binary;
    }

    public static int toDecimal(int binary) {
        int num = 0;
        int m = 1;
        while (binary != 0) {
            num = num + (binary % 10) * m;
            m = m * 2;
            binary = binary / 10;
        }
        return num;
    }
}
