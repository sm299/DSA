package BitManipulation;

//Last set bit is right most, First set bit is left most
public class LastBitSetZero {
    public static void main(String[] args) {
        int n = 84;
        System.out.println(n & (n - 1));
    }
}
