package BitManipulation;

public class ClearIthBit {
    public static void main(String[] args) {
        int num = 13;
        int i = 2;
        int result = (13 & ~(1 << i));
        System.out.println(result);
    }
}
