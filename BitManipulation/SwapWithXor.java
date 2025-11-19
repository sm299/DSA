package BitManipulation;

public class SwapWithXor {
    public static void main(String[] args) {
        int a = 5;
        int b = 10;
        System.out.printf("before swap a=%d and b=%d %n", a, b);
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.printf("after swap a=%d and b=%d %n", a, b);

    }
}
