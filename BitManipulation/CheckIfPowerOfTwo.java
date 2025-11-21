package BitManipulation;

public class CheckIfPowerOfTwo {
    public static void main(String[] args) {
        int num = 16;
        if ((num & (num - 1)) == 0) {
            System.out.println("Power Of two");
        } else {
            System.out.println("Not a Power of two number");
        }
    }
}
