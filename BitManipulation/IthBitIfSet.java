package BitManipulation;

public class IthBitIfSet {
    public static void main(String[] args) {
        int num = 13;
        int i = 2;
        if ((num & (1 << i)) == 0) {
            System.out.println("Bit not set");
        } else {
            System.out.println("Bit is set");
        }
    }
}
